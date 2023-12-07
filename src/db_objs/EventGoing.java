package db_objs;

public class EventGoing {
    private int eventGoingId;
    private int userId;
    private int eventId;
    public EventGoing(int eventGoingId, int user, int eventId) {
        this.eventGoingId=eventGoingId;
        this.userId=user;
        this.eventId=eventId;
    }

    public int getEventGoingId() {
        return eventGoingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getEventId() {
        return eventId;
    }
}
