package org.dimazay.tkgteammanagement.model.participation;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asterium on 22.06.2017.
 */
public class Participation {
    @Id
    private String id;
    private String eventId;
    private List<IndividualParticipation> participants;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public List<IndividualParticipation> getParticipants() {
        return participants;
    }

    public void setParticipants(List<IndividualParticipation> participants) {
        this.participants = participants;
    }

    public void addParticipation(IndividualParticipation participation){
        if(participants == null){
            participants = new ArrayList<>();
        }
        this.participants.add(participation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participation that = (Participation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        return participants != null ? participants.equals(that.participants) : that.participants == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (participants != null ? participants.hashCode() : 0);
        return result;
    }


}
