package com.example.beta_projet;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessaginfService extends FirebaseMessagingService {
    private static final String CANAL = "MyNotifCanal";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String myMessage = remoteMessage.getNotification().getBody();
        Log.d("FirebaseMessage", "Vous venez de recevoir une notification : "+ myMessage);

   //ACTION
        /*rediriger vers une page web
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fr.wikipedia.org/wiki/Wombat"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
*/
        //Rediriger vers l'app
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

    // Créer une notif
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,CANAL);
        notificationBuilder.setContentTitle("La notif de la mort");
        notificationBuilder.setContentText(myMessage);

        //AJOUTER L'ACTION
        notificationBuilder.setContentIntent(pendingIntent);

        // VIBRATION
        long[] vibrationPattern = {500,1000};
        notificationBuilder.setVibrate(vibrationPattern);
        // ICONE
        notificationBuilder.setSmallIcon(R.drawable.bell);

        //ENVOI
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = getString(R.string.notification_channel_id);
            String channelTitle = getString(R.string.notification_channel_title);
            String channelDescription = getString(R.string.notification_channel_desc);
            NotificationChannel channel = new NotificationChannel(channelId, channelTitle, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);
            notificationManager.createNotificationChannel(channel);
            notificationBuilder.setChannelId(channelId);


        }

        notificationManager.notify(1, notificationBuilder.build());


    }
}
