package app.worklib.web.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.*;


public class UserDetailsRequestModel {

    @javax.validation.constraints.NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First name muts not be less than 2 charathrecs")
    private String firstName;
    @javax.validation.constraints.NotNull(message = "Last name cannot be null")
    private String lastName;

    @javax.validation.constraints.NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @javax.validation.constraints.NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be equal or greter than 8 charachters")
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
