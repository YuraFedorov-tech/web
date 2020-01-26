package ru.yura.dao;
/*
 *
 *@Data 20.01.2020
 *@autor Fedorov Yuri
 *@project Hibernate example
 *
 */

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.yura.model.Engine;

public class EngineDAO implements DAO <Engine,String> {
    private final SessionFactory factory;

    public EngineDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    public void create(@NotNull final Engine engine) {
     try(final Session session=factory.openSession()){
         session.beginTransaction();
         session.save(engine);
         session.getTransaction().commit();
     }
    }

    public Engine read(String s) {
        return null;
    }

    public void update(Engine engine) {

    }

    public void delete(Engine engine) {

    }
}
