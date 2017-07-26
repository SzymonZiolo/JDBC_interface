package com.company.Objects;


public class Manufacturers {
    private int id;
    private String name;
    private String address;
    private String contact_no;

    public Manufacturers() {
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " Name: " + name + '\'' +
                " Address: " + address + '\'' +
                " Contact_no: " + contact_no + '\'';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact_no() {
        return contact_no;
    }
}
