package de.xcrossworx.service.usermanagment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@NamedQueries({@NamedQuery(name = "Contact.findAll", query = "select c from Contact c")})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;

    @JsonProperty
    private String mail;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String mobile;

    public Contact() {
    }

    public Contact(String mail, String phone, String mobile) {
        this.mail = mail;
        this.phone = phone;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
