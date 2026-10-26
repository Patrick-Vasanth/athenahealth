package org.example.athenahealth.dto;

import org.example.athenahealth.utilities.User;

public class LoginResponse {
    private Long userId;
    private String username;
    private User.Role role;
    private String message;

    public LoginResponse(
            Long userId,
            String username,
            User.Role role,
            String message) {

        this.userId = userId;
        this.username = username;
        this.role = role;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public User.Role getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}
