package com.ltp.employeebackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltp.employeebackend.Model.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
