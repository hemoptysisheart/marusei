package com.github.smdj.marusei.service.params;

import java.util.StringJoiner;

public class CreateAccountParams {
    private String email;
    private String nickname;
    private String password;


    public CreateAccountParams() {
    }

    public CreateAccountParams(String email) {
        this(email, null);
    }

    public CreateAccountParams(String email, String nickname) {
        this(email, nickname, null);
    }

    public CreateAccountParams(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateAccountParams.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("nickname='" + nickname + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
