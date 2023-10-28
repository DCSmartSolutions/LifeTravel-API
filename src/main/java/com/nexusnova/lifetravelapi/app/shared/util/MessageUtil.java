package com.nexusnova.lifetravelapi.app.shared.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MessageSource messageSource;

    @Autowired
    public MessageUtil(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessageByCode(String code){
        try{
            return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        }catch (NoSuchMessageException e){
            logger.warn("No message found for code: " + code);
            return code;
        }
    }
}
