package isfaaghyth.app.gubuk.data;

/**
 * Created by isfaaghyth on 09/01/19.
 * github: @isfaaghyth
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import isfaaghyth.app.gubuk.entity.Note;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM note")
    List<Note> notes();

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

}
