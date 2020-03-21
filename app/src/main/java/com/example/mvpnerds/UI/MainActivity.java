package com.example.mvpnerds.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpnerds.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MovieView {

    MoviePresenter presenter;
    @BindView(R.id.textView)
    TextView movieNameTV;
    @BindView(R.id.button)
    Button getMovieBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        getMovieBTN.setOnClickListener(this);

        presenter = new MoviePresenter(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            presenter.getMovieName();
        }
    }

    @Override
    public void onGetMovieName(String movieName) {
        movieNameTV.setText(movieName);

    }
}
