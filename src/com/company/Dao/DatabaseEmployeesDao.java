package com.company.Dao;

import com.company.DatabaseServer;
import com.company.Objects.Employee;
import com.company.Interfaces.EmployeesDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-24.
 */
public class DatabaseEmployeesDao implements EmployeesDao {

    private static DatabaseEmployeesDao instance = null;
    private DatabaseServer server;
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String GET_ALL_SQL = "select employees.id, employees.name, address, emp_pos.name as position, contact_no, salary  from employees inner join emp_pos where emp_pos.id = employees.position";
    public static final String POSITION_COLUMN = "position";
    public static final String SALARY_COLUMN = "salary";
    public static final String ADDRESS_COLUMN = "address";
    public static final String CONTACT_COLUMN = "contact_no";

    public static void init(DatabaseServer server) {
        if (instance == null) {
            instance = new DatabaseEmployeesDao(server);
        }
    }

    public static DatabaseEmployeesDao getInstance() {
        return instance;
    }


    private DatabaseEmployeesDao(DatabaseServer server) {
        this.server = server;
        try {
            this.server.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        this.server.close();
    }


    @Override
    public List<Employee> get() {
        List<Employee> employees = new ArrayList<>();

        Statement statement = null;
        try {
            statement = server.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);

            while (resultSet.next()) {
                int ID = resultSet.getInt(resultSet.findColumn(ID_COLUMN));
                String name = resultSet.getString(resultSet.findColumn(NAME_COLUMN));
                String address = resultSet.getString(resultSet.findColumn(ADDRESS_COLUMN));
                String position = resultSet.getString(resultSet.findColumn(POSITION_COLUMN));
                String contact = resultSet.getString(resultSet.findColumn(CONTACT_COLUMN));
                double salary = resultSet.getDouble(resultSet.findColumn(SALARY_COLUMN));


                System.out.println("ID: " + ID + "\n" + " Name: " + name + "\n" + " Address: " + address + "\n" + " Position: " + position + "\n" + " Contact number: " + contact + "\n" + " Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public void add(Employee employee) {
        Statement statement = null;
        try {
            statement = server.createStatement();

            statement.executeUpdate("insert into employees (id, name, position, address, contact_no, salary) values  (" + "'" + employee.getID() + "'" + "," + "'" + employee.getName() + "'" + ", " + "'" + employee.getPosition() + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getContact_number() + "'" + "," + "'" + employee.getSalary() + "'" + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}
