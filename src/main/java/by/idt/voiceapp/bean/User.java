package by.idt.voiceapp.bean;

import java.util.Objects;

public class User {
    private int id;
    private String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(fullName);
        return hash > 0 ? hash : -hash;
    }
}
