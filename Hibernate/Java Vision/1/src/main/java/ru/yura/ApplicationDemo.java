package ru.yura.model.ru.ru.yura;
/*
 *
 *@Data 20.01.2020
 *@autor Fedorov Yuri
 *@project Hibernate example
 *
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yura.dao.DAO;
import ru.yura.dao.EngineDAO;
import ru.yura.model.Engine;

//import ru.javavision.dao.DAO;
//import ru.javavision.dao.EngineDAO;
//import ru.javavision.model.Engine;

public class ApplicationDemo {
    public static void main(String[] args) {
        SessionFactory factory=null;
        factory=new Configuration().configure().buildSessionFactory();
        final Engine engine = new Engine();
        engine.setModel("engine_model_03");
        engine.setPower(12345);
        DAO<Engine, String> engineDAO = new EngineDAO(factory);
        engineDAO.create(engine);

    }


}
