package db_objs;

public class Events {
    private int eventId;
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;
    private String eventType;
    private boolean isPublic;
    private boolean isUniversity;
    private String token;
    private int userId;

    public Events(int eventId, String title, String description, String date, String time, String location,
                  String eventType, boolean isPublic, boolean isUniversity, int userId) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.eventType = eventType;
        this.isPublic = isPublic;
        this.isUniversity = isUniversity;
        //this.token = token;
        this.userId = userId;
    }

    // Getters and setters for each field (omitted for brevity)

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean isUniversity() {
        return isUniversity;
    }

    public void setUniversity(boolean isUniversity) {
        this.isUniversity = isUniversity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

