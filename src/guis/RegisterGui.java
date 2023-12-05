package guis;

import db_objs.MyJDBC;
import design.CustomButton;
import design.CustomLabel;
import design.CustomPasswordField;
import design.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterGui extends BaseFrame{
    public RegisterGui(){
        super("Event Management System Register",400,600);
    }
    @Override
    protected void addGuiComponents() {
        //create Event label
        CustomLabel bankingApplabel= new CustomLabel("Event Management System");

        //set the location and the size of the gui component
        bankingApplabel.setBounds(0,20,super.getWidth(),40);

        bankingApplabel.setFont(new Font("Dialog",Font.BOLD, 32));
        bankingApplabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingApplabel);


        //USERNAME LABEL
        CustomLabel usernameLabel= new CustomLabel("Username:");

        usernameLabel.setBounds(20,80,super.getWidth()-30,24);
        usernameLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        add(usernameLabel);

        //USERNAME TEXT FIELD
        CustomTextField usernameField= new CustomTextField();
        usernameField.setBounds(20,120,super.getWidth()-50,40);
        usernameField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(usernameField);

        //USERNAME TEXT FIELD
        CustomTextField nameField= new CustomTextField();
        nameField.setBounds(20,170,super.getWidth()-50,40);
        nameField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(nameField);

        //USERNAME TEXT FIELD
        CustomTextField emailField= new CustomTextField();
        emailField.setBounds(20,220,super.getWidth()-50,40);
        emailField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(emailField);


        //PASSWORD LABEL
        CustomLabel passwordLabel= new CustomLabel("Password:");

        passwordLabel.setBounds(20,270,super.getWidth()-50,24);
        passwordLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        add(passwordLabel);

        //PASSWORD TEXT FIELD
        CustomPasswordField passwordField= new CustomPasswordField();
        passwordField.setBounds(20,300,super.getWidth()-50,40);
        passwordField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(passwordField);

        //ReeeeePASSWORD LABEL
        CustomLabel rePasswordLabel= new CustomLabel("Re-type Password:");

        rePasswordLabel.setBounds(20,350,super.getWidth()-50,24);
        rePasswordLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        add(rePasswordLabel);

        //ReeeeeePASSWORD TEXT FIELD
        CustomPasswordField rePasswordField= new CustomPasswordField();
        rePasswordField.setBounds(20,380,super.getWidth()-50,40);
        rePasswordField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(rePasswordField);


        //Register BUTTON
        CustomButton registerButton=new CustomButton("Register");
        registerButton.setBounds(20,430,super.getWidth()-50,40);
        registerButton.setFont(new Font("Dialog",Font.BOLD, 20));
        //use action performed in register button so when a user try to registration and
        // press the register button then this action listener will call
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get username
                String name = nameField.getText();
                //get username
                String email = emailField.getText();
                //get username
                String username = usernameField.getText();
                //get password
                String password= String.valueOf(passwordField.getPassword());

                //get repassword
                String rePassword = String.valueOf(rePasswordField.getPassword());

                //we need to validate user input
                if(validateUserInput(name,email,username,password,rePassword)){
                    //attempt to register the user to the database
                    if(MyJDBC.register(name,email,username,password)){
                        //register success
                        //dispose of this Gui
                        RegisterGui.this.dispose();

                        //launch the login gui
                        LoginGui loginGui = new LoginGui();
                        loginGui.setVisible(true);

                        //create a result dialog
                        JOptionPane.showMessageDialog(loginGui,"Register Account Successful!");

                    }else{
                        //register failed
                        JOptionPane.showMessageDialog(RegisterGui.this, "Error: Username already Taken");
                    }
                }else{
                    //invalid user input (validation failed)
                    // error message
                    JOptionPane.showMessageDialog(RegisterGui.this, "Error: Username must be at least 4 characters\n" +
                            "and/or password must match");
                }

            }
        });
        add(registerButton);

        //CREATE Login LABEL
        CustomLabel loginLabel=new CustomLabel("<html><a href=\"#\"> Already have an account? Login Here </a></html>");
        loginLabel.setBounds(0,510,super.getWidth()-10,30);
        loginLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //dispose of this gui
                RegisterGui.this.dispose();
                //launch the login gui
                new LoginGui().setVisible(true);
            }
        });
        add(loginLabel);
    }

    private boolean validateUserInput(String name,String email,String username,String password, String rePassword){
        if(name.length()==0||email.length()==0||username.length()==0||password.length()==0||rePassword.length()==0)return false;

        //username has to be at least 4 characters long
        if(username.length()<4)return false;

        //password and re-password must be the same
        if(!password.equals(rePassword))return false;

        //passes validation
        return true;
    }
}