package my.rest.jersey;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserResourceTest {
	public static final String USER_URI = "http://localhost:8080/myjersey/users";

//	public String testGetUsersAll() {
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource resource = client.resource(ForumConstant.USER_URI);
//		ClientResponse response = resource.type(MediaType.APPLICATION_XML).get(
//				ClientResponse.class);
//		String en = response.getEntity(String.class);
//		return en;
//	}
//
//	public String testGetUsers() {
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource resource = client.resource(ForumConstant.USER_URI);
//		ClientResponse response = resource.type(MediaType.APPLICATION_XML).get(
//				ClientResponse.class);
//		String en = response.getEntity(String.class);
//		return en;
//	}
//
	@Test
	public void testCreateUser() {
		User user = new User("John", "johnPass", "john@ibm.com");
		Client client = Client.create();
		WebResource r = client.resource(USER_URI);
		ClientResponse response = r.accept(MediaType.APPLICATION_XML).post(ClientResponse.class, user);
		System.out.println(user.toString());
	}
}
