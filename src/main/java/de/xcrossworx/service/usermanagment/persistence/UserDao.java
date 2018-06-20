package de.xcrossworx.service.usermanagment.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.xcrossworx.service.usermanagment.handler.LogHandler;
import de.xcrossworx.service.usermanagment.model.Contact;
import de.xcrossworx.service.usermanagment.model.LogMessage;
import de.xcrossworx.service.usermanagment.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class UserDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Postgres_PU");
    private ObjectMapper mapper = new ObjectMapper();

    public UserDao() {
    }

    public void init() {
        try {
            update(new User(0, "Andrija", new Contact()));
            update(new User(0, "Roman", new Contact()));
            update(new User(0, "Kea", new Contact()));
            update(new User(0, "Roland", new Contact()));
            update(new User(0, "Samir", new Contact()));
            update(new User(0, "Yvette", new Contact()));

            LogHandler.logMessage("init", "Created Base Users", null);
        } catch (Exception ex) {
            LogHandler.logErrorMessage("init", ex);
        }
    }

    private void updateCalendar(User user) {
        if (user == null) return;

        Calendar now = Calendar.getInstance();

        if (user.getId() == 0) user.setCreated(now);

        user.setModified(now);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            EntityManager em = emf.createEntityManager();
            users = em.createNamedQuery("User.findAll").getResultList();

            LogHandler.logMessage("findAll", "Fetch all Users from Database", null);
        } catch (Exception ex) {
            LogHandler.logErrorMessage("findAll", ex);
        }
        return users;
    }

    public User findById(int id) {
        User user = null;
        try {
            EntityManager em = emf.createEntityManager();
            user = em.find(User.class, id);
            LogHandler.logMessage("findById", "Fetch User with id: " + id, mapper.writeValueAsString(user));
        } catch (Exception ex) {
            LogHandler.logErrorMessage("findById", ex);
        }
        return user;
    }

    public User update(User user) {
        User mergedUser = null;
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            updateCalendar(user);
            user.checkContact();

            mergedUser = em.merge(user);

            em.getTransaction().commit();
            em.close();

            LogHandler.logMessage("update", "Update User in Database", mapper.writeValueAsString(mergedUser));
        } catch (Exception ex) {
            LogHandler.logErrorMessage("update", ex);
        }
        return mergedUser;
    }
}
