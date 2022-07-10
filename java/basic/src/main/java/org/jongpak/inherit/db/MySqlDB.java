package org.jongpak.inherit.db;

public class MySqlDB implements DB {

    @Override
    public void select(String tableName) {
        System.out.println("SELECT from MySQL");
    }
}
