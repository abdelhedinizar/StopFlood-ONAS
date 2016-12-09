package a7amdon.enis.tn.stopflood_onas.operations;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import a7amdon.enis.tn.stopflood_onas.util.Notification;
import a7amdon.enis.tn.stopflood_onas.util.NotificationsStack;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class NotificationStackManager {

    public ArrayList<Notification> getListNotificationsByHighestPopulation(){

        if (NotificationsStack.getNotifications().size()==0)
        {
            return null;
        }
        else
        {
            ArrayList<Notification> listNotif = new ArrayList<Notification>();
            Notification notifMax = NotificationsStack.getNotifications().get(0);

            for (int i =0; i< NotificationsStack.getNotifications().size();i++)
            {
                if(NotificationsStack.getNotifications().get(i).getRegard().getStreet().getDelegation().getPopulationByThousands()
                        >= notifMax.getRegard().getStreet().getDelegation().getPopulationByThousands() )
                    notifMax  = NotificationsStack.getNotifications().get(i);
            }

            for (int i =0; i< NotificationsStack.getNotifications().size();i++)
            {
                if(NotificationsStack.getNotifications().get(i).getRegard().getStreet().getDelegation().getPopulationByThousands()
                        == notifMax.getRegard().getStreet().getDelegation().getPopulationByThousands() )
                    listNotif.add(NotificationsStack.getNotifications().get(i));
            }

            return listNotif;
        }
    }

    public Notification getLatestNotification(ArrayList<Notification> listNotifications){
        if (listNotifications.size() == 0){
            Log.v("*** NULL variable","liste des notifications vide");
            return null;
        }
        else{
            Notification notif = listNotifications.get(0);
            for (int i =0 ; i<listNotifications.size();i++){
                if (listNotifications.get(i).getDate().after(notif.getDate()))
                    notif = listNotifications.get(i);
            }
            return notif;
        }

    }

    public static Date getExactDate(String str){
        Date d = null;
        //pattern yyyy-MM-dd'T'HH:mm:ss.SSSZ
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        try {
            Log.i("IOKKMM","azert");
            d = format.parse(str.substring(0,str.indexOf('.')));
            return  d;
        } catch (ParseException e) {

            Log.i("IOKKMM",e.getMessage());
            return new Date();
        }

    }

}
