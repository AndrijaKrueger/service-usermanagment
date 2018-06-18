package de.xcrossworx.service.usermanagment.persistence;

import de.xcrossworx.service.usermanagment.model.Contact;
import de.xcrossworx.service.usermanagment.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.List;


public class UserDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserDb_PU");


    public UserDao() {
    }

    public void init() {
        try{
            update(new User(0,"Andrija", new Contact()));
            update(new User(0,"Roman", new Contact()));
            update(new User(0,"Kea", new Contact()));
            update(new User(0,"Roland", new Contact()));
            update(new User(0,"Samir", new Contact()));
            update(new User(0,"Yvette", new Contact()));
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }

    private void updateCalendar(User user) {
        if(user == null) return;

        Calendar now = Calendar.getInstance();

        if(user.getId() == 0) user.setCreated(now);

        user.setModified(now);
    }

    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createNamedQuery("User.findAll").getResultList();
        return users;
    }

    public User findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    public User update(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        updateCalendar(user);

        User mergedUser = em.merge(user);

        em.getTransaction().commit();
        em.close();
        return mergedUser;
    }
}
