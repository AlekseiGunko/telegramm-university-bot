package ru.univerbot.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.univerbot.Config;
import ru.univerbot.service.SendMessageOperationService;
import ru.univerbot.store.StoreExamsTrainees;
import ru.univerbot.store.StoreListTrainees;


import static ru.univerbot.Config.COMMON_PASSWORD;
import static ru.univerbot.constant.VarConstant.*;

public class CoreBot extends TelegramLongPollingBot {
    SendMessageOperationService operationService = new SendMessageOperationService();
    private StoreListTrainees store = new StoreListTrainees();
    private StoreExamsTrainees examsTrainees = new StoreExamsTrainees();

    //флаг для начала/конца добавление инфы в локальное хранилище стажеров
    private boolean startAdd;

    //флаг для начала/конца добавление инфы в локальное хранилище экзаменов
    private boolean startAddExam;

    //флаг для активации бота по паролю
    private boolean pass = false;

    //флаг для начала/конца удаления инфы из локального хранилища стажеров
    private boolean endDel;

    //флаг для начала/конца удаления инфы из локального хранилища экзаменов
    private boolean dellExams;

    //флаг для активации наставника 1
    private boolean name_1;

    //флаг для активации наставника 2
    private boolean name_2;

    //флаг для активации наставника 3
    private boolean name_3;

    //флаг для активации наставника 4
    private boolean name_4;

    private Config config = new Config();


    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage() && update.getMessage().hasText()) {


                switch (update.getMessage().getText()) {

                    case START:
                        execute(operationService.createHelloMessage(update));
                        break;

                    case COMMON_PASSWORD:
                        execute(operationService.createTruePassword(update));
                        pass = true;
                        break;

                    case ADD_TRAINEES:
                        execute(operationService.createStartMessage(update));
                        break;

                    case ADD_TRAINEE:
                        startAdd = true;
                        execute(operationService.createAddMessage(update));
                        break;

                    case END_TRAINEE:
                        startAdd = false;
                        startAddExam = false;
                        execute(operationService.createEndMessage(update));
                        break;

                    case TRAINEE:
                        execute(operationService.createListMessage(update));
                        execute(operationService.createSimpleMessage(update, store.selectAll()));
                        break;


                    case DELETED_TRAINEE:
                        endDel = true;
                        execute(operationService.createDeletedMessage(update));
                        break;

                    case MAIN:
                        endDel = false;
                        dellExams = false;
                        execute(operationService.mainMonitor(update));
                        break;

                    case LIST_COMMAND:
                        execute(operationService.listCommand(update));
                        break;

                    case EXAMS:
                        execute(operationService.createExamsMessage(update));
                        break;

                    case RECORD:
                        startAddExam = true;
                        execute(operationService.createWriteExamsMessage(update));
                        break;

                    case SCHEDULE_EXAMS_LIST:
                        execute(operationService.createExamsTraineesMessage(update));
                        execute(operationService.createSimpleMessage(update, examsTrainees.getInfo()));
                        execute(operationService.createWarningInfo(update));
                        break;

                    case DELETED_TRAINEE_EXAMS:
                        dellExams = true;
                        execute(operationService.createExamsDeletedMessage(update));
                        break;

                    case DELETED_TRAINEES_ALL:
                        examsTrainees.deletedAllExams();
                        execute(operationService.createCompleteExamsAllMessage(update));
                        break;


                    case NAME_1:
                        name_1 = true;
                        name_2 = false;
                        name_3 = false;
                        name_4 = false;
                        execute(operationService.createName1Message(update));
                        break;

                    case NAME_2:
                        name_2 = true;
                        name_1 = false;
                        name_3 = false;
                        name_4 = false;
                        execute(operationService.createName2Message(update));
                        break;


                    case NAME_3:
                        name_3 = true;
                        name_1 = false;
                        name_2 = false;
                        name_4 = false;
                        execute(operationService.createName3Message(update));
                        break;

                    case NAME_4:
                        name_4 = true;
                        name_1 = false;
                        name_2 = false;
                        name_3 = false;
                        execute(operationService.createName4Message(update));
                        break;


                    default:
                        if (startAdd == true && name_1 == true) {
                            store.save(NAME_1, update.getMessage().getText());
                            break;
                        }

                        if (startAdd == true && name_2 == true) {
                            store.save(NAME_2, update.getMessage().getText());
                            break;
                        }

                        if (startAdd == true && name_3 == true) {
                            store.save(NAME_3, update.getMessage().getText());
                            break;
                        }


                        if (startAdd == true && name_4 == true) {
                            store.save(NAME_4, update.getMessage().getText());
                            break;
                        }
                        if (startAddExam == true) {
                            examsTrainees.addTraineeExams(update.getMessage().getText());
                            break;
                        }

                        if (endDel == true) {
                            store.deleted(update.getMessage().getText());
                            execute(operationService.createCompletedMessage(update));
                            break;
                        }

                        if (dellExams == true) {
                            examsTrainees.deletedExamsTrainee(update.getMessage().getText());
                            execute(operationService.createCompleteExamsdMessage(update));
                            break;
                        }
                        if (pass == false) {
                            execute(operationService.createErrorPassword(update));
                            break;
                        }

                }

            }

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBOT_NAME();
    }

    @Override
    public String getBotToken() {
        return config.getBOT_TOKEN();
    }

}
