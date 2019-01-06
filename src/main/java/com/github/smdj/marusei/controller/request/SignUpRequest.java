package com.github.smdj.marusei.controller.request;

import javax.validation.constraints.*;
import java.util.StringJoiner;

public class SignUpRequest {
    @Email
    @NotNull
    @NotEmpty
    @Size(max = 128)
    private String email;

    @NotEmpty
    @Size(max = 15)
    @Pattern(regexp = "\\S+")
    private String nickname;

    @Size(min = 8)
    private String password;

    @Size(min = 8)
    private String passwordConfirm;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SignUpRequest.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("nickname='" + nickname + "'")
                .add("password='" + password + "'")
                .add("passwordConfirm='" + passwordConfirm + "'")
                .toString();
    }

}
