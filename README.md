# [telegramm-university-bot](https://github.com/AlekseiGunko/telegramm-university-bot) - корпоративный телеграмм бот
![javaLang](https://img.shields.io/badge/Language-Java-blue)
![typeProj](https://img.shields.io/badge/TypeProject-Pet-yellow)
![status](https://img.shields.io/badge/Status-Completed-green)
_____
## Для чего предназначен:
Бот предназначен для записи стажеров компании к наставникам и на экзамены, а так же для отображения количества стажеров у определенных наставников, количества стажеров записанных на экзамен в определенный день и время. 
## Описание:
Бот создан для корпоративных целей поэтому при команде */start* запросит пароль для работы с ним.
![pass](https://github.com/AlekseiGunko/telegramm-university-bot/blob/master/imageForProjcetReadme/2023-02-28_13-31-47.png)

Для удобного использования бота разработан список команд:
![command](https://github.com/AlekseiGunko/telegramm-university-bot/blob/master/imageForProjcetReadme/2023-02-28_13-05-44.png)

Так же реализован пользовательский интерфейс в виде кнопок в каждом разделе команд, например в команде */add_trainee* :
![buttons](https://github.com/AlekseiGunko/telegramm-university-bot/blob/master/imageForProjcetReadme/2023-02-28_13-06-43.png)
_____
## Стэк технологий использованных в проекте:
Бот реализован на языке программирования **Java** и использует следующий стэк технологий:
- Lombok
- TelegramLongPollingBot
- [BotFather](https://t.me/BotFather)
_____
## Инструкция по локальному запуску проекта:
Для начала нужно подключить в проект все нужные зависимости зависимости:
- добавить библиотеку Lombok и Telegrambots:
``` xml
    <dependency>
        <groupId>org.telegram</groupId>
        <artifactId>telegrambots</artifactId>
        <version>6.4.0</version>
    </dependency>
    
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.24</version>
        <scope>provided</scope>
    </dependency>
```
Всю дополнительную информацию для библиотеки Telegrambots можно найти [тут](https://github.com/rubenlagus/TelegramBots).
- создать класс Config в корне пакета, добавить его в [gitignore](https://github.com/AlekseiGunko/telegramm-university-bot/blob/master/src/main/java/ru/.gitignore), чтобы ваши данные были скрыты:
``` java

@Getter
public class Config {
    public static final String COMMON_PASSWORD = "Ваш пароль";
    private final String BOT_NAME = "Имя вашего бота";
    private final String BOT_TOKEN = "Токен вашего бота";
}
```
- инициализировать данные для вашего бота в классе [CoreBot](https://github.com/AlekseiGunko/telegramm-university-bot/blob/master/src/main/java/ru/univerbot/core/CoreBot.java):
``` java
import static ru.univerbot.Config.COMMON_PASSWORD;

    @Override
    public String getBotUsername() {
        return config.getBOT_NAME();
    }

    @Override
    public String getBotToken() {
        return config.getBOT_TOKEN();
    }
```
_____
## Заключение:
После прочтения описания и внедрения всех зависимостей можете запускать бота, проект готов к работе.
