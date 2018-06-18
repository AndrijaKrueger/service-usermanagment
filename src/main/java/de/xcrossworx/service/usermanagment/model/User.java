package de.xcrossworx.service.usermanagment.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@NamedQueries({@NamedQuery(name = "User.findAll", query = "select e from User e")})
public class User extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact contacts;

    public User() {
    }

    public User(int id, String name, Contact contacts) {
        setId(id);
        setName(name);
        this.contacts = contacts;
    }

    public Contact getContacts() {
        return contacts;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }
}
