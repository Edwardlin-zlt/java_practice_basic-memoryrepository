package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryRepository<E> implements Repository<E> {
    Map<String, E> memory = new HashMap<>();

    @Override
    public E save(String id, E entity) {
        return memory.put(id, entity);
    }

    @Override
    public E get(String id) {
        return memory.get(id);
    }

    @Override
    public E delete(String id) {
        return memory.remove(id);
    }

    @Override
    public String toString() {
        return "MemoryRepository";
    }

    @Override
    public E update(String id, E entity) {
        // replace 只在有key的时候才会put
        return memory.replace(id, entity);
    }

    @Override
    public List<E> list() {
        Set<String> ids = memory.keySet();
        List<E> entities = new ArrayList<>();
        for (String id : ids) {
            entities.add(memory.get(id));
        }
        return entities;
    }
}
