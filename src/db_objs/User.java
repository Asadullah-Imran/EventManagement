package db_objs;

//This is a user class (Here you will get the structure of users table data)
public class User {
    private final int id;
    private final String username,password,name,email;


    public User(int id,String name,String email ,String username, String password ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }



    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
