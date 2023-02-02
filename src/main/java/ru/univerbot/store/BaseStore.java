package ru.univerbot.store;

import java.time.LocalDate;
import java.util.List;

public interface BaseStore {

    void save (String name);
    List<String> selectAll ();
    void deleted (String name);

}
