package app.worklib.web.ws.ui.model.request;

import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @javax.validation.constraints.NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First name muts not be less than 2 charathrecs")
    private String firstName;
    @javax.validation.constraints.NotNull(message = "Last name cannot be null")
    private String lastName;

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
}
