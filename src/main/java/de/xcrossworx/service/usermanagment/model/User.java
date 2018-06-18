package de.xcrossworx.service.usermanagment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({@NamedQuery(name = "User.findAll", query = "select e from User e")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String blubber;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contacts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContacts() {
        return contacts;
    }

    public String getBlubber() {
        return blubber;
    }

    public void setBlubber(String blubber) {
        this.blubber = blubber;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        contacts = new Contact("andi@serv.com", "gzgdffgdh", "ahgjhsdgfjsdgh");
    }
}
