package isfaaghyth.app.gubuk;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import isfaaghyth.app.gubuk.adapter.NoteAdapter;
import isfaaghyth.app.gubuk.data.DataRepository;
import isfaaghyth.app.gubuk.entity.Note;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lst_note)
    RecyclerView lstNote;

    // untuk menampung note secara temporary
    // yang ada di database lokal.
    private List<Note> notes = new ArrayList<>();
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fungsikan anotasi bindView
        ButterKnife.bind(this);

        //set layout manager untuk recyclerview pake grid
        lstNote.setLayoutManager(new GridLayoutManager(this, 2));

        //set adapter untuk lst_note
        adapter = new NoteAdapter(notes);
        lstNote.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNotes();
    }

    @OnClick(R.id.btn_add)
    public void onAddClicked(View view) {
        Intent noteIntent = new Intent(this, NoteActivity.class);
        startActivity(noteIntent);
    }

    private void getNotes() {
        final DataRepository repository = new DataRepository(this);
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                notes.clear();
                notes.addAll(repository.getNotes());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter.notifyDataSetChanged();
            }

        }.execute();
    }

}
