package com.example.sysbiblioteca.persistence;


import com.example.sysbiblioteca.model.entity.Livro;
import com.example.sysbiblioteca.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;


public class LivroDAO {
    public void save(Livro livro){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    public List<Livro> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Livro> query = session.createQuery("from Livro", Livro.class);
            return query.list();
        }
    }

    public Livro findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Livro.class, id);
        }
    }

    public void update(Livro livro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Livro livro = session.get(Livro.class, id);
            if (livro != null) {
                session.delete(livro);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
