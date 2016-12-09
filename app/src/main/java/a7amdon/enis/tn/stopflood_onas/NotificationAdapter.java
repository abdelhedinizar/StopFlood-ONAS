package a7amdon.enis.tn.stopflood_onas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import a7amdon.enis.tn.stopflood_onas.operations.NotificationStackManager;
import a7amdon.enis.tn.stopflood_onas.util.Notification;
import a7amdon.enis.tn.stopflood_onas.util.Street;

/**
 * Created by 7amdon on 28/10/2016.
 */

public class NotificationAdapter extends ArrayAdapter<Notification>{

    public static final int DETAIL_REQUEST = 1;
    private Context mContext;
    public Notification[] list_Notifications;
    public int layoutRessourceId;


    public NotificationAdapter(Context context, int resource, Notification[] list_Notifications) {
        super(context, resource, list_Notifications);
        this.mContext = context;
        this.layoutRessourceId = resource;
        this.list_Notifications = list_Notifications;
    }

    @Override
    public Notification getItem(int position) {
        return super.getItem(position);
    }

    //La méthode aprés l'ajout du PlaceHolder pour le recall des lignes déja consultées et minimiser le process de l'app
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        NotificationHolder holder = null;

        //if we currently don’t have a row View to reuse..
        if(row == null){
            // Create a new View
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(layoutRessourceId,parent,false);

            holder = new NotificationHolder(row);


            holder.regard_infos = (TextView) row.findViewById(R.id.regard_infos);
            holder.regard_date = (TextView) row.findViewById(R.id.regard_date);
            holder.Notification_recommended = (TextView) row.findViewById(R.id.Notification_recommended);
         //   holder.regard_intervention = (Button) row.findViewById(R.id.regard_intervention);

            holder.setbtt();


            row.setTag(holder);
        }else{
            //Otherwise use an existing one
            holder = (NotificationHolder) row.getTag();
        }


        // Getting the data form the data array

        Notification notification = list_Notifications[position];
        NotificationStackManager notificationStackManager = new NotificationStackManager();
        String prioritaire="";
        ImageView imageView = (ImageView) row.findViewById(R.id.image);
        int niveau = notification.getNiveau();
        switch (niveau){
            case 1 : imageView.setBackground(row.getContext().getResources().getDrawable(R.drawable.ic_battery_20));
                break;
            case 2 :  imageView.setBackground(row.getContext().getResources().getDrawable(R.drawable.ic_battery_50));
                break;
            case 3 :  imageView.setBackground(row.getContext().getResources().getDrawable(R.drawable.ic_battery_full));
                break;
        }

        if (notification.equals(notificationStackManager.getListNotificationsByHighestPopulation().get(0)))
        {
            if (notification.equals(notificationStackManager.getListNotificationsByHighestPopulation().size()==1)) prioritaire = " ( Prioritaire ) ";
            else{
                if(notification.equals(notificationStackManager.getLatestNotification(notificationStackManager.getListNotificationsByHighestPopulation())))
                    prioritaire = " (Prioritaire) ";
            }
        }


        //setting the view to reflect the data we need to display
        holder.regard_date.setText(notification.getDate().getDate()+"/"+notification.getDate().getMonth()+"/"+notification.getDate().getYear()+" , "+notification.getDate().getHours()+":"+notification.getDate().getMinutes());
        String street = notification.getRegard().getStreet().getName();
        String dlg = notification.getRegard().getStreet().getDelegation().getName();
        String gvmt = notification.getRegard().getStreet().getDelegation().getGouvernerat().getName();
        holder.regard_infos.setText(gvmt+" , "+dlg+" , "+street);

        holder.Notification_recommended.setText(prioritaire);

        //returning the row (because this is called getView after all)

        return row;


    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            Notification p = list_Notifications[viewPosition];
            //Toast.makeText(getContext(), p.getDescription(), Toast.LENGTH_SHORT).show();
        }
    };

    private static class NotificationHolder {
        TextView regard_infos;
        TextView regard_date;
 //       Button regard_intervention;
        TextView Notification_recommended;

        public  NotificationHolder(View v)
        {

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),Notification_Info.class);
                    //intent.putExtra("level_selected",""+level_number.getTag(level_number.getId()) );
                    view.getContext().startActivity(intent);
                }
            });

        }
        public void setbtt()
        {
   /*         regard_intervention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),Notification_Info.class);
                    //intent.putExtra("level_selected",""+level_number.getTag(level_number.getId()) );
                    view.getContext().startActivity(intent);
                }
            });
     */   }
    }

}