package com.dgse.mvpapp.view.base;

/**
 * Concrete view interface
 * don't be lazy, it's important to make
 * concrete interface + impl class, it gives modularity and testability
 */

public interface MainView extends ViewBase {
    void setHello(String hello);
}
