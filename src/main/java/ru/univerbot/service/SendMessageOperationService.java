package ru.univerbot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.univerbot.constant.TextConstant;

import java.util.List;

public class SendMessageOperationService {

    private final CreateKeyboardForBot createKeyboard = new CreateKeyboardForBot();
    private final TextConstant textConstant = new TextConstant();

    public SendMessage createStartMessage(Update update) {

        //выбор наставника по константе add_trainees

        SendMessage message = createSimpleMessage(update, textConstant.ADD_TRAINEES);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.createCoach();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createName1Message(Update update) {

        //работа со стажерами наставник 1

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_1);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createName2Message(Update update) {

        //работа со стажерами наставник 2

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_2);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createName3Message(Update update) {

        //работа со стажерами наставник 3

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_3);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createName4Message(Update update) {

        //работа со стажерами наставник 4

        SendMessage message = createSimpleMessage(update, textConstant.MAKE_NAME_4);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createAddMessage(Update update) {

        //добавление стажеров в формате add_message

        SendMessage message = createSimpleMessage(update, textConstant.ADD_MESSAGE);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addDeleteCheckTrainee();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createExamsMessage(Update update) {

        //сообщение о расписании экзаменов

        SendMessage message = createSimpleMessage(update, textConstant.SCHEDULE_EXAMS);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.scheduleExams();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createWriteExamsMessage(Update update) {

        //сообщение о записи стажеров на экзамены

        SendMessage message = createSimpleMessage(update, textConstant.MESSAGE_ADD_TRAINEES_IN_EXAMS);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.addExamsAndEnd();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createExamsTraineesMessage(Update update) {

        //сообщение выводит список стажеров на экзамене

        SendMessage message = createSimpleMessage(update, textConstant.MESSAGE_LIST_EXAMS);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.deletedExamsTrainees();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createWarningInfo(Update update) {

        //сообщение предупрежадет о ежемесячной очистке списка стажеров записанных на экзамен

        SendMessage message = createSimpleMessage(update, textConstant.WARNING);
        return message;
    }

    public SendMessage createExamsDeletedMessage(Update update) {

        //сообщение выводит формат удаления экзаменуемого

        SendMessage message = createSimpleMessage(update, textConstant.DELETED_EXAMS);
        return message;
    }


    public SendMessage createListMessage(Update update) {

        //сообщение выводит список текущих стажеров

        SendMessage message = createSimpleMessage(update, textConstant.LIST);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.mainMonitorButton();
        message.setReplyMarkup(keyboardMarkup);
        return message;

    }

    public SendMessage createCompletedMessage(Update update) {

        //сообщение что стажер удален успешно

        SendMessage message = createSimpleMessage(update, textConstant.COMPLETED);
        return message;

    }

    public SendMessage createCompleteExamsdMessage(Update update) {

        //сообщение что экзаменуемый удален успешно

        SendMessage message = createSimpleMessage(update, textConstant.COMPLETED_EXAMS);
        return message;

    }

    public SendMessage createCompleteExamsAllMessage(Update update) {

        //сообщение что список экзаменов очищен успешно

        SendMessage message = createSimpleMessage(update, textConstant.DELETED_ALL_LIST_EXAMS);
        return message;

    }

    public SendMessage createEndMessage(Update update) {

        //сообщение что стажеры добавлены

        SendMessage message = createSimpleMessage(update, textConstant.END_MESSAGE);
        return message;
    }

    public SendMessage createHelloMessage(Update update) {

        //ответ на команду /start и запрос пароля

        SendMessage message = createSimpleMessage(update, textConstant.PASSWORD);
        return message;
    }

    public SendMessage createTruePassword(Update update) {

        //сообщение правильного ввода пароля

        SendMessage message = createSimpleMessage(update, textConstant.GET_MESSAGE_START);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.listCommand();
        message.setReplyMarkup(keyboardMarkup);

        return message;

    }

    public SendMessage createErrorPassword(Update update) {

        //сообщение ошибки ввода пароля

        SendMessage message = createSimpleMessage(update, textConstant.ERROR_PASSWORD);
        return message;

    }

    public SendMessage createDeletedMessage(Update update) {

        //сообщение при удалении стажеров

        SendMessage message = createSimpleMessage(update, textConstant.DELETED);
        return message;
    }

    public SendMessage mainMonitor(Update update) {

        //сообщение и кнопка главного экрана

        SendMessage message = createSimpleMessage(update, textConstant.MAIN);
        ReplyKeyboardMarkup keyboardMarkup = createKeyboard.listCommand();
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    public SendMessage listCommand(Update update) {

        //сообщение для кнопки главного экрана

        SendMessage message = createSimpleMessage(update, textConstant.LIST_COMMAND_BUTTON);
        return message;
    }


    //методы создания сообщений

    public SendMessage createSimpleMessage(Update update, String message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(message);
        return sendMessage;
    }

    public SendMessage createSimpleMessage(Update update, List<String> messages) {

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
