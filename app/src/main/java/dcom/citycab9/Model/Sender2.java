package dcom.citycab9.Model;

public class Sender2 {

    public String to;
    public Notification notification;

    public Sender2() {
    }

    public Sender2(String to, Notification notification) {
        this.to = to;
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}

