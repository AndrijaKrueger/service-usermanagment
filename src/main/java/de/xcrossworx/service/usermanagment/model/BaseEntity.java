package de.xcrossworx.service.usermanagment.model;

import javax.persistence.*;
import java.util.Calendar;

@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Calendar created;

    @Temporal(TemporalType.DATE)
    private Calendar modified;

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

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public Calendar getModified() {
        return modified;
    }

    public void setModified(Calendar modified) {
        this.modified = modified;
    }

}
