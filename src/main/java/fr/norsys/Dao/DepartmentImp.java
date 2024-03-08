package fr.norsys.Dao;

import fr.norsys.Entity.Department;
import fr.norsys.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.norsys.Util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class DepartmentImp implements IDepartment {

    @Override
    public void addEmployeeToDepartment(Employee employee, Department department) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            department.getEmployees().add(employee);
            employee.setDepartment(department);

            session.save(employee); // Or session.update(employee) if employee already exists
            transaction.commit();
            System.out.println("Employee added to department successfully!");
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
    public Department findDepartmentByEmployee(Employee employee) {
        Session session = null;
        Department department = null;

        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("SELECT e.department FROM Employee e WHERE e = :employee");
            query.setParameter("employee", employee);
            department = (Department) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("L'employé n'appartient à aucun département.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
        return department;
    }


    @Override
    public void deleteDepartment(Department department) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
            System.out.println("Department deleted successfully!");
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
    public void save(Department department) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            System.out.println("department saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }
}
