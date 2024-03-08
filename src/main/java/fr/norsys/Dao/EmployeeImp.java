package fr.norsys.Dao;

import fr.norsys.Entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.norsys.Entity.Employee;
import fr.norsys.Util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImp implements IEmployee {

    @Override
    public void save(Employee employee) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            System.out.println("Employee saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            System.out.println("Employee updated successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            System.out.println("Employee deleted successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public List<Employee> findAll() {
        Session session = null;
        List<Employee> employees = null;

        try {
            session = HibernateUtil.getSession();
            employees = session.createQuery("FROM Employee", Employee.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        Session session = null;
        Employee employee = null;

        try {
            session = HibernateUtil.getSession();
            employee = session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployeesByDepartment(Department department) {
        Session session = null;
        List<Employee> employees = new ArrayList<>();

        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("SELECT e FROM Employee e WHERE e.department = :department");
            query.setParameter("department", department);
            employees = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return employees;
    }


}
