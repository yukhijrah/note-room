package isfaaghyth.app.gubuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import isfaaghyth.app.gubuk.data.DataRepository;
import isfaaghyth.app.gubuk.entity.Note;

public class NoteActivity extends AppCompatActivity {

    @BindView(R.id.txt_title)
    EditText edtTitle;

    @BindView(R.id.txt_note)
    EditText edtNote;

    private DataRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        ButterKnife.bind(this);

        //instance data repository
        repository = new DataRepository(this);
    }

    @OnClick(R.id.btn_save)
    public void onNoteSaved(View view) {
        String title = edtTitle.getText().toString();
        String note = edtNote.getText().toString();
        String dateTime = ""; //@TODO(belum di isi)

        //instance object untuk note baru
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setNote(note);
        newNote.setDateTime(dateTime);

        //tambahkan note ke database lokal
        repository.insertNote(newNote);

        //kembali ke main activity
        onBackPressed();
    }

}
