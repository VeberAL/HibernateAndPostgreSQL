package ru.dao;

public interface DAOMtoM<Entity, Key> {
    Entity read(Key key);
}
