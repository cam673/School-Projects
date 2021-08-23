package com.example.expensetracker;

import java.util.HashMap;
import java.util.List;

//hold all data a user enters throughout the app
public class UserData
{
    //collection of trackers - userID
    public static HashMap<String, List<Integer>> years = new HashMap<String, List<Integer>>();

    //finances - userID/year
    public static HashMap<String, Double> income = new HashMap<>();
    public static HashMap<String, Double> dailyExpense = new HashMap<>();
    public static HashMap<String, Double> goalSavings = new HashMap<>();
    public static HashMap<String, Double> totalSavings = new HashMap<>();

    //expenses - userID/year/month/day
    public static HashMap<String, Double> expenses = new HashMap<>();
}
