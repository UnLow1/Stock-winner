package pl.stockWinner.models.dto;

// TODO use lombok
public class AuthenticationResponseDto {
    private String token;

    public AuthenticationResponseDto(String token) {
        this.token = token;
    }

    public AuthenticationResponseDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
