package de.xcrossworx.service.usermanagment.persistence;

import de.xcrossworx.service.usermanagment.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class UserDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserDb_PU");


    public UserDao() {
    }

    public User findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    public User update(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();
        em.close();
        return user;
    }

    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createNamedQuery("User.findAll").getResultList();
        return users;
    }

    public void init() {
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(new User(0,"Andrija"));
            em.persist(new User(0,"Roman"));
            em.persist(new User(0,"Kea"));
            em.persist(new User(0,"Roland"));
            em.persist(new User(0,"Samir"));
            em.persist(new User(0,"Yvette"));

            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }
}
