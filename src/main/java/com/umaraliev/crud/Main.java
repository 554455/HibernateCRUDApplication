package com.umaraliev.crud;

import com.umaraliev.crud.view.ConsoleMenu;
import com.umaraliev.crud.view.SkillView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.MenuMain();
    }
}
