package edu.eci.arep.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO {

    private final List<User> users = new ArrayList<>(Arrays.asList(
            new User("davor.cortes@arep.eci", "EciStore123"),
            new User("javier.cortes@arep.eci", "EciStore456")
            ) );

    public User getUserByEmail(String email){
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
}
