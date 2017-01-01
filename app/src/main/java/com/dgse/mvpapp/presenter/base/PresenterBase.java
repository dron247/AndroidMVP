package com.dgse.mvpapp.presenter.base;

import com.dgse.mvpapp.view.base.ViewBase;

/**
 * Basic presenter functionality, it is the same for every case
 */

public interface PresenterBase {
    void bind(ViewBase view);

    void unbind();
}
