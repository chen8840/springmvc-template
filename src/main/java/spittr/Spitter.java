package spittr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    private Long id;

    @NotNull
    @Size(min = 2)
    private String username;

    @NotNull
    @Size(min = 2, max = 10)
    private String password;

    @NotNull
    @Size(min = 2, max = 10, message = "{firstName.size}")
    private String firstName;

    @NotNull
    private String lastName;

    public Spitter() {}

    public Spitter(String username, String password, String firstName, String lastName) {
        this(null, username, password, firstName, lastName);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return null;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that,
                "password", "firstName", "lastName", "id");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,
                "password", "firstName", "lastName", "id");
    }
}
