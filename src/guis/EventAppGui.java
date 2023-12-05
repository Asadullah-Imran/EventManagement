package guis;

import db_objs.User;

import javax.swing.*;
import java.awt.*;

public class EventAppGui extends HomeFrame{
    EventAppGui(User user){
        super("Hello",user);


    }

    @Override
    protected void addGuiComponents() {

    }
}