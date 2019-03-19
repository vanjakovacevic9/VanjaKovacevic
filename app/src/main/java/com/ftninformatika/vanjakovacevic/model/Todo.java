package com.ftninformatika.vanjakovacevic.model;

import android.app.Activity;
import android.os.Bundle;

import com.ftninformatika.vanjakovacevic.R;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Todo.TABLE_NAME)
public class Todo extends Activity {

    public static final String TABLE_NAME = "Todo";
    public static final String TODO_ID = "id";
    public static final String TODO_IME = "ime";
    public static final String OPIS =  "opis";
    public static final String PRIORITET = "prioriteti";
    public static final String DATUM_KREIRANJA = "datum kreiranja";
    public static final String VREME_KREIRANJA = "vreme kreiranja";
    public static final String DATUM_ZAVRSETKA = "datum zavrsetka";
    public static final String VREME_ZAVRSETKA = "vreme zavrsetka";
    public static final String STATUS = "status";

    @DatabaseField(columnName = TODO_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = TODO_IME)
    private String ime;

    @DatabaseField(columnName = OPIS)
    private String opis;

    @DatabaseField(columnName = PRIORITET)
    private String prioriteti;

    @DatabaseField(columnName = DATUM_KREIRANJA )
    private String datumK;

    @DatabaseField(columnName = VREME_KREIRANJA)
    private String vremeK;

    @DatabaseField(columnName = DATUM_ZAVRSETKA)
    private String datumZ;

    @DatabaseField(columnName = VREME_ZAVRSETKA)
    private String vremeZ;

    @DatabaseField(columnName = STATUS)
    private String status;

    @ForeignCollectionField(columnName = Group.TABLE_NAME)
    private ForeignCollection<Todo> todos;

    public Todo(){

    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getTodoId() {
        return TODO_ID;
    }

    public static String getTodoIme() {
        return TODO_IME;
    }

    public static String getOPIS() {
        return OPIS;
    }

    public static String getPRIORITET() {
        return PRIORITET;
    }

    public static String getDatumKreiranja() {
        return DATUM_KREIRANJA;
    }

    public static String getVremeKreiranja() {
        return VREME_KREIRANJA;
    }

    public static String getDatumZavrsetka() {
        return DATUM_ZAVRSETKA;
    }

    public static String getVremeZavrsetka() {
        return VREME_ZAVRSETKA;
    }

    public static String getSTATUS() {
        return STATUS;
    }




}
