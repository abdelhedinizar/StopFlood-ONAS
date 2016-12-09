package a7amdon.enis.tn.stopflood_onas;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import a7amdon.enis.tn.stopflood_onas.api.HTTPDataHandler;
import a7amdon.enis.tn.stopflood_onas.api.ParseJSONfromServer;
import a7amdon.enis.tn.stopflood_onas.operations.NotificationStackManager;
import a7amdon.enis.tn.stopflood_onas.util.Delegation;
import a7amdon.enis.tn.stopflood_onas.util.Gouvernerat;
import a7amdon.enis.tn.stopflood_onas.util.Notification;
import a7amdon.enis.tn.stopflood_onas.util.NotificationsStack;
import a7amdon.enis.tn.stopflood_onas.util.Regard;
import a7amdon.enis.tn.stopflood_onas.util.Street;

public class MainActivity extends AppCompatActivity {



    ListView listView_Notification = null;
    //private NotificationAdapter notificationAdapter;
    //private static String  urlString = "http://192.168.8.100:8080/stopfloods/alert.json";

    private static String  urlString = "http://microdev.xyz/alerte/view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_Notification = (ListView) findViewById(R.id.listView_Notifications);
        Date d = NotificationStackManager.getExactDate("2016-10-29T19:35:12.536Z");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(d.getMinutes());
       /* new ParseJSONfromServer().execute(urlString);
        notificationAdapter = new NotificationAdapter(getApplicationContext(),R.layout.row, NotificationsStack.getNotifications().toArray(new Notification[NotificationsStack.getNotifications().size()]) );
        if (listView_Notification != null)
        {
            listView_Notification.setAdapter(notificationAdapter);
        }
        if (NotificationsStack.getNotifications().size()==0)
            Toast.makeText(getApplicationContext(),"Pas de notifications",Toast.LENGTH_LONG).show();*/


        /*listView_Notification.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),myPlacesArray[position].getName(),Toast.LENGTH_SHORT).show();

            }

        });*/

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(getApplicationContext(),InterventionsHistory.class);
                //intent.putExtra("level_selected",""+level_number.getTag(level_number.getId()) );
                getApplicationContext().startActivity(intent);
                return false;
            }
        });
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onResume() {
        super.onResume();

        new ParseJSONfromServer(getApplicationContext(),listView_Notification).execute(urlString);


    }
} // Activity end