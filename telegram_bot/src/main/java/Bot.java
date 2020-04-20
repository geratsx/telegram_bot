
import models.Model;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static advices.AdviceMaker.getRandomAdvice;


public class Bot extends TelegramLongPollingBot {

    private static final String TOKEN = "1047339840:AAGNaf3epc-9eyFYRzPMeLH8r32-k7PomXw";
    private static final String BOT_NAME = "myfirstetstbot";
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    //прием сообщений c помощью long poll
    public void onUpdateReceived(Update update) {

        Model model = new Model();
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String messageFromClient = message.getText();
            if ("/help".equals(messageFromClient)) {
                sendMsg(message, "Введите название города, в котором интересует погода.");
            } else if ("/совет".equals(messageFromClient)) {
                sendMsg(message, getRandomAdvice());
                System.out.println(dateFormat.format(new Date()) + " " + getRandomAdvice());

            } else {
                try {
                    sendMsg(message, Weather.getWeather(message.getText(), model));
                } catch (IOException e) {
                    sendMsg(message, "Такой город не найден.");
                }
            }
        }
    }

    private void sendMsg(Message message, String answer) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(answer);
        try {
            setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void setButtons(SendMessage sendMessage) {
//        fileCreator.createFile();
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(keyboardMarkup);
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList<KeyboardRow>();
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(new KeyboardButton("/help"));
        firstRow.add(new KeyboardButton("/совет"));
        keyboardRowList.add(firstRow);
        keyboardMarkup.setKeyboard(keyboardRowList);
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
