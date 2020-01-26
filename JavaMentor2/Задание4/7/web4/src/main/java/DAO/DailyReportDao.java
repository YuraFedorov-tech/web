package DAO;

import model.Car;
import model.DailyReport;
import org.hibernate.ScrollMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.ScrollMode.*;

public class DailyReportDao {

    private Session session;

    public DailyReportDao(Session session) {
        this.session = session;
    }

    public List<DailyReport> getAllDailyReport() {
   //     Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
        List<DailyReport> dailyReports2=new ArrayList<>();
        dailyReports.remove(dailyReports.size()-1);
        session.close();
        return dailyReports;
    }

    public void addOneBuying(Long price) {
        DailyReport dailyReportLast;
        Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
         if (dailyReports.size() == 0) {
            dailyReportLast = new DailyReport(price, 1L);
            session.save(dailyReportLast);
        } else {
            dailyReportLast = dailyReports.get(dailyReports.size() - 1);
            dailyReportLast.setEarnings(dailyReportLast.getEarnings()+price);
            dailyReportLast.setSoldCars(dailyReportLast.getSoldCars()+1L);
        }
        transaction.commit();
        session.close();

    }

    public void deleteAllBase() {
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from DailyReport").executeUpdate();
        session.createQuery("delete from Car").executeUpdate();
        transaction.commit();
        session.close();

    }

    public void addRowForNextDay() {
        Transaction transaction = session.beginTransaction();
        session.save(new DailyReport(0L,0L));
        transaction.commit();
        session.close();
    }
}
