package a7amdon.enis.tn.stopflood_onas.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class InterventionsHistory {
    public static ArrayList<Intervention> interventions=new ArrayList<Intervention>();



    public static ArrayList<Intervention> getNotifications() {
        return interventions;
    }

    public static void setNotifications(ArrayList<Intervention> notifications) {
        InterventionsHistory.interventions = notifications;
    }

    public static void addIntervention(Intervention k){
        interventions.add(k);
    }

    public static void deleteIntervention(String id){
        Iterator<Intervention> iter = interventions.listIterator();
        while( iter.hasNext() ) {
            Intervention k = iter.next();
            if (k.getId()==id) {
                iter.remove();
            }
        }

    }
}
