package com.thoughtworks;

import java.util.IdentityHashMap;
import java.util.List;

public interface Repository<E> {
    void save(String id, E entity);

    E get(String id);

    E delete(String id);

    E update(String id, E entity);

    List<E> list();
}
