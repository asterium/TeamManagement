package org.dimazay.tkgteammanagement.model;

/**
 * Created by Asterium on 09.06.2017.
 */
public class User {
    private String email;
    private Long id;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
