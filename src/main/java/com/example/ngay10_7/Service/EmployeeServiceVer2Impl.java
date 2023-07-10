package com.example.ngay10_7.Service;

import com.example.ngay10_7.Model.Employee;
import com.example.ngay10_7.Repository.EmployeeRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Order(2)
//@Order để xác định thứ tự ưu tiên của EmployeeServiceVer2Impl
public class EmployeeServiceVer2Impl implements EmployeeService {

    //@Resource để tiêm instance của EmployeeRepository vào EmployeeServiceVer2Impl
    @Resource
    private EmployeeRepository employeeRepository;

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
