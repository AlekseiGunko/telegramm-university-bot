package ru.univerbot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.univerbot.constant.TextConstant;

import java.util.List;

import static java.util.Arrays.asList;
import static ru.univerbot.constant.VarConstant.*;

public class SendMessageOperationService {

    private final String DELETED = "Введите имя стажера, которого хотите удалить из" +
            " списка обучающихся в формате" + "\n" + "Имя наставника + ФИО стежер";
    private final String COMPLETED = "Вы успешно удалили стажера из списка";

    private String exams = "Понедельник - 13:30" + "\n" + "Вторник - экзаменов нет" + "\n" +
            "Среда - 11:30" + "\n" + "Четверг - 11:30" + "\n" + "Пятница - 11:30";

    private final ButtonsService buttonsService = new ButtonsService();
    private final CreateKeyboardForBot createKeyboard = new CreateKeyboardForBot();
    private final TextConstant textConstant = new TextConstant();

    public SendMessage createStartMessage (Update update) {
        //выбор наставника по константе add_trainees

      SendMessage message = createSimpleMessage(update, textConstant.ADD_TRAINEES);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.createCoach();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createName1Message (Update update) {

        //работа со стажерами наставник 1

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_1);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createName2Message (Update update) {

        //работа со стажерами наставник 2

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_2);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createName3Message (Update update) {

        //работа со стажерами наставник 3

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_3);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createName4Message (Update update) {

        //работа со стажерами наставник 4

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_4);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createAddMessage (Update update) {

        //добавление стажеров в формате add_message

        SendMessage message = createSimpleMessage(update, textConstant.ADD_MESSAGE);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }
    public SendMessage createExamsMessage (Update update) {

        //сообщение о расписании экзаменов

        SendMessage message = createSimpleMessage(update, exams);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.setButtons(
                buttonsService.createButtons(asList(RECORD)));
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createListMessage (Update update) {

        //сообщение выводит список текущих стажеров

        SendMessage message = createSimpleMessage(update, textConstant.LIST);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.mainMonitorButton();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createCompletedMessage (Update update) {

        SendMessage message = createSimpleMessage(update, COMPLETED);
        return message;

    }

    public SendMessage createEndMessage (Update update) {

        //сообщение что стажеры добавлены

        SendMessage message = createSimpleMessage(update, textConstant.END_MESSAGE);
        return message;
    }

    public SendMessage createHelloMessage (Update update) {

        //ответ на команду /start и запрос пароля

        SendMessage message = createSimpleMessage(update, textConstant.PASSWORD);
        return message;
    }

    public SendMessage createTruePassword (Update update) {

        //сообщение правильного ввода пароля

        SendMessage message = createSimpleMessage(update, textConstant.GET_MESSAGE_START);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.listCommand();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createErrorPassword (Update update) {

        //сообщение ошибки ввода пароля

        SendMessage message = createSimpleMessage(update, textConstant.ERROR_PASSWORD);
        return message;

    }

    public SendMessage createDeletedMessage (Update update) {

        //сообщение при удалении стажеров

        SendMessage message = createSimpleMessage(update, DELETED);
        return message;
    }

    public SendMessage mainMonitor (Update update) {

        //сообщение и кнопка главного экрана

        SendMessage message = createSimpleMessage(update, textConstant.MAIN);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.listCommand();
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    public SendMessage listCommand (Update update) {

        //сообщение для кнопки главного экрана

        SendMessage message = createSimpleMessage(update, textConstant.LIST_COMMAND_BUTTON);
        return message;
    }




    //методы создания сообщений

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
