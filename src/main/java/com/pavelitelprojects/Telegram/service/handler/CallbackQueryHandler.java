package com.pavelitelprojects.Telegram.service.handler;

import com.pavelitelprojects.Telegram.Bot;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Service
public class CallbackQueryHandler {
        public BotApiMethod<?> answer(CallbackQuery callbackQuery, Bot bot) {
            return null;
        }
    }

