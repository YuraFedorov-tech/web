
/*
 *
 *@Data 21.01.2020
 *@autor Fedorov Yuri
 *@project 1
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String []args){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        Client client=new Client();
        client.setId(3);
        client.setName("Yura");

        Bank bank=new Bank();
        bank.setId(10);
        bank.setName("Morgan");

        EntityManager entityManager=factory.createEntityManager();
    //    entityManager.persist(client);
   //     entityManager.persist(bank);
        entityManager.getTransaction().commit();
    }
}
