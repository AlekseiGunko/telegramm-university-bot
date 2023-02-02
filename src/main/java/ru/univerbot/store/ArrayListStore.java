package ru.univerbot.store;

import java.util.*;

public class ArrayListStore implements BaseStore {

    private ArrayList <String > localStore = new ArrayList<>();


    @Override
    public void save(String name) {
        localStore.add(name);

    }

    @Override
    public List<String> selectAll() {
        return localStore;
    }

    @Override
    public void deleted(String name) {
        Iterator<String> iterator = localStore.iterator();
        while (iterator.hasNext()) {
            String nextString = iterator.next();
            if (nextString.equals(name)) {
                iterator.remove();
            }
        }
    }
}
