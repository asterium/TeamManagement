package org.dimazay.tkgteammanagement.persistence.interfaces;

import org.dimazay.tkgteammanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Asterium on 13.06.2017.
 */
public interface UserRepository extends MongoRepository<User, String> {

}
