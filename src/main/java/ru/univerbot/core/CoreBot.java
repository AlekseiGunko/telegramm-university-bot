package ru.univerbot.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.univerbot.service.SendMessageOperationService;
import ru.univerbot.store.ArrayListStore;



import static ru.univerbot.constant.VarConstant.*;

public class CoreBot extends TelegramLongPollingBot {
    SendMessageOperationService operationService = new SendMessageOperationService();
    private ArrayListStore store = new ArrayListStore();
    private boolean startAdd;
    private boolean endDel;
    private boolean name_1;
    private boolean name_2;


    @Override
    public void onUpdateReceived(Update update) {
        try {

            if (update.hasMessage() && update.getMessage().hasText()) {

            switch (update.getMessage().getText()) {

                case EXAMS:
                    execute(operationService.createExamsMessage(update));
                    break;

                case START:
                    execute(operationService.createHelloMessage(update));
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
                    execute(operationService.createEndMessage(update));
                    break;

                case TRAINEE:
                    if (startAdd == false) {
                        execute(operationService.createListMessage(update));
                        execute(operationService.createSimpleMessage(update, store.selectAll()));
                        break;
                    }

                case DELETED_TRAINEE:
                    endDel = true;
                        execute(operationService.createDeletedMessage(update));
                        break;

                case NAME_1:
                    name_1 = true;
                    execute(operationService.createName1Message(update));
                    break;

                case NAME_2:
                    name_2 = true;
                    execute(operationService.createName2Message(update));
                    break;



                default:
                   if (startAdd == true && name_1 == true) {
                        store.save(update.getMessage().getText() + " - " + NAME_1);
                        break;
                    }

                    if (startAdd == true && name_2 == true) {
                        store.save(update.getMessage().getText() + " - " + NAME_2);
                        break;
                    }

                    if (endDel == true) {
                        store.deleted(update.getMessage().getText());
                        execute(operationService.createCompletedMessage(update));
                    }
            }

        }

        }
        catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public String getBotUsername() {
        return "UniversityBodroBot";
    }

    @Override
    public String getBotToken() {
        return "5976408224:AAEapw9YKJdLp4Uh9lB1mICixSzItmKmss8";
    }

}
