package com.ltp.employeebackend.Service;

import java.util.List;

import com.ltp.employeebackend.Model.Emp;

public interface EmpService {

    public Emp createEmp(Emp emp);

    public List<Emp> getAllEmp();

    public Emp getEmpbyId(int id);

    public void deletebyId(int id);

    public Emp updateEmp(int id, Emp emp);

}
