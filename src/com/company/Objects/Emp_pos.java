package com.company.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Emp_pos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    @JoinColumn(name = "role_id")
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Emp_pos(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp_pos() {
        this.id = 0;
        this.name = "";
    }

    @Override
    public String toString() {
        String text = getId() + " " + getName() + ", users: ";

        for(Employee employee : employees) {
            text += employee.toString() + ", ";
        }

        return text;
    }
}