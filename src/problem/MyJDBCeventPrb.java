//package problem;
//import db_objs.User;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import static java.sql.Date.valueOf;
//import static java.sql.Time.valueOf;
//
//
////JDBC class is used to interact with our MYSQL database to perform activities such as retrieving and
//// updating our database
//public class MyJDBCeventPrb {
//    //database configuration
//    //here you will add the database name (like mine is event)
//    private static final String DB_URL ="jdbc:mysql://127.0.0.1:3306/event";
//    //here you need to add the username for database (mine is root)
//    private static final String DB_USERNAME= "root";
//    //here you need to add the password (mine is password)
//    private static  final String DB_PASSWORD="password";
//
//    //Noe this validates login is performed for user validation
//    //if valid return an object with the user's information
//    public static User validateLogin(String username, String password){
//        try {
//            //establish a connection to the database using configuration
//            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
//            //create sql query (for getting information using select all)
//            PreparedStatement preparedStatement= connection.prepareStatement(
//                    //here we write sql code
//                    "SELECT * FROM users WHERE username = ? AND password= ?"
//            );
//            //replace the ? with values
//            preparedStatement.setString(1,username);
//            preparedStatement.setString(2,password);
//
//            //execute query and store into a result set
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            //next() return true or false
//            //true - query returned data and result set now points to the first row
//            // false - query returned no dat and result set equals to null
//            if(resultSet.next()){
//                //success
//                //get id
//                int userId=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                String email=resultSet.getString("email");
//
//
//                //return user object
//                return  new User(userId,name,email,username,password);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        //not valid user
//        return  null;
//    }
//
//    //true - register success
//    //false - register failed
//    public static boolean register(String name,String email,String username,String password){
//        try{
//            //first we will need to check if the username has already been taken
//            if(!checkUser(username)){
//                Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
//
//                PreparedStatement preparedStatement= connection.prepareStatement(
//                        "INSERT INTO users(name,email,username,password)"+"VALUES(?, ?,?,?)"
//                );
//                preparedStatement.setString(1,name);
//                preparedStatement.setString(2,email);
//                preparedStatement.setString(3,username);
//                preparedStatement.setString(4,password);
//
//                preparedStatement.executeUpdate();
//                return true;
//            }
//        }catch (SQLException e){
//            e.printStackTrace();}
//        return false;
//    }
//
//    //check if username already exists in the db
//    //true - user exists
//    //false - user doesn't exist
//    private  static boolean checkUser(String username){
//        try{
//            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
//            PreparedStatement preparedStatement= connection.prepareStatement(
//                    "SELECT * FROM users WHERE username = ?"
//
//            );
//            preparedStatement.setString(1,username);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            //this means that the query returned no data meaning that the username is available
//            if(!resultSet.next()){
//                return false;
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    //addEvent query action
//
////    public static boolean addEvent(String title,String description,int userId){
////        try{
////            Connection connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
////            PreparedStatement preparedStatement= connection.prepareStatement(
////                    "INSERT INTO ev(title,description,userId)"+"VALUES(?,?,?)"
//////                    , Statement.RETURN_GENERATED_KEYS
////
////            );
////            preparedStatement.setString(1,title);
////            preparedStatement.setString(2,description);
////            preparedStatement.setInt(3,userId);
////             preparedStatement.executeUpdate();
////
//////            if (rowsAffected > 0) {
//////                // Retrieve the generated keys
//////                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//////                if (generatedKeys.next()) {
//////                    int eventId = generatedKeys.getInt(1);
//////                    return new Event(eventId, title, description, userId);
//////                }
//////            }
////            return true;
////
////
////        }catch (SQLException e){
////            e.printStackTrace();
////        }
////        return false;
////    }
//
//    public static boolean addEvent(String title, String description, int userId, LocalDate date, LocalTime time,
//                                   String location, String eventType, boolean isPublic, boolean isUniversity) {
//        try {
//            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    "INSERT INTO EVENTS(title, description, date, time, location, eventType, isPublic, isUniversity, userId)" +
//                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
//            );
//            preparedStatement.setString(1, title);
//            preparedStatement.setString(2, description);
//            preparedStatement.setDate(3, valueOf(date));
//            preparedStatement.setTime(4, valueOf(time));
//            preparedStatement.setString(5, location);
//            preparedStatement.setString(6, eventType);
//            preparedStatement.setBoolean(7, isPublic);
//            preparedStatement.setBoolean(8, isUniversity);
//            //preparedStatement.setString(9, token);
//            preparedStatement.setInt(9, userId);
//
//            preparedStatement.executeUpdate();
//
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//}