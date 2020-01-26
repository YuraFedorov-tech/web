
/*
 *
 *@Data 21.01.2020
 *@autor Fedorov Yuri
 *@project 1
 *
 */

import javax.persistence.*;

@Entity
@Table(name="client_table")
public class Client {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "incrementor")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="name")
    private String name;

}
