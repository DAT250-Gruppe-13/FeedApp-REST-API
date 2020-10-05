package no.hvl.dat250.FeedApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat250.FeedApp.DAO.UserDAO;
import no.hvl.dat250.FeedApp.Models.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> readAllUsers() {
        return userDAO.read();
    }

    public User readUserById(int id) {
        return userDAO.read(id);
    }

    public void createUser(User user) {
        userDAO.create(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }
}
