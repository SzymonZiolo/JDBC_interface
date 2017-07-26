package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.company.Dao.DatabaseEmployeesDao;
import com.mysql.jdbc.Driver;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;

public class Main extends Application {

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseServer databaseServer = new DatabaseServer(
                "localhost", "autoparts_store", "java_interface", "Randomness");

        DatabaseEmployeesDao.init(databaseServer);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Main");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
