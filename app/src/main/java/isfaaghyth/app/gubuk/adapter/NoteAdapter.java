package isfaaghyth.app.gubuk.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import isfaaghyth.app.gubuk.R;
import isfaaghyth.app.gubuk.entity.Note;
import isfaaghyth.app.gubuk.holder.NoteHolder;

/**
 * Created by isfaaghyth on 09/01/19.
 * github: @isfaaghyth
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemNote = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        NoteHolder noteHolder = new NoteHolder(itemNote);
        noteHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return noteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        String title = notes.get(position).getTitle();
        String dateTime = notes.get(position).getDateTime();
        holder.setNote(title, dateTime);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
