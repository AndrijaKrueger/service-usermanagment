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

    private final String SYSTEM_NAME = "User Management Service";

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

            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "INFO", "init", "Created User in Database", null, null, null));
        } catch (Exception ex) {
            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "ERROR", "init", "Failed to created User in Database", null, ex.getMessage(), "Correct the Property"));
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
            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "INFO", "findAll", "Fetch all Users from Database", null, null, null));
        } catch (Exception ex) {
            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "ERROR", "findAll", "Failed to fetch all Users from Database", null, ex.getMessage(), "Correct the Property"));
        }
        return users;
    }

    public User findById(int id) {
        User user = null;
        try {
            EntityManager em = emf.createEntityManager();
            user = em.find(User.class, id);
            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "INFO", "findById", "Fetch User from Database", mapper.writeValueAsString(user), null, null));
        } catch (Exception ex) {
            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "ERROR", "findById", "Failed to fetch User from Database", null, ex.getMessage(), "Correct the Property"));
        }
        return user;
    }

    public User update(User user) {
        User mergedUser = null;
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            updateCalendar(user);

            mergedUser = em.merge(user);

            em.getTransaction().commit();
            em.close();

            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "INFO", "update", "Update User in Database", mapper.writeValueAsString(user), null, null));
        } catch (Exception ex) {
            LogHandler.logMessage(new LogMessage(SYSTEM_NAME, "ERROR", "findById", "Failed to update User from Database", null, ex.getMessage(), "Correct the Property"));
        }
        return mergedUser;
    }
}
