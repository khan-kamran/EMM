package com.example.EMM.repository;

import com.example.EMM.entity.OfficeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeAddressRepository extends JpaRepository<OfficeAddress,Integer> {
    List<OfficeAddress> findBydName(String dname);
}
