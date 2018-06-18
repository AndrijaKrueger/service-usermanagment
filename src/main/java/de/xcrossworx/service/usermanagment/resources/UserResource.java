package de.xcrossworx.service.usermanagment.resources;

import com.codahale.metrics.annotation.Timed;
import de.xcrossworx.service.usermanagment.model.User;
import de.xcrossworx.service.usermanagment.persistence.UserDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.jersey.PATCH;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user-resource")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserDao userDao;

    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Timed
    public Response checkResource() {
        return Response.ok().entity("User Resource is here !!!!").build();
    }

    @GET
    @Path("/init")
    @Timed
    @UnitOfWork
    public Response initUsers() {
        userDao.init();
        return Response.ok(" Init all Users in Db").build();
    }

    @GET
    @Path("/getAll")
    @Timed
    @UnitOfWork
    public Response getAll() {
        List<User> users = userDao.findAll();
        return Response.ok().entity(users).build();
    }
}
