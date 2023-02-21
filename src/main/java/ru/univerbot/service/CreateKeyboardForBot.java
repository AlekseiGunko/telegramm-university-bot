package ru.univerbot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static ru.univerbot.constant.VarConstant.*;

public class CreateKeyboardForBot {

    private final ButtonsService buttonsService = new ButtonsService();

    public ReplyKeyboardMarkup createCoach() {

        //клавиатура для выбора имени наставника

        List<KeyboardRow> stringButtons = new ArrayList<>();
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(NAME_1, NAME_2)));
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(NAME_3, NAME_4)));
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(MAIN)));
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(stringButtons);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup addDeleteCheckTrainee () {

        //клавиатура выбора действия для наставника

        List<KeyboardRow> stringButtons = new ArrayList<>();
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(ADD_TRAINEE, END_TRAINEE)));
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(DELETED_TRAINEE)));
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(MAIN)));
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(stringButtons);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup listCommand () {

        //клавиатура с кнопкой список команд

        List<KeyboardRow> stringButtons = new ArrayList<>();
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(LIST_COMMAND)));
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(stringButtons);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup mainMonitorButton () {

        //отдельная кнопка выхода на главный экран

        List<KeyboardRow> stringButtons = new ArrayList<>();
        stringButtons.add(buttonsService.createButtonsOnKeyboard(asList(MAIN)));
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(stringButtons);
        return keyboardMarkup;
    }


}
