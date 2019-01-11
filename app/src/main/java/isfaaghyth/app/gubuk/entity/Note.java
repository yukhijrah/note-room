package isfaaghyth.app.gubuk.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by isfaaghyth on 09/01/19.
 * github: @isfaaghyth
 */

@Entity(tableName = "note")
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String note;

    private String dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
