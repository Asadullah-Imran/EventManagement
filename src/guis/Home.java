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
        bottomPanel.setPreferredSize(new Dimension(100,100));
        leftPanel.setPreferredSize(new Dimension(100,100));
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
//        //button
//        CustomButton addEventButton=new CustomButton("Add Event");
//        addEventButton.setBounds(20,300,400,40);
//        addEventButton.setFont(new Font("Dialog",Font.BOLD, 20));
//        addEventButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                EventAppGui eventAppGui= new EventAppGui(Home.this,user);
//                eventAppGui.setVisible(true);
//            }
//        });
//
//        add(addEventButton);


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


            eventBox.add(eventTitleLabel);
            eventBox.add(eventDescLabel);
            centerPanel.add(eventBox);

        }
        System.out.println(allEvents);
        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.EAST);
        add(centerPanel,BorderLayout.CENTER);

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





//    public void addPastTransactionComponents(){
//        //container where we will store each transaction
//        pastTransactionPanel= new CustomPanel();
//
//        //make layout 1x1
//        pastTransactionPanel.setLayout(new BoxLayout(pastTransactionPanel, BoxLayout.Y_AXIS));
//        //add scrollablity to the container
//        JScrollPane scrollPane= new JScrollPane(pastTransactionPanel);
//        //displays the vertical scroll only when it is required
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBounds(10,20,getWidth()-30,getHeight()-70);
//
//        //perform db call to retrieve all of the past transaction and store intto arraylist
//        pastTransactions=MyJDBC.getPastTransaction(user);
//
//        //iterate through the list and to the gui
//        for(int i=0; i<pastTransactions.size();i++){
//            //store current transaction
//            Transaction pastTransaction = pastTransactions.get(i);
//
//            //create a container to store an individual transaction
//            CustomPanel pastTransactionContainer = new CustomPanel();
//            pastTransactionContainer.setLayout(new BorderLayout());
//
//            //create transaction type label
//            CustomLabel transactionTypeLabel = new CustomLabel(pastTransaction.getTransactionType());
//            transactionTypeLabel.setFont(new Font("Dialog",Font.BOLD,20));
//
//            //create transaction amount label
//            CustomLabel transactionAmountLabel = new CustomLabel(String.valueOf(pastTransaction.getTransactionAmount()));
//            transactionAmountLabel.setFont(new Font("Dialog",Font.BOLD,20));
//
//            //create transactiondate label
//            CustomLabel transactionDateLabel = new CustomLabel(String.valueOf(pastTransaction.getTransactionDate()));
//            transactionDateLabel.setFont(new Font("Dialog",Font.BOLD,20));
//
//            //add to the container
//            pastTransactionContainer.add(transactionTypeLabel,BorderLayout.WEST);
//            pastTransactionContainer.add(transactionAmountLabel,BorderLayout.EAST);
//            pastTransactionContainer.add(transactionDateLabel,BorderLayout.SOUTH);
//
//            //give a while background to each container
//            pastTransactionContainer.setBackground(Color.WHITE);
//
//            //give a black border to each transaction container
//            pastTransactionContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//
//            //add transaction component to the transaction label
//            pastTransactionPanel.add(pastTransactionContainer);
//
//        }
//
//
//        //add to the dialog
//        add(scrollPane);
//
//    }
//


}
