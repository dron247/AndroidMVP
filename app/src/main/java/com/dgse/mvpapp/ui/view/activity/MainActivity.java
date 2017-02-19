package com.dgse.mvpapp.ui.view.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dgse.mvpapp.mvpapp.R;
import com.dgse.mvpapp.ui.presenter.MainPresenterImpl;
import com.dgse.mvpapp.ui.view.base.MainView;


/**
 * Concrete view implementation
 */
public class MainActivity extends AppCompatActivity implements MainView {

    TextView textHello;
    MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl();
        textHello = (TextView) findViewById(R.id.label_hello);
        textHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pass event to presenter
                presenter.onShowMessageClicked();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.bind(this); // make presenter operational when view is ready
    }

    @Override
    protected void onStop() {
        presenter.unbind(); // disable presenter here, if activity survives
        // then the same presenter will be just used again
        super.onStop();
    }


    // this is implementation of view's concrete interface
    // all the public methods should be defined there
    // because presenters are working through interface only
    // also it's good for testing and mocking

    @Override
    public void setHello(String hello) {
        textHello.setText(hello);
    }

    //------------------------------------------------------

    // this is implementation of view's base view interface
    // all the public methods should be defined there
    // because presenters are working through interface only
    // also it's good for testing and mocking

    @Override
    public void setViewTitle(String title) {
        setTitle(title);
    }

    @Override
    public Context getViewContext() {
        return this;
    }


}
