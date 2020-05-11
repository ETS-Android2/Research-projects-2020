package com.example.androidfirebasetutorial.repository;

import com.example.androidfirebasetutorial.models.UserModel;

import java.util.Random;

/**
 * Created by rafael on 01/12/16.
 */

public class UserFactory {

    private static String[] names = {"John", "Will", "Frank", "Robert", "Annie", "Rebecca", "Sol", "Alex", "Conner", "Sabrina", "Fred"};
    private static String[] cities = {"CC", "VBP", "SDM", "Ethics", "Spanish", "BDS"};
    private static String[] desc = {"\"Very Good \"",
            "\"Fair\"", "\"Okay\"", "\"Good\"", "\"Excellent\"", "\"Spectacular\"", "\"Bad\"", "\"Very Bad\""};

    public static UserModel makeUser() {
        return new UserModel(names[getRandomValue(0, 10)],
                cities[getRandomValue(0, 5)],
                desc[getRandomValue(0, 2)],
                getRandomValue(0, 100));
    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
}