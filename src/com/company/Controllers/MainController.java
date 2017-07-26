package com.company.Controllers;


import com.company.Dao.DatabaseEmployeesDao;
import com.company.Objects.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainController {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField position;
    @FXML
    private TextField address;
    @FXML
    private TextField contact_number;
    @FXML
    private TextField salary;
    @FXML
    private Label fullInfo;
    private Map<String, Parent> views = new HashMap<>();

    @FXML
    protected void getEMP(ActionEvent event) {
        List<Employee> employees = DatabaseEmployeesDao.getInstance().get();

        employees.forEach((employee) -> {
            System.out.println(employees.toString());
        });
    }

    @FXML
    protected void addEMP(ActionEvent event) {
        fullInfo.setText(id.getText() + " " + name.getText() + " " + position.getText() + " " + address.getText() + " " + contact_number.getText() + " " + salary.getText() + " added!");
        DatabaseEmployeesDao.getInstance().add(new Employee(Integer.parseInt(id.getText()), name.getText(), address.getText(), contact_number.getText(), Double.parseDouble(salary.getText()), position.getText()));
    }

    @FXML
    protected void changeToEmployees(ActionEvent event) {
        try {
            views.put("Employees", FXMLLoader.load(getClass().getClassLoader().getResource("Employee.fxml")));

        } catch (IOException e) {
        }
    }

}
