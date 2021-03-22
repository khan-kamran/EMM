package com.example.EMM.repository;

import com.example.EMM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select count(*) from Employee",nativeQuery = true)
    Integer getCountOfEmployee();

    @Query(value = "select count(*) from Employee where status = 1",nativeQuery = true)
    Integer getEnableCount();
}
