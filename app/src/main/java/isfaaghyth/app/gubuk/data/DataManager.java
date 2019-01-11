package isfaaghyth.app.gubuk.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import isfaaghyth.app.gubuk.entity.Note;

/**
 * Created by isfaaghyth on 09/01/19.
 * github: @isfaaghyth
 */
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class DataManager extends RoomDatabase {

    public abstract NoteDao noteDao();

}
