package ru.univerbot.store;

import java.util.*;

public class StoreExamsTrainees {

    private final List<String> storageListExams = new ArrayList<>();


    public void addTraineeExams(String info) {

        //добавляем стажеров в список на экзамен

        storageListExams.add(info + "\n");
    }

    //показываем список стажеров записанных на экзамен
    public List<String> getInfo() {
        Collections.sort(storageListExams);

        return storageListExams;
    }

    public void deletedExamsTrainee(String name) {

        //удалем одну запись из списка стажеров записанных на экзамен

        Iterator<String> iterator = storageListExams.iterator();
        while (iterator.hasNext()) {
            String nameNext = iterator.next();
            if (nameNext.equals(name + "\n")) {
                iterator.remove();
            }
        }
    }

    public void deletedAllExams() {

        //очищаем весь лист стажеров записанных на экзамен

        storageListExams.clear();
    }
}
