package pl.stockWinner.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

    @JsonProperty("userMail")
    @Size(min = 4, max = 50)
    @NotNull
    private String userMail;

    @JsonProperty("password")
    @Size(min = 4, max = 100)
    @NotNull
    private String password;

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
