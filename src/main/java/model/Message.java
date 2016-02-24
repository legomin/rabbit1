package model;

import java.util.Date;

/**
 * Created by Виталий on 05.01.2016.
 */
public class Message {
    private Date date;
    private String body, alert;
    private Users user;

    public Date getDate() {
        return date;
    }

    public Users getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public String getAlert() {
        return alert;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public Message(Users user, String body, String alert) {
        this.user = user;
        this.body = body;
        this.alert = alert;
        this.date = new Date();
    }

    public Message() {
    }
}
