package org.dimazay.tkgteammanagement.model.participation;

import org.dimazay.tkgteammanagement.model.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Asterium on 22.06.2017.
 */
public class Participation {
    private String id;
    private String meetingId;
    private List<IndividualParticipation> participants;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public List<IndividualParticipation> getParticipants() {
        return participants;
    }

    public void setParticipants(List<IndividualParticipation> participants) {
        this.participants = participants;
    }

    public void addParticipation(IndividualParticipation participation){
        this.participants.add(participation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participation that = (Participation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (meetingId != null ? !meetingId.equals(that.meetingId) : that.meetingId != null) return false;
        return participants != null ? participants.equals(that.participants) : that.participants == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (meetingId != null ? meetingId.hashCode() : 0);
        result = 31 * result + (participants != null ? participants.hashCode() : 0);
        return result;
    }


}
