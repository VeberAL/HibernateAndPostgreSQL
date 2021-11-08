package ru.dao;

public interface DAO<Entity, Key> {
    //CRUT-операции
    void create(Entity entity);
    Entity read(int key);
    void update(Entity entity);
    void delete(Entity entity);
}
