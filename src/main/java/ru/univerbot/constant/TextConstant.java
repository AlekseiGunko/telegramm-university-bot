package ru.univerbot.constant;



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
            "/exams - расписание экзаменов на текущуюю неделю" + "\n" +
            "/list_exams - список стажеров записанных на экзамен";

    public final String PASSWORD = "Добро пожоловать в University_Bodro_Bot" + "\n" +
            "Введите свой пароль";

    public final String ERROR_PASSWORD = "Пароль не верный";

    public final String ADD_TRAINEES = "Выберите наставника";

    public final String END_MESSAGE = "Ваши стежеры добавлены";

    public final String LIST_COMMAND_BUTTON = "СПИСОК КОМАНД ✅: " + "\n" + "/add_trainee" +
            " - добавить/удалить стажеров" + "\n" +
            "/list_trainees - список учащихся стажеров" + "\n" +
            "/exams - расписание экзаменов на текущуюю неделю" + "\n" +
            "/list_exams - список стажеров записанных на экзамен";

    public final String LIST = "Список обучающихся стажеров";

    public final String MAIN = "Вы на главном экране";

    public final String SCHEDULE_EXAMS = "Понедельник - 13:30" + "\n" + "Вторник - экзаменов нет" + "\n" +
            "Среда - 11:30" + "\n" + "Четверг - 11:30" + "\n" + "Пятница - 11:30";

    public final String DELETED = "Введите имя стажера, которого хотите удалить из" +
            " списка обучающихся в формате" + "\n" + "Имя наставника + ФИО стежер";

    public final String COMPLETED = "Вы успешно удалили стажера из списка";

    public final String MESSAGE_ADD_TRAINEES_IN_EXAMS = "Добавьте стажеров на экзамен в формате: " + "\n" +
            "День и время, дата(в формате день и месяц) => например: Понедельник 13:30, 22.10 " + "\n" +
            "Нажмите Enter и далее поочередно вносите стажеров и нажмите кнопку \"Завершить\"";

    public final String MESSAGE_LIST_EXAMS = "Список стажеров записанных на экзамен: ";

    public final String DELETED_EXAMS = "Введите имя стажера, которого хотите удалить из" +
            " списка обучающихся в формате" + "\n" + "Имя наставника + ФИО стежер";

    public final String COMPLETED_EXAMS = "Вы успешно удалили экзаменуемого из списка";
    public final String DELETED_ALL_LIST_EXAMS = "Список стажеров записанных на экзамен очищен полностью";

}
