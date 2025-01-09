package org.platanus.inherit.db;

public class OracleDB implements DB {
    @Override
    public void select(String tableName) {
        System.out.println("SELECT from Oracle");
    }
}
