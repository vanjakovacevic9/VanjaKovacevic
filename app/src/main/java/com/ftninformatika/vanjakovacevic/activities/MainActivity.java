package com.ftninformatika.vanjakovacevic.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ftninformatika.vanjakovacevic.R;
import com.ftninformatika.vanjakovacevic.database.DataBaseHelper;
import com.ftninformatika.vanjakovacevic.model.Group;
import com.ftninformatika.vanjakovacevic.model.Todo;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ListView listView;
    private List<Group> list;

    private Toolbar toolbar;
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;

    private ArrayAdapter<Group> adapter;

    private Dialog dialog;
    private EditText etName;


    private Button btnOk;
    private Button btnCancel;

    private DataBaseHelper databaseHelper;

    public static final String NOTIFICATION_CHANNEL_ID = "111";
    public static String NOTIF_TOAST = "notification_toast";
    public static String NOTIF_STATUS = "notification_status";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= findViewById(R.id.toolbar_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar.setTitle("Grupa TODO zadataka");
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.show();

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.nav_about:
                        showAbout();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_podesavanja:
                        showSettings();
                        break;

                }
                return false;
            }
        });

        listView = findViewById(R.id.list_view);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add);
        dialog.setCancelable(false);

        etName = dialog.findViewById(R.id.etName);
        listView = dialog.findViewById(R.id.listV1);
        listView = dialog.findViewById(R.id.listV2);

        btnCancel = dialog.findViewById(R.id.btnCancel);
        btnOk = dialog.findViewById(R.id.btnOk);

        try {
            list = getDatabaseHelper().getGroupDao().queryForAll();
            Log.d(TAG, "onCreate: QUERY FOR ALL SUCCESS " + list.size());
        } catch (SQLException e) {
            Log.e(TAG, "onCreate: QUERY FOR ALL ERROR " + e);
        }

        if (list == null) {
            list = new ArrayList<>();
        }

        adapter = new ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Group item = list.get(position);
                int itemID = item.getId();

                Intent intent = new Intent(MainActivity.this, Todo.class);

                startActivity(intent);
            }
        });
    }

    public DataBaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DataBaseHelper.class);
        }
        return databaseHelper;
    }
    private void refreshAdapter() {

        adapter.clear();

        try {
            list = getDatabaseHelper().getGroupDao().queryForAll();
            Log.d(TAG, "refreshAdapter: ADAPTER SIZE " + list.size());
        } catch (SQLException e) {
            Log.d(TAG, "refreshAdapter: ERROR " + e);
        }

        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onResume() {
        refreshAdapter();
        Log.d(TAG, "onResume: List size " + list.size());
        super.onResume();
    }

    private void showAbout() {

        new AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("Autor: Vanja Kovacevic")
                .show();
    }

    public void showSettings() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void showStatusMessage(String message) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Actors App");
        builder.setContentText(message);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_product);
        builder.setLargeIcon(bm);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(NOTIFICATION_CHANNEL_ID);
        }

        notificationManager.notify(0, builder.build());
    }

}

