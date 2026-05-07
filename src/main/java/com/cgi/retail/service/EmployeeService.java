package com.cgi.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.retail.entity.Employee;
import com.cgi.retail.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	
	public Employee save(Employee emp)
	{
		return repo.save(emp);
	}
	
	public List<Employee> getAll() {
        return repo.findAll();
    }
	

    public Employee getById(Integer id) {
        return repo.findById(id).orElse(null);
    }
    

    public Employee update(Integer id, Employee emp) {

        Employee existing = repo.findById(id).orElse(null);
        
        if(existing != null) {
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setSalary(emp.getSalary());

            return repo.save(existing);
        }

        return null;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
