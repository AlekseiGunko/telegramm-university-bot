package ru.univerbot.constant;


import javax.sql.rowset.serial.SerialStruct;

import static ru.univerbot.constant.VarConstant.*;

public class TextConstant {


    public final String ADD_MESSAGE = "Добавьте стежеров:" + "\n" + "Нажмите кнопку добавить и вписывайте ФИО" +
            " поочередно => ФИО, даллее enter и даллее следующего стажера по списку" +
            "\n" + "После завершения нажмите кнопку \"Завершить\"";

    public final String MAKE_NAME_1 = NAME_1 + " вносите стажеров для начала нажав кнопку добавить";

    public final String MAKE_NAME_2 = NAME_2 + " вносите стажеров для начала нажав кнопку добавить";
    public final String MAKE_NAME_3 = NAME_3 + " вносите стажеров для начала нажав кнопку добавить";
    public final String MAKE_NAME_4 = NAME_4 + " вносите стажеров для начала нажав кнопку добавить";

    public final String GET_MESSAGE_START = "Привет, приступим к работе." + "\n\n" +
            "СПИСОК КОМАНД ✅: " + "\n" + "/add_trainee - добавить/удалить стажеров" + "\n" +
            "/list_trainees - список учащихся стажеров" + "\n" +
            "/exams - расписание экзаменов на текущуюю неделю";

    public final String PASSWORD = "Добро пожоловать в University_Bodro_Bot" + "\n" +
            "Введите свой пароль";

    public final String ERROR_PASSWORD = "Пароль не верный";

    public final String ADD_TRAINEES = "Выберите наставника";

    public final String END_MESSAGE = "Ваши стежеры добавлены";

    public final String LIST_COMMAND_BUTTON = "СПИСОК КОМАНД ✅: " + "\n" + "/add_trainee" +
            " - добавить/удалить стажеров" + "\n" +
            "/list_trainees - список учащихся стажеров" + "\n" +
            "/exams - расписание экзаменов на текущуюю неделю";

    public final String LIST = "Список обучающихся стажеров";

    public final String MAIN = "Вы на главном экране";

}
