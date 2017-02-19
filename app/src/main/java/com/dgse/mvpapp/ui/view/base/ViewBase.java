package com.dgse.mvpapp.ui.view.base;

import android.content.Context;

/**
 * Most basic view functionality, MAY VARY for every project
 * always do make this root interface(even it's empty), it will save your time
 * when the project will become big
 * <p>
 * DO NOT IMPLEMENT THIS INTERFACE DIRECTLY! Always extend it with concrete interface, even it's empty
 */
public interface ViewBase {
    void setViewTitle(String title); // better to move it into ViewWithTitle interface

    Context getViewContext();
}
