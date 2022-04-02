package com.mustafa.springbootrestfulapi.serviceImpl;

import com.mustafa.springbootrestfulapi.exception.ResourceNotFoundExeption;
import com.mustafa.springbootrestfulapi.model.Employee;
import com.mustafa.springbootrestfulapi.repository.EmployeeRepository;
import com.mustafa.springbootrestfulapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExeption("Employee", "Id", "Id", id));

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExeption("Employee", "Id,", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        repository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public void deleteEmployee(Long id) {
        repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExeption("Employee", "Id,", "Id", id));

        repository.deleteById(id);
    }
}
