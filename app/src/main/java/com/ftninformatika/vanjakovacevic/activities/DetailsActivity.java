package com.ftninformatika.vanjakovacevic.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ftninformatika.vanjakovacevic.R;
import com.ftninformatika.vanjakovacevic.database.DataBaseHelper;
import com.ftninformatika.vanjakovacevic.model.Group;
import com.ftninformatika.vanjakovacevic.model.Todo;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends Activity {

    private EditText etNameDetails;
    private android.widget.EditText etDescriptionDetails;


    private EditText etNumber;
    private Button btnOk;
    private Button btnCancel;
    private Spinner spinner;
    private String todot;
    private List<Group> groups;
    private ListView listView;

    private Dialog dialog;

    private Group group;

    private Toolbar toolbar;
    private DataBaseHelper databaseHelper;
    private ArrayAdapter<Group> adapter;


    private static final String TAG = "DetailsGroup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle(" details");

        etNameDetails = findViewById(R.id.etName);
        listView = findViewById(R.id.listV1);
        listView = findViewById(R.id.listV2);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add);
        dialog.setCancelable(false);
    }

    public DataBaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DataBaseHelper.class);
        }
        return databaseHelper;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_details, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.menu_edit:
                editTodo();
                break;

            case R.id.menu_add:


        }

        return super.onOptionsItemSelected(item);
    }

    public void editTodo() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(android.R.layout.select_dialog_item, null);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Todo will be updated");
        alert.setView(alertLayout);
        alert.setCancelable(false);



        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                alert.show();
            }

            public void addTodo() {
                dialog.show();
                spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });
            }


        });

}
}
