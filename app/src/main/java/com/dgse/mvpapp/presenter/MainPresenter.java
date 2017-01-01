package com.dgse.mvpapp.presenter;

import com.dgse.mvpapp.presenter.base.PresenterBase;

/**
 * Concrete presenter interface
 * don't be lazy, it's important to make
 * concrete interface + impl class, it gives modularity and testability
 */

public interface MainPresenter extends PresenterBase {
    void onShowMessageClicked();
}
