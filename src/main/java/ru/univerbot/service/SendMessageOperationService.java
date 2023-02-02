package ru.univerbot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static ru.univerbot.constant.VarConstant.*;

public class SendMessageOperationService {
    private final String GET_MESSAGE_START = "Привет, приступим к работе." + "\n\n" +
            "СПИСОК КОМАНД ✅: " + "\n" + "/add_trainee - добавить стажеров наставнику" + "\n" +
            "/exams - расписание экзаменов на текущуюю неделю";

    private final String ADD_TRAINEES = "Выберите действие";
    private final String ADD_MESSAGE = "Добавьте стежеров в формате:" + "\n" + "Имя наставника + ФИО стажер" +
            "\n" + "После завершения нажмите кнопку \"Завершить\"";

    private final String END_MESSAGE = "Ваши стежеры добавлены" + "\n" + "Чтобы посмотреть всех" +
            " стажеров школы нажмите кнопку \"Список стажеров\"";

    private final String DELETED = "Введите имя стажера, которого хотите удалить из" +
            " списка обучающихся в формате" + "\n" + "Имя наставника + ФИО стежер";
    private final String COMPLETED = "Вы успешно удалили стажера из списка";
    private final String LIST = "Список обучающихся стажеров";

    private String exams = "Понедельник - 13:30" + "\n" + "Вторник - экзаменов нет" + "\n" +
            "Среда - 11:30" + "\n" + "Четверг - 11:30" + "\n" + "Пятница - 11:30";

    private String name_1 = NAME_1 + " вносите стажеров";
    private String name_2 = NAME_2 + " вносите стажеров";
    private final ButtonsService buttonsService = new ButtonsService();

    public SendMessage createStartMessage (Update update) {

      SendMessage message = createSimpleMessage(update, ADD_TRAINEES);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(
                buttonsService.createButtons(asList(ADD_TRAINEE, END_TRAINEE, DELETED_TRAINEE, TRAINEE)));
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createName1Message (Update update) {

        SendMessage message = createSimpleMessage(update, name_1);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(
                buttonsService.createButtons(asList(ADD_TRAINEE, END_TRAINEE, DELETED_TRAINEE, TRAINEE)));
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createName2Message (Update update) {

        SendMessage message = createSimpleMessage(update, name_2);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(
                buttonsService.createButtons(asList(ADD_TRAINEE, END_TRAINEE, DELETED_TRAINEE, TRAINEE)));
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createAddMessage (Update update) {
        
        //создаем клавиатуру на основе buttonService и добавляем туда строки с кнопками
        //https://ru.stackoverflow.com/questions/1411677/Создать-кнопки-меню-telegrambot-горизонтально-одна-за-другой

        SendMessage message = createSimpleMessage(update, ADD_MESSAGE);
        List<KeyboardRow> stringButtons = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(NAME_1);
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(NAME_2);
        stringButtons.add(keyboardRow);
        stringButtons.add(keyboardRow2);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(stringButtons);

        message.setReplyMarkup(keyboardMarkup);

        return message;

    }
    public SendMessage createExamsMessage (Update update) {

        SendMessage message = createSimpleMessage(update, exams);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(
                buttonsService.createButtons(asList(RECORD)));
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createListMessage (Update update) {

        SendMessage message = createSimpleMessage(update, LIST);
        return message;

    }

    public SendMessage createCompletedMessage (Update update) {

        SendMessage message = createSimpleMessage(update, COMPLETED);
        return message;

    }

    public SendMessage createEndMessage (Update update) {
        SendMessage message = createSimpleMessage(update, END_MESSAGE);
        return message;
    }

    public SendMessage createHelloMessage (Update update) {
        //ответ на команду /start
        SendMessage message = createSimpleMessage(update, GET_MESSAGE_START);
        return message;
    }

    public SendMessage createDeletedMessage (Update update) {
        SendMessage message = createSimpleMessage(update, DELETED);
        return message;
    }


    public SendMessage createSimpleMessage (Update update, String message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(message);
        return sendMessage;
    }

    public SendMessage createSimpleMessage (Update update, List<String> messages) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        StringBuilder message = new StringBuilder();
        for (String s : messages) {
            message.append(s).append("\n");
        }
        sendMessage.setText(message.toString());
        return sendMessage;
    }

}
