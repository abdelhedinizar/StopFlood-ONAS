package a7amdon.enis.tn.stopflood_onas.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class NotificationsStack {
    public static ArrayList<Notification> notifications=new ArrayList<Notification>();


    public static ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public static void setNotifications(ArrayList<Notification> notifications) {
        NotificationsStack.notifications = notifications;
    }

    public static void addNotification(Notification k){
        notifications.add(k);
    }

    public static void deleteNotification(String id){
        Iterator<Notification> iter = notifications.listIterator();
        while( iter.hasNext() ) {
            Notification k = iter.next();
            if (k.getId()==id) {
                iter.remove();
            }
        }

    }
}
