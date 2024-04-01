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
import java.util.Objects;

@Service
public class PremisesService implements IPremisesService {
    @Autowired
    private IPremisesRepository premisesRepository;

    static List<Integer> listFloor = new ArrayList<>();
    static {
        listFloor.add(1);
        listFloor.add(2);
        listFloor.add(3);
        listFloor.add(4);
        listFloor.add(5);
        listFloor.add(6);
        listFloor.add(7);
    }
    public static List<Integer> getListFloor(){
        return new ArrayList<>(listFloor);
    }


    @Override
    public List<Premises> findAll() {
        return premisesRepository.findAllPremises();
    }

    @Override
    public Page<Premises> searchPremises(Integer floor, String code, Float area, String premisesName, Pageable pageable) {
        Specification<Premises> spec = (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (floor != null) {
                predicates.add(criteriaBuilder.equal(root.get("floor"), floor));
            }
            if (code != null && !code.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("code"), "%" + code + "%"));
            }
            if (area != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("area"), area));
            }
            if (premisesName != null && !premisesName.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("typePremises").get("name"), "%" + premisesName + "%"));
            }


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
    public void updatePremises(int id, Premises premises) {
        if (Objects.equals(premises.getCode(), findById(id).getCode()) || (findById(id)!=null && findPremisesByCode(premises.getCode())==null)){
            premisesRepository.updatePremises(id, premises);
        }
    }

    @Override
    public List<Premises> findByStatus() {
        return premisesRepository.findByStatus();
    }
}
