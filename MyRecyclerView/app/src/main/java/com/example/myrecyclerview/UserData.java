package com.example.myrecyclerview;

import java.util.ArrayList;

public class UserData {

    private static String[] uName = {
            "Phil Foden",
            "Cristiano Ronaldo",
            "Taufik Hidayat",
            "Yuzuru Hanyu",
            "Neymar",
            "Maria Sharapova"
    };

    private static String[] userName = {
            "philfoden",
            "cristiano",
            "taufikhidayatofficial",
            "yuzu_yuzuru",
            "neymarjr",
            "mariasharapova"
    };
    private static String[] uLocation = {
            "England",
            "Portugal",
            "Indonesia",
            "Japan",
            "Brazil",
            "Russia"
    };
    private static String[] uMedals = {
            "100",
            "150",
            "200",
            "150",
            "100",
            "100"
    };
    private static String[] uSports = {
            "Footballer",
            "Footballer",
            "Former Badminton Player",
            "Japanese Figure Skater",
            "Footballer",
            "Tennis Player"
    };
    private static String[] uFollowers = {
            "1.7M",
            "279M",
            "235K",
            "114K",
            "149M",
            "4.1M"
    };
    private static String[] uFollowing = {
            "392",
            "468",
            "423",
            "56",
            "1.488",
            "641"
    };
    private static int[] userPhoto = {
            R.drawable.foden,
            R.drawable.ronaldo,
            R.drawable.taufik,
            R.drawable.yuzuru,
            R.drawable.neymar,
            R.drawable.maria
    };

    static ArrayList<User> getListData() {
        ArrayList<User> list = new ArrayList<>();

        for (int position = 0; position < uName.length; position++) {
            User user = new User();
            user.setPhoto(userPhoto[position]);
            user.setName(uName[position]);
            user.setUserName(userName[position]);
            user.setLocation(uLocation[position]);
            user.setCompany(uSports[position]);
            user.setRepository(uMedals[position]);
            user.setFollowers(uFollowers[position]);
            user.setFollowing(uFollowing[position]);
            list.add(user);
        }
        return list;
    }
}
