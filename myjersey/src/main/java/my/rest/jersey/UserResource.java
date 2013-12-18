package my.rest.jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UserResource {
	@Context
	UriInfo uriInfo;

	@GET
	@Produces("application/xml")
	public List<User> getUsersAll() {
		List<User> als = null;
		als = UserService.getInstance().getUserAll();
		return als;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	public User createUser(User user) {
//		URI uri = uriInfo.getAbsolutePathBuilder().path(user.getUserName()).build();
//		Response res = Response.created(uri).build();
		UserService.getInstance().CreateUser(user);
		return user;
	}

	@Path("/user/{username}")
	@GET
	@Produces("application/xml")
	public List<User> getUser(@PathParam("username") String username) {
		List<User> asl = null;
		asl = UserService.getInstance().getUserByName(username);
		return asl;
	}
}