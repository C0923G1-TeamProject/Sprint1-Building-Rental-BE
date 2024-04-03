package com.example.buildingrentalbe.repository;

import com.example.buildingrentalbe.dto.ImageDto;
import com.example.buildingrentalbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select employee.* from employee join account on employee.id = account.id_employee where account.username = :username", nativeQuery = true)
    public Employee findByUsernameAccount(@Param("username") String username);

    @Query(value = "select * from employee where email = :email", nativeQuery = true)
    Employee findAccountByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query(value = "update employee set name = :#{#employee.name},address = :#{#employee.address},date = :#{#employee.date}, " +
            "email= :#{#employee.email}, gender= :#{#employee.gender} where id= :#{#employee.id}", nativeQuery = true)
    void updateInformationUser(@Param("employee") Employee employee);


    @Transactional
    @Modifying
    @Query(value = "update employee set profile_picture = :#{#imageDto.imageUrl} where id = :#{#imageDto.id}", nativeQuery = true)
    void updateImageUser(@Param("imageDto") ImageDto imageDto);

}
