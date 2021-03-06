package de.xcrossworx.service.usermanagment.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "Contacts")
@NamedQueries({@NamedQuery(name = "Contact.findAll", query = "select c from Contact c")})
public class Contact extends BaseEntity {

    private String mail;

    private String phone;

    private String mobile;


    public Contact() {
        setCreated(Calendar.getInstance());
        setModified(Calendar.getInstance());
    }

    public Contact(int id, String name, String mail, String phone, String mobile) {
        setId(id);
        setName(name);
        setCreated(Calendar.getInstance());
        setModified(Calendar.getInstance());

        this.mail = mail;
        this.phone = phone;
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
