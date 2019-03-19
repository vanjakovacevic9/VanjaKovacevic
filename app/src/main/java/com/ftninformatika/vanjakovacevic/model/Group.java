package com.ftninformatika.vanjakovacevic.model;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ftninformatika.vanjakovacevic.R;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Group.TABLE_NAME)
public class Group extends Activity {

    public static final String TABLE_NAME = "Group";
    public static final String GROUP_ID = "id";
    public static final String GROUP_IME = "ime";
    public static final String DATUM =  "datum";
    public static final String VREME = "vreme";
    public static final String STATUS = "status";


    @DatabaseField(columnName = GROUP_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = GROUP_IME)
    private String ime;

    @DatabaseField(columnName =DATUM)
    private String Datum;

    @DatabaseField(columnName = VREME)
    private String vreme;

    @DatabaseField(columnName = STATUS)
    private String status;

    @ForeignCollectionField(columnName = Group.TABLE_NAME)
    private ForeignCollection<Todo> todos;

    public Group(){

    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
