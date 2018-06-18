package de.xcrossworx.service.usermanagment.persistence;

import de.xcrossworx.service.usermanagment.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class UserDao {



    public UserDao() {
    }

//    public User findById(Long id) {
//        return get(id);
//    }
//
//    public long create(User user) {
//        return persist(user).getId();
//    }

    public List<User> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserDb_PU");
        EntityManager em = emf.createEntityManager();

        List<User> users = em.createNamedQuery("User.findAll").getResultList();
        return users;
    }

    public void init() {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserDb_PU");
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
