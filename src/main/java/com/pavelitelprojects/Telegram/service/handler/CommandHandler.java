package com.pavelitelprojects.Telegram.service.handler;

import com.pavelitelprojects.Telegram.Bot;

import com.pavelitelprojects.Telegram.service.factory.KeyboardFactory;
import com.pavelitelprojects.Telegram.service.manager.FeedbackManager;
import com.pavelitelprojects.Telegram.service.manager.HelpManager;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

import static com.pavelitelprojects.Telegram.service.data.CallbackData.*;
import static com.pavelitelprojects.Telegram.service.data.Command.*;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandHandler {
    final KeyboardFactory keyboardFactory;
    final FeedbackManager feedbackManager;
    final HelpManager helpManager;
    @Autowired

    public CommandHandler(KeyboardFactory keyboardFactory,
                          FeedbackManager feedbackManager,
                          HelpManager helpManager
                          ) {
        this.keyboardFactory = keyboardFactory;
        this.feedbackManager = feedbackManager;
        this.helpManager = helpManager;
    }


    public BotApiMethod<?> answer(Message message, Bot bot) {
        String command = message.getText();
        switch (command) {
            case START ->  {
                return start(message);
            }
            case FEEDBACK_COMMAND -> {
                return feedbackManager.answerCommand(message);
            }
            case HELP_COMMAND -> {
                return helpManager.answerCommand(message);
            }
            default -> {
                return defaultAnswer(message);
            }
        }

    }

    private BotApiMethod<?> defaultAnswer(Message message) {
        return SendMessage.builder()
                .chatId(message.getChatId())
                .text("""
                        л
                        """)
                .build();
    }





    private BotApiMethod<?> start(Message message){

        return SendMessage.builder()
                .replyMarkup(keyboardFactory.getInlineKeyboard(
                        List.of("Обратная связь", "Помощь"),
                        List.of(1, 1),
                        List.of(HELP, FEEDBACK )
                ))
                .chatId(message.getChatId())
                .text("""
                      города
                        
                        Выберите город
                        """)
                .build();

    }


    }


