package com.example.buildingrentalbe.service;

import com.example.buildingrentalbe.dto.PremisesDTO;
import com.example.buildingrentalbe.model.Premises;
import com.example.buildingrentalbe.repository.IPremisesRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PremisesService implements  IPremisesService{
    @Autowired
    private IPremisesRepository premisesRepository;

    @Override
    public List<Premises> findAll() {
        return premisesRepository.findAllPremises();
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

    @Override
    public void updatePremises(PremisesDTO premisesDTO) {
        Integer premisesId = premisesDTO.getId();
        String newCode = premisesDTO.getCode();

        Optional<Premises> optionalPremises = premisesRepository.findById(premisesId);
        if (optionalPremises.isEmpty()) {
            throw new RuntimeException("Không tìm thấy mặt bằng với id: " + premisesId);
        }

        Premises existingPremises = optionalPremises.get();
        String currentCode = existingPremises.getCode();

        if (!newCode.equals(currentCode)) {
            if (isCodeExists(newCode)) {
                throw new RuntimeException("Mã code đã tồn tại trong hệ thống");
            }
        }


        premisesRepository.updatePremises(
                premisesDTO.getId(),
                premisesDTO.getCode(),
                premisesDTO.getFloor(),
                premisesDTO.getArea(),
                premisesDTO.getDescription(),
                premisesDTO.getPrice(),
                premisesDTO.getCost(),
                premisesDTO.getTypePremises().getId(),
                premisesDTO.getPremisesStatus().getId()
        );
    }

    private boolean isCodeExists(String code) {
        Optional<Premises> optionalPremises = Optional.ofNullable(premisesRepository.findPremisesByCode(code));
        return optionalPremises.isPresent();
    }

}
