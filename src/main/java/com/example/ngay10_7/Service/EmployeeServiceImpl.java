package com.example.ngay10_7.Service;

import com.example.ngay10_7.Model.Employee;
import com.example.ngay10_7.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@Order(1)
public class EmployeeServiceImpl implements EmployeeService {

//    Tiêm instance của EmployeeRepository vào EmployeeServiceImpl bằng constructor
    public EmployeeRepository employeeRepository;
//    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
employeeRepository.updateEmployee(employee.getId(),employee.getName(),employee.getEmail(),employee.getDepartment());
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
