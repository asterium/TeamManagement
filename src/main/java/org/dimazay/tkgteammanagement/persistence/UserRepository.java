package org.dimazay.tkgteammanagement.persistence;

import org.dimazay.tkgteammanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Asterium on 12.06.2017.
 */
@Component
public class UserRepository {

    private Set<User> users = new HashSet<>();

    public void add(User user){
        users.add(user);
    }

    public List<User> findAll(){
        return new ArrayList<>(users);
    }
}
