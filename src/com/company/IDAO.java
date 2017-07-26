package com.company;


import java.util.List;

public interface IDAO<T extends Object> {
    List<T> get();
    void add(T bean);
    void update(T bean);
    void delete(T bean);
}