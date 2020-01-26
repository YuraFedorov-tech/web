package service;

import DAO.CarDao;
import DAO.DailyReportDao;
import model.DailyReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class DailyReportService {

    private static DailyReportService dailyReportService;
    private SessionFactory sessionFactory;

    private DailyReportService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static DailyReportService getInstance() {
        if (dailyReportService == null) {
            dailyReportService = new DailyReportService(DBHelper.getSessionFactory());
        }
        return dailyReportService;
    }

    public List<DailyReport> getAllDailyReports() {
        return new DailyReportDao(sessionFactory.openSession()).getAllDailyReport();
    }


    public DailyReport getLastReport() {
        List<DailyReport> dailyReports = getAllDailyReports();
//        if (dailyReports.size() == 2)
//            return dailyReports.get(dailyReports.size() - 2);
        return dailyReports.get(dailyReports.size() - 2);
    }

    public void addOneBuying(Long price) {

        new DailyReportDao(sessionFactory.openSession()).addOneBuying(price);
    }

    public void deleteAllBase() {
        Session session = sessionFactory.openSession();
        new DailyReportDao(session).deleteAllBase();
        session.close();
    }

    public void addRowForNextDay() {
        new DailyReportDao(sessionFactory.openSession()).addRowForNextDay();
    }
}
