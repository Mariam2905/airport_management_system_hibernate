package org.example;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private java.sql.Date parseDate(String date) {
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private java.sql.Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
//        Configuration con  = new Configuration().configure();
//        con.addAnnotatedClass(Company.class);
//        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
//                .applySettings(con.getProperties());
//        SessionFactory sf = con.buildSessionFactory(sBuilder.build());
//
//        //create
//        Session sCreate = sf.openSession();
//        Transaction trCreate = sCreate.beginTransaction();
////        sCreate.save(Bob);
//        trCreate.commit();
//        sCreate.close();
//        CompanyServiceImp companyServiceImp = new CompanyServiceImp();
//        Company company = new Company();
//        Main m = new Main();
//
//        company.setCompany_name("Google");
//        company.setFound_date(new Date(2013-1900,9,29));
//
//
//        System.out.println(companyServiceImp.save(company));
//        System.out.println(companyServiceImp.getById(1000L));
    }
}