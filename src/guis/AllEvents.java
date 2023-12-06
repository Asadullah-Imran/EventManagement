package guis;

import db_objs.Events;
import db_objs.MyJDBC;
import db_objs.User;
import design.CustomLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllEvents extends JDialog {

    public AllEvents(JFrame parent, User user) {
        super(parent, "All Events", true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
addAllEvents();

    }

    public void addAllEvents(){
        //container where we will store each transaction
        JPanel allEventsPanel = new JPanel();
        //make layout 1x1
        allEventsPanel.setLayout(new BoxLayout(allEventsPanel, BoxLayout.Y_AXIS));
        //add scrollablity to the container
        JScrollPane scrollPane= new JScrollPane(allEventsPanel);
        //displays the vertical scroll only when it is required
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10,20,getWidth()-30,getHeight()-70);

        //perform db call to retrieve all of the past transaction and store intto arraylist
        ArrayList<Events> allEvents= MyJDBC.showEvent();

        //iterate through the list and to the gui
        for(int i=0; i<allEvents.size();i++){
            Events event= allEvents.get(i);
            //create a container to store an individual transaction
            JPanel eventContainer = new JPanel();
            eventContainer.setLayout(new BorderLayout());


            CustomLabel eventTitleLabel = new CustomLabel(event.getTitle());
            eventTitleLabel.setFont(new Font("Dialog",Font.BOLD,20));


            CustomLabel eventDescLabel = new CustomLabel(event.getDescription());
            eventDescLabel.setFont(new Font("Dialog",Font.BOLD,20));

            CustomLabel eventTypeLabel = new CustomLabel(event.getEventType());
            eventTypeLabel.setFont(new Font("Dialog",Font.BOLD,20));

            CustomLabel eventLocationLabel = new CustomLabel(event.getLocation());
            eventLocationLabel.setFont(new Font("Dialog",Font.BOLD,20));

            //create transaction location label
            add(eventContainer);
            add(eventLocationLabel);
            add(eventTypeLabel);
            add(eventDescLabel);
            add(eventTitleLabel);

        }
    }



}
