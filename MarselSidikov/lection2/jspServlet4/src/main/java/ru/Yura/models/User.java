package ru.Yura.models;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.time.LocalDate;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private String password;
    LocalDate birthday;

    public User(String name, String password, LocalDate birthday) {
        this.name = name;
        this.password = password;
        this.password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        this.birthday = birthday;
    }
}
/*
 String password = "1234";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
// $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
// result.verified == true
 */