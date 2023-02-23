package ru.univerbot.store;

import java.util.*;

public class StoreListTrainees implements BaseStoreTrainees {

    private HashMap<String, List<String>> localStore = new HashMap<>();

    @Override
    public void save(String nameCoach, String nameTrainee) {

        //добавление элементов в Мапу

        List<String> result = new ArrayList<>();
        result.add(nameTrainee);
        for (Map.Entry<String, List<String>> entry : localStore.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (nameCoach.equals(key)) {
                result.addAll(value);
            }
        }


        localStore.put(nameCoach, result);
    }

    @Override
    public List<String> selectAll() {

        //распечатка Мапы ключ + значение

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : localStore.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            for (String s : value)
                result.add(key + " - " + s);
        }

        return result;
    }

    @Override
    public void deleted(String nameTrainee) {

        //удаление элементов из Мапы

        for (Map.Entry<String, List<String>> entry : localStore.entrySet()) {
            List<String> value = entry.getValue();
            Iterator<String> valueIterator = value.iterator();
            while (valueIterator.hasNext()) {
                String nameTr = valueIterator.next();
                if (nameTr.equals(nameTrainee)) {
                    valueIterator.remove();
                }
            }
        }

    }
}
