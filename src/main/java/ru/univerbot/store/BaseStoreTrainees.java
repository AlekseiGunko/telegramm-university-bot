package ru.univerbot.store;

import java.util.List;

public interface BaseStoreTrainees {

    void save (String nameCoach, String nameTrainee);
    List<String> selectAll ();
    void deleted (String  nameTrainee);

}
