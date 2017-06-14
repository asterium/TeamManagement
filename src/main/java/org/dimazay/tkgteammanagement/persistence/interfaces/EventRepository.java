package org.dimazay.tkgteammanagement.persistence.interfaces;

import org.dimazay.tkgteammanagement.model.events.Event;
import org.dimazay.tkgteammanagement.model.events.EventType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Asterium on 13.06.2017.
 */

public interface EventRepository extends MongoRepository<Event, String> {
    public Event findByTitle(String title);
}