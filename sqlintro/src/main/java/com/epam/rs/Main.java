package com.epam.rs;

import java.sql.*;

/**
 * Created by catmo_000 on 2/15/2016.
 */
public class Main {
    private static void select(Statement statement) throws SQLException {
        System.out.println("-----------------------------------------------");
        String sql = "SELECT id, first, last, age FROM user_custom";
        ResultSet rs = statement.executeQuery(sql);


        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
        }
        System.out.println("-----------------------------------------------");

    }

    public static void main(String args[]) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");

            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            statement = connection.createStatement();
            String sql = "drop table user_custom";

            statement.executeUpdate(sql);
            sql = "CREATE TABLE user_custom " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");


            statement.executeUpdate("INSERT INTO user_custom VALUES (1, 'f1', 'l1', 18)");
            statement.executeUpdate("INSERT INTO user_custom VALUES (2, 'f2', 'l2', 31)");
            statement.executeUpdate("INSERT INTO user_custom VALUES (3, 'f3', 'l3', 20)");
            statement.executeUpdate("INSERT INTO user_custom VALUES (4, 'f4', 'l4', 45)");


            select(statement);


            sql = "UPDATE user_custom " +
                    "SET last=last || '_old' WHERE age < 30 ";
            statement.executeUpdate(sql);


            select(statement);

            sql = "DELETE FROM user_custom " +
                    "WHERE id = 1";
            statement.executeUpdate(sql);

            select(statement);


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

    }
}
