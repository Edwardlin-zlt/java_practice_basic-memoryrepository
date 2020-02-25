package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryRepository<E> implements Repository<E> {
    Map<String, E> memory = new HashMap<>();

    @Override
    public void save(String id, E entity) {
        Object curValue;
        if ((curValue = memory.get(id)) != null || memory.containsKey(id)) {
            // 应该Raise错误吧？有个专门的update方法, 但是save方法的实现也能做到update
            // 先写个sout假装raise了错误
            System.out.println("Already got this id in memory, try update");
        } else {
            memory.put(id, entity);
        }
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
//         replace 和　put　有什么区别呢
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
