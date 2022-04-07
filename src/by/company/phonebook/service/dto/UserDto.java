package by.company.phonebook.service.dto;

import by.company.phonebook.entity.Role;

import java.util.Set;

public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roles;
    private Set<String> telephones;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != userDto.id) return false;
        if (firstName != null ? !firstName.equals(userDto.firstName) : userDto.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userDto.lastName) : userDto.lastName != null) return false;
        if (email != null ? !email.equals(userDto.email) : userDto.email != null) return false;
        if (roles != null ? !roles.equals(userDto.roles) : userDto.roles != null) return false;
        return telephones != null ? telephones.equals(userDto.telephones) : userDto.telephones == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (telephones != null ? telephones.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", telephones=" + telephones +
                '}';
    }

    public static class Builder {
        private UserDto user;

        public Builder() {
            user = new UserDto();
        }

        public UserDto.Builder setId(long id) {
            user.id = id;
            return this;
        }


        public UserDto.Builder setFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public UserDto.Builder setLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public UserDto.Builder setEmail(String email) {
            user.email = email;
            return this;
        }

        public UserDto.Builder setRoles(Set<Role> roles) {
            user.roles = roles;
            return this;
        }

        public UserDto.Builder setTelephones(Set<String> telephones) {
            user.telephones = telephones;
            return this;
        }

        public UserDto build() {
            return user;
        }

    }
}
