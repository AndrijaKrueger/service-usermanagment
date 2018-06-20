package de.xcrossworx.service.usermanagment.App;

import de.xcrossworx.service.usermanagment.healthcheck.UserResourceHealthCheck;
import de.xcrossworx.service.usermanagment.persistence.UserDao;
import de.xcrossworx.service.usermanagment.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserManagmentApplication extends Application<UserManagmentConfiguration> {

    public static void main(String[] args) throws Exception {
        new UserManagmentApplication().run(args);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void initialize(Bootstrap<UserManagmentConfiguration> bootstrap) {
    }

    public void run(UserManagmentConfiguration userManagmentConfiguration, Environment environment) throws Exception {
        final UserDao userDao = new UserDao();

        final UserResource userResource = new UserResource(userDao);
        environment.jersey().register(userResource);

        final UserResourceHealthCheck userResourceHealthCheck = new UserResourceHealthCheck();
        environment.healthChecks().register("template", userResourceHealthCheck);
    }

}
