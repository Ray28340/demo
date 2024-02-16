package com.pavelitelprojects.Telegram.service.manager;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class FeedbackManager {
    public BotApiMethod<?> answerCommand(Message message) {
        return SendMessage.builder()
                .text("""
                        Ccылка для обратной свзязи:
                        https://vk.com/id475514120
                        """)
                .disableWebPagePreview(true)
                .chatId(message.getChatId())
                .build();
    }
    public BotApiMethod<?> answerCallbackQuery(CallbackQuery callbackQuery) {
        return EditMessageText.builder()
                .text("""
                        Ccылка для обратной свзязи:
                        https://vk.com/id475514120
                        """)
                .disableWebPagePreview(true)
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getChatId() )
                .build();
    }
}
