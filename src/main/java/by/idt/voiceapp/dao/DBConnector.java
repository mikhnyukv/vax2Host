package by.idt.voiceapp.dao;

import by.idt.voiceapp.bean.User;

public interface DBConnector {
    int save(User user, boolean status);
}
