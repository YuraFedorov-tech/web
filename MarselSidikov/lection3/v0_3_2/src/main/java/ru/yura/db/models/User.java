package ru.yura.db.models;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */
public class User {
    private Long id;
    private String name;
    private String password;
    Long money;

    public User(String name, String password, Long money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }



    public User(Long id, String name, String password, Long money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
    }
}
