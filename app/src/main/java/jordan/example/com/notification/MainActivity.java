package jordan.example.com.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify(View view){
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(getString(R.string.notification));
        builder.setContentText(getString(R.string.receive_notification));
        builder.setSmallIcon(android.R.drawable.sym_action_chat);

        Intent intent = new Intent(this, MessageActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);

        Notification n = builder.build();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(100, n);
    }

}
