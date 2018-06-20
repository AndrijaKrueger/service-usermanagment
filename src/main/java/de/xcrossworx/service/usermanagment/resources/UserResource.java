package de.xcrossworx.service.usermanagment.resources;

import com.codahale.metrics.annotation.Timed;
import de.xcrossworx.service.usermanagment.model.User;
import de.xcrossworx.service.usermanagment.persistence.UserDao;

import javax.ws.rs.*;
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
    public Response initUsers() {
        userDao.init();
        return Response.ok(" Init all Users in Db").build();
    }

    @GET
    @Path("/getAll")
    @Timed
    public Response getAll() {
        List<User> users = userDao.findAll();
        return Response.ok().entity(users).build();
    }

    @GET
    @Path("/get/{id}")
    @Timed
    public Response getById(@PathParam("id") int id) {
        User user = userDao.findById(id);

        if (user == null) return Response.noContent().entity("User with Id: " + id + " was not found").build();

        return Response.ok().entity(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response updateUser(User user){
        if(user == null) return Response.noContent().entity("User Entity was empty").build();

        user = userDao.update(user);

        return Response.ok().entity(user).build();
    }
}
