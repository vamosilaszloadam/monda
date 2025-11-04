package com.example.models;

import java.util.ArrayList;

public interface Accessible<T> {
    public ArrayList<T> index();
    public void store(T emp);
    public void update(T emp, int id);
    public void destroy(int id);
}
