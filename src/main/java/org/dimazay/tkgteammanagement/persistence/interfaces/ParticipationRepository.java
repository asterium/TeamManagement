package org.dimazay.tkgteammanagement.persistence.interfaces;

import org.bson.types.ObjectId;
import org.dimazay.tkgteammanagement.model.participation.Participation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Asterium on 22.06.2017.
 */
public interface ParticipationRepository extends MongoRepository<Participation, String> {
    @Query(value="{eventId : ?0}")
    public Participation findByEventId(ObjectId eventId);

}
