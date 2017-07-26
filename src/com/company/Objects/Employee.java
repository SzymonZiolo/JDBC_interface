package com.company.Objects;



import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
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
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Emp_pos position;

    public Emp_pos getPos() {
        return position;
    }

    public void setPosition(Emp_pos position) {
        this.position = position;
    }

    public Employee(int id, String name ) {
        this.id = id;
        this.name = name;
        this.position = new Emp_pos(1, "null");
    }

    public Employee(int id, String name, Emp_pos position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Employee() {
        this.id = 0;
        this.name = "";
        this.position = new Emp_pos();
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " "  + position.getName();
    }
}