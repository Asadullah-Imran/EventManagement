package guis;

import db_objs.Events;
import db_objs.MyJDBC;
import db_objs.User;
import design.CustomButton;
import design.CustomLabel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends HomeFrame{
    public Home(User user){
        super("Event Management System",user);

    }

    @Override
    protected void addGuiComponents() {
        setLayout(new BorderLayout(10,10));
        JPanel topPanel=new JPanel();
        JPanel bottomPanel=new JPanel();
        JPanel rightPanel=new JPanel();
        JPanel leftPanel=new JPanel();
        JPanel centerPanel=new JPanel();

        topPanel.setBackground(Color.RED);
        bottomPanel.setBackground(Color.GREEN);
        leftPanel.setBackground(Color.GRAY);
        rightPanel.setBackground(Color.YELLOW);
        centerPanel.setBackground(Color.ORANGE);
        topPanel.setPreferredSize(new Dimension(100,100));
        bottomPanel.setPreferredSize(new Dimension(100,50));
        leftPanel.setPreferredSize(new Dimension(200,100));
        rightPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setPreferredSize(new Dimension(100,100));

    //Creating Layout for the panel
        topPanel.setLayout(null);
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));


        //creating a custom label
        CustomLabel userLabel= new CustomLabel("Welcome "+user.getName());
        //set the location and the size of the gui component
        userLabel.setBounds(0,20,super.getWidth(),40);
        userLabel.setFont(new Font("Dialog",Font.BOLD, 32));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(userLabel);
//
//
//        CustomLabel addeventLabel= new CustomLabel("add a Event");
//
//        //set the location and the size of the gui component
//        addeventLabel.setBounds(0,70,super.getWidth(),24);
//        addeventLabel.setFont(new Font("Dialog",Font.BOLD, 32));
//        addeventLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        add(addeventLabel);
//
//
//
//
//
//

        CustomLabel footerLabel= new CustomLabel("This System is Made by Tarequl, Tawfik, Redowan, Pulok and Asad");
        //set the location and the size of the gui component
        footerLabel.setBounds(0,70,super.getWidth(),24);
        footerLabel.setFont(new Font("Dialog",Font.BOLD, 22));
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);




        //button
        CustomButton addEventButton=new CustomButton("Add Event");
        addEventButton.setBounds(20,300,400,40);
        addEventButton.setFont(new Font("Dialog",Font.BOLD, 20));
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventAppGui eventAppGui= new EventAppGui(Home.this,user);
                eventAppGui.setVisible(true);
            }
        });

        //add(addEventButton);


        ArrayList<Events> allEvents= MyJDBC.showEvent();

        for (int i=0;i<allEvents.size();i++){
            Events event= allEvents.get(i);
            JPanel eventBox = new JPanel();
            eventBox.setLayout(new BoxLayout(eventBox,BoxLayout.Y_AXIS));
            CustomLabel eventTitleLabel = new CustomLabel(event.getTitle());
            eventTitleLabel.setFont(new Font("Dialog",Font.BOLD,20));
            eventTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            eventTitleLabel.setBounds(10,10,getWidth()-30,40);


            CustomLabel eventDescLabel = new CustomLabel(event.getDescription());
            eventDescLabel.setFont(new Font("Dialog",Font.BOLD,20));
            eventDescLabel.setHorizontalAlignment(SwingConstants.CENTER);
            eventDescLabel.setBounds(10,60,getWidth()-30,40);

            CustomLabel eventLocationLabel = new CustomLabel(event.getLocation());
            eventLocationLabel.setFont(new Font("Dialog",Font.BOLD,20));
            eventLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
            eventLocationLabel.setBounds(10,60,getWidth()-30,40);

            CustomButton eventGoing=new CustomButton("Going");
            //eventGoing.setBounds(20,300,400,40);
            eventGoing.setFont(new Font("Dialog",Font.BOLD, 20));
            eventGoing.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(user.getUsername());
                    System.out.println(user.getId());
                    System.out.println(user.getName());
                    System.out.println(event.getEventId());
                    System.out.println(event.getTitle());
                }
            });
            CustomButton eventInterested=new CustomButton("Interested");
            //eventInterested.setBounds(20,350,400,40);
            eventInterested.setFont(new Font("Dialog",Font.BOLD, 20));

            eventBox.add(eventTitleLabel);
            eventBox.add(eventDescLabel);
            eventBox.add(eventLocationLabel);
            centerPanel.add(eventBox);
            eventBox.add(eventGoing);
            eventBox.add(eventInterested);
        }


        //adding items
        leftPanel.add(addEventButton);
        bottomPanel.add(footerLabel);



        //System.out.println(allEvents);
        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.EAST);
        add(centerPanel,BorderLayout.CENTER);

    }



}
