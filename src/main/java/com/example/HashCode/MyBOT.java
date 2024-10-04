package com.example.HashCode;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.security.NoSuchAlgorithmException;

public class MyBOT implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    public MyBOT(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {

        final long chatId = update.getMessage().getChatId();

        if (update.hasMessage() && update.getMessage().hasText()) {

            if(update.getMessage().getText().equals("/start")){

                try {
                    SendMessage message = SendText.sendText(chatId, "Hello!");
                    telegramClient.execute(message);
                    Keyboard.sendCustomKeyboard(Integer.toString((int) chatId));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            else {

                try {
                    SendMessage message = SendText.sendText(chatId, "Покачто не знаю такую команду!");
                    telegramClient.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
