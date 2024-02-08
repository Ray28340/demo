package com.pavelitelprojects.Telegram.service.handler;

import com.pavelitelprojects.Telegram.Bot;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class MessageHandler {
        public BotApiMethod<?> answer(Message message, Bot bot) {
            return null;
        }
    }

