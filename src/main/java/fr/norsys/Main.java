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
        Employee employee1 = new Employee("ayoub", "ellaouzi", "Ayoub@example.com");
        Employee employee2 = new Employee("amine", "el", "khaid@example.com");
        Employee employee3 = new Employee("khalid", "em", "khalid@example.com");


        // Save employees
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        // Save departments
        departmentDao.save(department1);
        departmentDao.save(department2);
        departmentDao.save(department3);

        //add Employees To Departments
        departmentDao.addEmployeeToDepartment(employee1,department1);
        departmentDao.addEmployeeToDepartment(employee2,department2);
        departmentDao.addEmployeeToDepartment(employee3,department3);

        Employee e = employeeDao.findById(38L);// change ths id
        Department d = departmentDao.findDepartmentByEmployee(e);

        // RECHERCHER TOUS LES EMPLOYÉS
        List<Employee> employeeList =employeeDao.findEmployeesByDepartment(d);
        for (Employee emp : employeeList){
            System.out.println(emp.toString());
        }
        //SUPPRIMER UN EMPLOYÉ
        employeeDao.deleteEmployee(e);
        //SUPPRIMER UN DÉPARTEMENT.
        departmentDao.deleteDepartment(d);


     ;
    }
}
