package db_objs;
import java.sql.*;


//JDBC class is used to interact with our MYSQL database to perform activities such as retrieving and
// updating our database
public class MyJDBC {
    //database configuration
    //here you will add the database name (like mine is event)
    private static final String DB_URL ="jdbc:mysql://127.0.0.1:3306/event";
    //here you need to add the username for database (mine is root)
    private static final String DB_USERNAME= "root";
    //here you need to add the password (mine is password)
    private static  final String DB_PASSWORD="password";

    //Noe this validates login is performed for user validation
    //if valid return an object with the user's information
    public static User validateLogin(String username, String password){
        try {
            //establish a connection to the database using configuration
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            //create sql query (for getting information using select all)
            PreparedStatement preparedStatement= connection.prepareStatement(
                    //here we write sql code
                    "SELECT * FROM users WHERE username = ? AND password= ?"
            );
            //replace the ? with values
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            //execute query and store into a result set
            ResultSet resultSet = preparedStatement.executeQuery();

            //next() return true or false
            //true - query returned data and result set now points to the first row
            // false - query returned no dat and result set equals to null
            if(resultSet.next()){
                //success
                //get id
                int userId=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");


                //return user object
                return  new User(userId,name,email,username,password);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //not valid user
        return  null;
    }

    //true - register success
    //false - register failed
    public static boolean register(String name,String email,String username,String password){
        try{
            //first we will need to check if the username has already been taken
            if(!checkUser(username)){
                Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

                PreparedStatement preparedStatement= connection.prepareStatement(
                        "INSERT INTO users(name,email,username,password)"+"VALUES(?, ?,?,?)"
                );
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,email);
                preparedStatement.setString(3,username);
                preparedStatement.setString(4,password);

                preparedStatement.executeUpdate();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();}
        return false;
    }

    //check if username already exists in the db
    //true - user exists
    //false - user doesn't exist
    private  static boolean checkUser(String username){
        try{
            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement preparedStatement= connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            //this means that the query returned no data meaning that the username is available
            if(!resultSet.next()){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

}