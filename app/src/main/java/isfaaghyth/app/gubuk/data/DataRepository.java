package isfaaghyth.app.gubuk.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import isfaaghyth.app.gubuk.entity.Note;

/**
 * Created by isfaaghyth on 09/01/19.
 * github: @isfaaghyth
 */
public class DataRepository {

    private final static String DB_NAME = "note";
    private DataManager dataManager;

    /**
     * Constructor
     * @param context
     */
    public DataRepository(Context context) {
        dataManager = Room.databaseBuilder(
                context,
                DataManager.class,
                DB_NAME
        ).build();
    }

    public void insertNote(final Note note) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                dataManager.noteDao().insert(note);
                return null;
            }

        }.execute();
    }

    public void deleteNote(final Note note) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                dataManager.noteDao().delete(note);
                return null;
            }

        }.execute();
    }

    public List<Note> getNotes() {
        return dataManager.noteDao().notes();
    }

}
