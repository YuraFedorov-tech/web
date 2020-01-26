
/*
 *
 *@Data 21.01.2020
 *@autor Fedorov Yuri
 *@project 1
 *
 */

import javax.persistence.*;

@Entity
@Table(name = "banks_table")
public class Bank {


    @Id
    @Column(name="id")
    @GeneratedValue(generator = "incrementor")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

