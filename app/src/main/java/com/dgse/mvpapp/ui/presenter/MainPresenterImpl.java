package com.dgse.mvpapp.ui.presenter;

import android.content.Context;

import com.dgse.mvpapp.model.ExampleModel;
import com.dgse.mvpapp.ui.presenter.base.MainPresenter;
import com.dgse.mvpapp.ui.view.base.MainView;
import com.dgse.mvpapp.ui.view.base.ViewBase;

/**
 * Example Presenter implementation
 * There is no Interactor here
 * Direct call of model is for better readability
 */

public class MainPresenterImpl implements MainPresenter {

    private Context context;

    private MainView mainView;
    private boolean isAdded = false;

    private ExampleModel model; // Should be replaced with GetSomeDataInteractor

    /**
     * All the public functionality has to be defined in
     * presenter's concrete interface first (testing & mocks)
     */
    @Override
    public void onShowMessageClicked() {
        if (isAdded) {
            mainView.setViewTitle(model.getName());
            mainView.setHello(model.getData());
        }
    }

    /**
     * Most basic functionality of a presenter.
     * It should somehow to be bound with it's view
     *
     * @param view view to operate over
     */
    @Override
    public <T extends ViewBase> void bind(T view) {
        mainView = (MainView) view; // prepare view interface
        context = view.getViewContext();
        isAdded = true; // allow presenter to operate

        model = new ExampleModel(); // you should request cached data here and renew it maybe
    }

    /**
     * Most basic functionality. Allows to cleanup.
     */
    @Override
    public void unbind() {
        isAdded = false; // flag that the presenter is not operational, optional. you can just check view == null
        context = null;
        mainView = null; // release that link, allow GC to bury
        // old screen (if view is going to be disposed)

        model = null; // place the cleanup code here
        // if you are reading something from the server, consider to move the data cache logic into an Interactor
        // new presenter will just read an available data from the cache, subscribe it to the cache updates. if needed
    }
}
