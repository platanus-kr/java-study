package org.platanus.inherit.db;

import java.lang.reflect.InvocationTargetException;

public class DBTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String dbDriver = System.getenv("db.driver.className");
        DB db = (DB) Class.forName(dbDriver).getDeclaredConstructor().newInstance();
//
//        // 위임
//        // 반전 == 역전 == 의존성 역전
////        if (dbDriver.equals("MySQL")) {
////            db = new MySqlDB();
////        } else if (dbDriver.equals("Oracle")) {
////            db = new OracleDB();
////        } else {
////            throw new RuntimeException("Not found db connector");
////        }

        db.select("Pet Clinic");
    }

}
