package fr.norsys.Dao;

import fr.norsys.Entity.Department;
import fr.norsys.Entity.Employee;

import java.util.List;

public interface IEmployee {
    void save(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(Long id);
    List<Employee> findEmployeesByDepartment(Department department);
}
