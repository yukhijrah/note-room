package isfaaghyth.app.gubuk.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.gubuk.R;

/**
 * Created by isfaaghyth on 09/01/19.
 * github: @isfaaghyth
 */
public class NoteHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView txtTitle;

    @BindView(R.id.txt_time)
    TextView txtTime;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void setNote(String title, String time) {
        txtTitle.setText(title);
        txtTime.setText(time);
    }

}
