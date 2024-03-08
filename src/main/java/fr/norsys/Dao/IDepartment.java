package fr.norsys.Dao;

import fr.norsys.Entity.Department;
import fr.norsys.Entity.Employee;


public interface IDepartment {
    void save(Department department);
    void addEmployeeToDepartment(Employee employee, Department department);
    void deleteDepartment(Department department);
    public Department findDepartmentByEmployee(Employee employee);
}
