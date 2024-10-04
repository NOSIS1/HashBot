package com.example.HashCode;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {


    public static void sendCustomKeyboard(String chatId) {

        final TelegramClient telegramClient = new OkHttpTelegramClient(Parol.botapi);

        SendMessage message = new SendMessage(chatId,"");
        message.setChatId(chatId);
        message.setText("->");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(new ArrayList<>());
        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add("Hashing");
        row.add("lessons");
        row.add("misc cryptography");

        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);

        message.setReplyMarkup(keyboardMarkup);

        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
