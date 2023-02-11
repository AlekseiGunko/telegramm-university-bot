package ru.univerbot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsService {

    public ReplyKeyboardMarkup setButtons (List<KeyboardRow> keyboardRowList) {

        //добавление кнопок с натройками на панель бота

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }

    public List<KeyboardRow> createButtons (List<String> buttonsName) {

        //создаем кнопки и кладем их в лист

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        for (String buttonName : buttonsName) {
            keyboardRow.add(new KeyboardButton(buttonName));
        }
        keyboardRows.add(keyboardRow);
        return keyboardRows;
    }

    public KeyboardRow createButtonsOnKeyboard (List <String> buttonsName) {

        //создаем кнопки, добавляем на клавиатуру и кладем их в лист

        KeyboardRow keyboardRow = new KeyboardRow();
        for (String buttonName : buttonsName) {
            keyboardRow.add(new KeyboardButton(buttonName));
        }
        return keyboardRow;


    }


}
