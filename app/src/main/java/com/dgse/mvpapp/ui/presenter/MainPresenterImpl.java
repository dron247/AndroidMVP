package com.dgse.mvpapp.ui.presenter;

import com.dgse.mvpapp.model.ExampleModel;
import com.dgse.mvpapp.ui.presenter.base.MainPresenter;
import com.dgse.mvpapp.ui.view.base.MainView;
import com.dgse.mvpapp.ui.view.base.ViewBase;

/**
 * Example Presenter implementation
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private boolean isAdded = false;

    private ExampleModel model;

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
    public void bind(ViewBase view) {
        mainView = (MainView) view; // prepare view interface
        isAdded = true; // allow presenter to operate

        model = new ExampleModel(); // you should request cached data here and renew it maybe
    }

    /**
     * Most basic functionality. Allows to cleanup.
     */
    @Override
    public void unbind() {
        isAdded = false; // flag that the presenter is not operational
        mainView = null; // release that link, allow GC to bury
                         // old screen (if view is going to be disposed)

        model = null; // place cleanup code here
    }
}
