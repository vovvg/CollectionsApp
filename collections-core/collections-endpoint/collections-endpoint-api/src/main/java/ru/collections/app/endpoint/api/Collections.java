package ru.collections.app.endpoint.api;


public interface Collections {
    void create(String user, Integer amount, String name);
    void save(Integer integer);
    void delete(Integer integer);
    void get();
}
