package com.ltp.employeebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.employeebackend.Model.Emp;
import com.ltp.employeebackend.Service.EmpService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/save")
    public ResponseEntity<Emp> createEmp(@RequestBody Emp emp) {
        return new ResponseEntity<Emp>(empService.createEmp(emp), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Emp>> getAllEmp() {
        return new ResponseEntity<>(empService.getAllEmp(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emp> getEmpbyId(@PathVariable int id) {
        return new ResponseEntity<>(empService.getEmpbyId(id), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable int id) {
        empService.deletebyId(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Emp> updateEmp(@PathVariable int id, @RequestBody Emp emp) {
        return new ResponseEntity<>(empService.updateEmp(id, emp), HttpStatus.OK);
    }
}
