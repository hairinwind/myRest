package my.rest.jersey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
	private static UserService userService = new UserService();
	private static Map<Long, User> usersMap = new ConcurrentHashMap<Long, User>();

	public List<User> getUserAll() {
		return new ArrayList<User>(usersMap.values());
	}

	public List<User> getUserByName(String name) {
		List<User> result = new ArrayList<User>();
		for (User user : usersMap.values()) {
			if (user.getUserName().equalsIgnoreCase(name)) {
				result.add(user);
			}
		}
		return result;
	}

	public void CreateUser(User user) {
		user.setId(getNextId());
		usersMap.put(user.getId(), user);
	}

	private synchronized Long getNextId() {
		Long nextId;
		if (usersMap.keySet() == null || usersMap.keySet().isEmpty()) {
			nextId = 1L;
		} else {
			nextId = Collections.max(usersMap.keySet()) + 1;
		}
		usersMap.put(nextId, new User());
		return nextId;
	}

	public static UserService getInstance() {
		return userService;
	}
}
