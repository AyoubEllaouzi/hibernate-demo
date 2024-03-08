package fr.norsys;

import fr.norsys.Dao.DepartmentImp;
import fr.norsys.Dao.EmployeeImp;
import fr.norsys.Entity.Department;
import fr.norsys.Entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeImp employeeDao = new EmployeeImp();
        DepartmentImp departmentDao = new DepartmentImp();

        // Create Department instances
        Department department1 = new Department("Info");
        Department department2 = new Department("Phys");
        Department department3 = new Department("Chem");


        // Create Employee instances
        Employee employee1 = new Employee("John", "Doe", "john@example.com");
        Employee employee2 = new Employee("Jane", "Smith", "jane@example.com");
        Employee employee3 = new Employee("Alice", "Johnson", "alice@example.com");



        List<Employee> empList1 = new ArrayList<>();
        List<Employee> empList2 = new ArrayList<>();
        List<Employee> empList3 = new ArrayList<>();

        empList1.add(employee1);
        empList2.add(employee2);
        empList3.add(employee3);

        department1.setEmployees(empList1);
        department2.setEmployees(empList2);
        department3.setEmployees(empList3);

        // Save employees
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        // Save departments
        departmentDao.save(department1);
        departmentDao.save(department2);
        departmentDao.save(department3);

    }
}
