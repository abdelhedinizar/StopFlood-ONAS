package a7amdon.enis.tn.stopflood_onas.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import a7amdon.enis.tn.stopflood_onas.MainActivity;
import a7amdon.enis.tn.stopflood_onas.NotificationAdapter;
import a7amdon.enis.tn.stopflood_onas.R;
import a7amdon.enis.tn.stopflood_onas.operations.NotificationStackManager;
import a7amdon.enis.tn.stopflood_onas.util.Delegation;
import a7amdon.enis.tn.stopflood_onas.util.Gouvernerat;
import a7amdon.enis.tn.stopflood_onas.util.Notification;
import a7amdon.enis.tn.stopflood_onas.util.NotificationsStack;
import a7amdon.enis.tn.stopflood_onas.util.Regard;
import a7amdon.enis.tn.stopflood_onas.util.Street;

/**
 * Created by 7amdon on 28/10/2016.
 */

public class ParseJSONfromServer extends AsyncTask<String, Void, String>{

    Context ctx;
    ListView listView_Notification=null;
        protected String doInBackground(String... strings){
            String stream = null;
            String urlString = strings[0];

            HTTPDataHandler hh = new HTTPDataHandler();
            stream = hh.GetHTTPData(urlString);

            // Return the data from specified url
            return stream;
        }

    public ParseJSONfromServer(Context c,ListView listView_Notification) {
        ctx = c;
        this.listView_Notification = listView_Notification;
    }

    @Override
        protected void onPostExecute(String stream){

            //..........Process JSON DATA................
            if(stream !=null && stream !=""){
                try{
                    // Get the full HTTP Data as JSONObject
                    JSONObject alert1= new JSONObject(stream);

                    String error = alert1.getString("error");
                    if (Integer.parseInt(error)==0)
                    {
                    JSONArray notifications_array = alert1.getJSONArray("list");
                    NotificationsStack.setNotifications(new ArrayList<Notification>());
                    for (int i=0;i<notifications_array.length();i++) {
                        String notification_st = notifications_array.getString(i);
                        JSONObject notification_object = new JSONObject(notification_st);
                        String notification_id = notification_object.getString("_id");
                        String notification_niveau = notification_object.getString("niveau");
                        int niveau = Integer.parseInt(notification_niveau);


                        //JSONObject date_object = new JSONObject(notification_object.getString("date"));
                        /*int year = Integer.parseInt(date_object.getString("year"));
                        int month = Integer.parseInt(date_object.getString("month"));
                        int date = Integer.parseInt(date_object.getString("date"));
                        int hrs = Integer.parseInt(date_object.getString("hrs"));
                        int min = Integer.parseInt(date_object.getString("min"));*/
                        Date notification_date = NotificationStackManager.getExactDate(notification_object.getString("date"));
                        notification_date.setMonth(notification_date.getMonth()+1);
                        notification_date.setYear(notification_date.getYear()+1900);

                        JSONObject regard_object = new JSONObject(notification_object.getString("regard"));
                        String gsm_number = regard_object.getString("gsm_number");

                        JSONObject street_object = new JSONObject(regard_object.getString("street"));
                        String street_id = street_object.getString("_id");
                        String street_name = street_object.getString("name");

                        JSONObject delegation_object = new JSONObject(street_object.getString("delegation"));
                        String delegation_id = delegation_object.getString("_id");
                        String delegation_name = delegation_object.getString("name");
                        double delegation_populationByThousands = Double.parseDouble(delegation_object.getString("PopulationByThousands"));

                        JSONObject gouvernerat_object = new JSONObject(delegation_object.getString("gouvernerat"));
                        String gouvernerat_id = gouvernerat_object.getString("_id");
                        String gouvernerat_name = gouvernerat_object.getString("name");
                        double gouvernerat_populationByThousands = Double.parseDouble(gouvernerat_object.getString("PopulationByThousands"));

                        Gouvernerat gouvernerat = new Gouvernerat(gouvernerat_id, gouvernerat_name, gouvernerat_populationByThousands);
                        Delegation delegation = new Delegation(delegation_id, delegation_name, delegation_populationByThousands, gouvernerat);
                        Street street = new Street(street_id, street_name, delegation);
                        Regard regard = new Regard(gsm_number, street, false); // car il dérive d'un dépassement d'eau
                        Notification notification = new Notification(notification_id, notification_date, regard, false, niveau);

                        //add to stack
                        NotificationsStack.addNotification(notification);
                        //tv.setText("mmmmmmmmmmmmmmmmmmmmmm    :    "+notification.getRegard().getGSM_number());
                        Log.d("Parsing", " ID : " + notification_id);
                        Log.d("date", " date : " + notification_date.getDate() + "  /  " + notification_date.getMonth());
                        Log.d("GSM NUMBER", " GSM NUMBER : " + gsm_number);
                        Log.d("delegation_id", " delegation_id : " + delegation_id);
                        Log.d("gv_pop", " gv_pop : " + gouvernerat_populationByThousands);
                        Log.d("dlg_pop", " dlg_pop : " + delegation_populationByThousands);

                        NotificationAdapter notificationAdapter = new NotificationAdapter(ctx,R.layout.row, NotificationsStack.getNotifications().toArray(new Notification[NotificationsStack.getNotifications().size()]) );
                        {
                            //ListView listView_Notification = (ListView) MainActivity.findViewById(R.id.listView_Notifications);
                            listView_Notification.setAdapter(notificationAdapter);
                        }

                    }
                    }








                }catch(JSONException e){
                    e.printStackTrace();
                }

            } // if statement end
            else{
                return;
            }
        } // onPostExecute() end

}
