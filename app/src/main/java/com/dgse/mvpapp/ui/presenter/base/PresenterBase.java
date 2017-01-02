package com.dgse.mvpapp.ui.presenter.base;

import com.dgse.mvpapp.ui.view.base.ViewBase;

/**
 * Basic presenter functionality, it is the same for every case
 * <p>
 * Note: interface has package local access, it's done with purpose!
 * You should always make new interface, even if it's empty and just extends this one
 */

interface PresenterBase {
    void bind(ViewBase view);

    void unbind();
}
