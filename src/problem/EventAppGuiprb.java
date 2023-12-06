//package problem;
//
//import db_objs.MyJDBC;
//import db_objs.User;
//import design.CustomButton;
//import design.CustomLabel;
//import design.CustomTextField;
//import guis.HomeFrame;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//
//public class EventAppGuiprb extends HomeFrame {
//
//
//    public EventAppGuiprb(User user){
//        super("Event Management System",user);
//    }
//
//    @Override
//    protected void addGuiComponents() {
//        //creating a custom label
//        CustomLabel userLabel= new CustomLabel("Welcome "+user.getName());
//
//        //set the location and the size of the gui component
//        userLabel.setBounds(0,20,super.getWidth(),40);
//        userLabel.setFont(new Font("Dialog",Font.BOLD, 32));
//        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        add(userLabel);
//
//        //add event label
//        CustomLabel addeventLabel= new CustomLabel("add a Event");
//
//        //set the location and the size of the gui component
//        addeventLabel.setBounds(0,70,super.getWidth(),24);
//        addeventLabel.setFont(new Font("Dialog",Font.BOLD, 32));
//        addeventLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        add(addeventLabel);
//
//
//        CustomLabel eventTitleLabel= new CustomLabel("title");
//
//        //set the location and the size of the gui component
//        addeventLabel.setBounds(0,110,super.getWidth(),24);
//        addeventLabel.setFont(new Font("Dialog",Font.BOLD, 32));
//        addeventLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        add(addeventLabel);
//
//        //event title
//        CustomTextField eventTitleTextField= new CustomTextField();
//        eventTitleTextField.setBounds(20,150,super.getWidth()-50,40);
//        eventTitleTextField.setFont(new Font("Dialog",Font.PLAIN, 28));
//        add(eventTitleTextField);
//
//
//        //set the location and the size of the gui component
//        CustomLabel eventDescLabel= new CustomLabel("description");
//        eventDescLabel.setBounds(0,200,super.getWidth(),24);
//        eventDescLabel.setFont(new Font("Dialog",Font.BOLD, 32));
//        eventDescLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        add(eventDescLabel);
//
//        //event desc
//        CustomTextField eventDescTextField= new CustomTextField();
//        eventDescTextField.setBounds(20,240,super.getWidth()-50,40);
//        eventDescTextField.setFont(new Font("Dialog",Font.PLAIN, 28));
//        add(eventDescTextField);
//
//
//
//        //LOGIN BUTTON
//        CustomButton addEventButton=new CustomButton("Add Event");
//        addEventButton.setBounds(20,300,400,40);
//        addEventButton.setFont(new Font("Dialog",Font.BOLD, 20));
////        addEventButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                //get username
////                String title= eventTitleTextField.getText();
////                //get username
////                String desc= eventDescTextField.getText();
////
////                //Event event=;
////
////
////
////
////                if(MyJDBC.addEvent(title,desc,user.getId())){
////                    //means valid login
////
////                    //dispose this gui
////                   // EventAppGui.this.dispose();
////
////                    //launch bank app gui
////                   // EventAppGui eventAppGui= new EventAppGui(user);
////                   // eventAppGui.setVisible(true);
//////                    BankingAppGui bankingAppGui = new BankingAppGui(user);
//////                    bankingAppGui.setVisible(true);
////
////                    //show the success dialog
////                    //JOptionPane.showMessageDialog(bankingAppGui, "Login Successfully!");
////                    JOptionPane.showMessageDialog(EventAppGui.this, "event add Successfully!");
////
////
////                }else{
////                    JOptionPane.showMessageDialog(EventAppGui.this, "event add failed...");
////                }
////
////            }
////        });
////        add(addEventButton);
//
//
//        addEventButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Get data from UI components
//                String title = eventTitleTextField.getText();
//                String desc = eventDescTextField.getText();
//
////                DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
////                DateTimeFormatter timeFormatter= DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
////
////                String dateString = "12/7/2024"; // Get the actual date from a date picker or another UI component
////                String timeString = "7:20 am"; // Get the actual time from a time picker or another UI component
////                LocalDate date=LocalDate.parse(dateString,dateFormatter);
////                LocalTime time=LocalTime.parse(timeString,timeFormatter);
//
//                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
//                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
//                String dateString = "12/7/2024";
//                String timeString = "7:20 am";
//                LocalDate date = LocalDate.parse(dateString, dateFormatter);
//                LocalTime time = LocalTime.parse(timeString, timeFormatter);
//
//                String location = "your_location_here"; // Get the actual location from a UI component
//                String eventType = "your_event_type_here"; // Get the actual event type from a UI component
//                boolean isPublic = true; // Set the actual value based on your UI
//                boolean isUniversity = true; // Set the actual value based on your UI
//                String token = "your_token_here"; // Get the actual token from a UI component
//
//                // Call the modified addEvent method
//                boolean eventAdded = MyJDBC.addEvent(title, desc, user.getId(), date, time, location,
//                        eventType, isPublic, isUniversity);
//
//                if (eventAdded) {
//                    JOptionPane.showMessageDialog(EventAppGuiprb.this, "Event added Successfully!");
//                } else {
//                    JOptionPane.showMessageDialog(EventAppGuiprb.this, "Event add failed...");
//                }
//            }
//        });
//        add(addEventButton);
//
//    }
//}
