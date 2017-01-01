package com.dgse.mvpapp.model;

import java.util.Date;
import java.util.Random;

/**
 * Just some generic data class
 */

public class ExampleModel {

    Random rnd = new Random();

    public String getName() {
        return new Date().toString();
    }

    public String getData() {
        return String.valueOf(rnd.nextInt(50) + 1);
    }
}
