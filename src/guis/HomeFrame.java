package guis;





import db_objs.User;
import design.CustomPanel;

import javax.swing.*;
import java.awt.*;

/*
    Createing an abstract class helps us setup the blueprint that our GUIs will follow for example in each of
    the GUIs they will be the same and will need to invoke their addGuiComponents()
    which will be unique to each subclass

 */
public abstract class HomeFrame extends JFrame {
    protected User user;
    public HomeFrame(String title){
        initialize(title);
    }
    public  HomeFrame(String title, User user){
        this.user=user;
        initialize(title);
    }
    private void initialize(String title){
        setTitle(title);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width,screenSize.height);
        //setSize(width,height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(null);
        setResizable(false);
        // Launch the gui in the center of the screen
        setLocationRelativeTo(null);
        //call on hte subclass addGuiComponents
        addGuiComponents();
//        CustomPanel customPanel = new CustomPanel();
//        customPanel.setBounds(0, 0, getWidth(), getHeight());
//        add(customPanel);

    }

    protected abstract void addGuiComponents();

}