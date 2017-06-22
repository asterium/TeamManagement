package org.dimazay.tkgteammanagement.rest.resources;

import org.bson.types.ObjectId;
import org.dimazay.tkgteammanagement.model.events.Event;
import org.dimazay.tkgteammanagement.model.participation.IndividualParticipation;
import org.dimazay.tkgteammanagement.model.participation.Participation;
import org.dimazay.tkgteammanagement.persistence.interfaces.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Asterium on 16.06.2017.
 */

@RequestMapping(ResourceConstants.EVENT_RESOURSE_PATH)
public class EventParticipationResource {

    @Autowired
    private ParticipationRepository participationRepository;


    @RequestMapping(path = "/{eventId}/participations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Participation> setParticipationData(@PathVariable("eventId") String eventId, @RequestBody IndividualParticipation individualParticipation){
        Participation participation = participationRepository.findByEventId(new ObjectId(eventId));
        participation.addParticipation(individualParticipation);
        participationRepository.save(participation);
        return new ResponseEntity<>(participation, HttpStatus.OK);
    }

    @RequestMapping(path = "/{eventId}/participations", method = RequestMethod.GET)
    public ResponseEntity<Participation> getAllEventParticipations(@PathVariable("eventId") String eventId){
        Participation participation = participationRepository.findByEventId(new ObjectId(eventId));
        return new ResponseEntity<>(participation, HttpStatus.OK);
    }

}
