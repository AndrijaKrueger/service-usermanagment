package de.xcrossworx.service.usermanagment.App;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;


public class UserManagmentConfiguration extends Configuration {

    @NotEmpty
    private static String defaultName = "User Management Service";

    public static String getServiceName() {
        return defaultName;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
