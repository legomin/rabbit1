package model;

/**
 * Created by Виталий on 05.01.2016.
 */
public class MessageFilter {
    private Users user;
    private Events event;
    private String alert;

    public Users getUser() {
        return user;
    }

    public Events getEvent() {
        return event;
    }

    public String getAlert() {
        return alert;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public MessageFilter(Users user, Events event, String alert) {
        this.user = user;
        this.event = event;
        this.alert = alert;
    }

    public MessageFilter() {
    }
}
