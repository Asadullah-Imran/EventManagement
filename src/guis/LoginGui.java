package guis;
        import db_objs.MyJDBC;
        import db_objs.User;
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

/*
    This gui will allow user to login or launch the register gui
*/
public class LoginGui extends BaseFrame{

    public LoginGui(){
        super("Event Management System Login",400,600);
    }
    @Override
    protected void addGuiComponents() {
        //create banking alabel
        CustomLabel bankingApplabel= new CustomLabel("Event Management System");

        //set the location and the size of the gui component
        bankingApplabel.setBounds(0,20,super.getWidth(),40);

        bankingApplabel.setFont(new Font("Dialog",Font.BOLD, 32));
        bankingApplabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingApplabel);


        //USERNAME LABEL
        CustomLabel usernameLabel= new CustomLabel("Username:");

        usernameLabel.setBounds(20,120,super.getWidth()-30,24);
        usernameLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        add(usernameLabel);

        //USERNAME TEXT FIELD
        CustomTextField usernameField= new CustomTextField();
        usernameField.setBounds(20,160,super.getWidth()-50,40);
        usernameField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(usernameField);


        //PASSWORD LABEL
        CustomLabel passwordLabel= new CustomLabel("Password:");

        passwordLabel.setBounds(20,280,super.getWidth()-50,24);
        passwordLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        add(passwordLabel);

        //PASSWORD TEXT FIELD
        CustomPasswordField passwordField= new CustomPasswordField();
        passwordField.setBounds(20,320,super.getWidth()-50,40);
        passwordField.setFont(new Font("Dialog",Font.PLAIN, 28));
        add(passwordField);


        //LOGIN BUTTON
        CustomButton loginButton=new CustomButton("Login");
        loginButton.setBounds(20,460,super.getWidth()-50,40);
        loginButton.setFont(new Font("Dialog",Font.BOLD, 20));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get username
                String username= usernameField.getText();

                //get Password
                String password = String.valueOf(passwordField.getPassword());

                //validate login (if invalid then it will return null)
                //if this username and password is valid it will return an object of User.
                // so by this user I got all the info of user.
                User user= MyJDBC.validateLogin(username,password);

                //if user is null it means invalid otherwise it is a valid

                if(user!=null){
                    //means valid login

                    //dispose this gui
                    LoginGui.this.dispose();

                    //launch bank app gui
                    Home home=new Home(user);
                    home.setVisible(true);
//                    EventAppGui eventAppGui= new EventAppGui(user);
//                    eventAppGui.setVisible(true);
//                    BankingAppGui bankingAppGui = new BankingAppGui(user);
//                    bankingAppGui.setVisible(true);

                    //show the success dialog
                    //JOptionPane.showMessageDialog(bankingAppGui, "Login Successfully!");
                    JOptionPane.showMessageDialog(home, "Login Successfully!");


                }else{
                    JOptionPane.showMessageDialog(LoginGui.this, "Login failed...");
                }

            }
        });
        add(loginButton);

        //CREATE REGISTER LABEL
        CustomLabel registerLabel=new CustomLabel("<html><a href=\"#\"> Don't have an account? Register Here </a></html>");
        registerLabel.setBounds(0,510,super.getWidth()-10,30);
        registerLabel.setFont(new Font("Dialog",Font.PLAIN, 20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //adding an event listener so when the mouse is clicked it will launch the register gui
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //dispose of this gui
                LoginGui.this.dispose();

                //launch the register gui
                new RegisterGui().setVisible(true);
            }
        });
        add(registerLabel);


    }
}