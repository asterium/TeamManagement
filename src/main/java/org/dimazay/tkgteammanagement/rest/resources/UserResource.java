package org.dimazay.tkgteammanagement.rest.resources;

import org.dimazay.tkgteammanagement.model.User;
import org.dimazay.tkgteammanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Asterium on 09.06.2017.
 */
@RestController
@RequestMapping(ResourceConstants.USERS_RESOURSE_PATH)
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> registerUser(@RequestBody User user){
        userRepository.add(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

}
