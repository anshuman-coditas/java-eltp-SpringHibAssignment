package Dao;

import com.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.util.List;

public class EmployeeDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(Employee e){
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(e);
        transaction.commit();

    }

    public List<Employee> fetchAll(){
        Session session=sessionFactory.openSession();
        List<Employee> employees=session.createQuery("from Employee").list();
        return employees;
    }


    public void update(int id,String d){
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Query q=session.createQuery("update Employee set designation=:x where id=:y");
        q.setParameter("x",d);
        q.setParameter("y",id);
        q.executeUpdate();
        transaction.commit();
        session.close();

    }


    public void delete(int id){
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Employee e=session.find(Employee.class,id);
        session.delete(e);
        transaction.commit();
    }
}
