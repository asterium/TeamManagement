package org.dimazay.tkgteammanagement.model.participation;

import org.dimazay.tkgteammanagement.model.User;

/**
 * Created by Asterium on 22.06.2017.
 */
public class IndividualParticipation {
    private User user;
    private ParticipationAvailability status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParticipationAvailability getStatus() {
        return status;
    }

    public void setStatus(ParticipationAvailability status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndividualParticipation that = (IndividualParticipation) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IndividualParticipation{" +
                "user=" + user +
                ", status=" + status +
                '}';
    }
}
