package com.example.buildingrentalbe.service.impl;

import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.repository.IPremisesRepository;
import com.example.buildingrentalbe.service.IPremisesService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PremisesService implements IPremisesService {
    @Autowired
    private IPremisesRepository premisesRepository;

    @Override
    public Page<Premises> findAll(String searchTypePremises, Pageable pageable, String typePremises) {
        if (typePremises != null && typePremises != "") {
            int typePremisesId = Integer.parseInt(typePremises);
            return premisesRepository.searchWithTypePremises(typePremisesId, pageable);
        }
        return premisesRepository.search("%" + searchTypePremises + "%", pageable);
    }

    @Override
    public Page<Premises> searchPremises(Integer floor, String code, Float area, String premisesName, Pageable pageable) {
        Specification<Premises> spec = (root, query, criteriaBuilder) -> {
            // Tạo một danh sách các điều kiện tìm kiếm
            List<Predicate> predicates = new ArrayList<>();

            // Thêm điều kiện cho mỗi trường nếu có giá trị được cung cấp
            if (floor != null) {
                predicates.add(criteriaBuilder.equal(root.get("floor"), floor));
            }
            if (code != null && !code.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("code"), code));
            }
            if (area != null) {
                predicates.add(criteriaBuilder.equal(root.get("area"), area));
            }
            if (premisesName != null && !premisesName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("typePremises").get("name"), premisesName));
            }

            // Kết hợp tất cả các điều kiện lại với nhau
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return premisesRepository.findAll(spec, pageable);
    }

    @Override
    public Premises findPremisesByCode(String code) {
        return premisesRepository.findPremisesByCode(code);
    }

    @Override
    public Premises findById(int id) {
        return premisesRepository.findById(id);
    }

}
