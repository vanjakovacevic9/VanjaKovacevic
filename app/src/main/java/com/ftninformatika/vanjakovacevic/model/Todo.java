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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPrioriteti() {
        return prioriteti;
    }

    public void setPrioriteti(String prioriteti) {
        this.prioriteti = prioriteti;
    }

    public String getDatumK() {
        return datumK;
    }

    public void setDatumK(String datumK) {
        this.datumK = datumK;
    }

    public String getVremeK() {
        return vremeK;
    }

    public void setVremeK(String vremeK) {
        this.vremeK = vremeK;
    }

    public String getDatumZ() {
        return datumZ;
    }

    public void setDatumZ(String datumZ) {
        this.datumZ = datumZ;
    }

    public String getVremeZ() {
        return vremeZ;
    }

    public void setVremeZ(String vremeZ) {
        this.vremeZ = vremeZ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ForeignCollection<Todo> getTodos() {
        return todos;
    }

    public void setTodos(ForeignCollection<Todo> todos) {
        this.todos = todos;
    }
}
