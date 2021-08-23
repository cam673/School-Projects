package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

//generate a bar chart for the user
public class ChartDisplay extends AppCompatActivity
{
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList<BarEntry> barEntries;
    ArrayList<String> theDates;
    ArrayList<String> days;
    float [] expense;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_display);

        barChart = (BarChart) findViewById(R.id.expenseChart);

        Intent intent = getIntent();
        days = intent.getStringArrayListExtra("days");
        expense = intent.getFloatArrayExtra("expense");
        size = days.size();

        SetData();
        SetDates();

        barDataSet = new BarDataSet(barEntries, "Expenses");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(12f);

        Description description = new Description();
        description.setText("Days");
        barChart.setDescription(description);
        barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(theDates));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(theDates.size());
        //xAxis.setLabelRotationAngle(270);

        barChart.animateY(2000);
        barChart.invalidate();
    }

    //initialize data entries based on expenses
    private void SetData()
    {
        barEntries = new ArrayList<>();
        float entry;
        for(int i = 0; i < size; i++)
        {
            entry = expense[i];
            barEntries.add(new BarEntry(i, entry));
        }
        /*barEntries.add(new BarEntry(0, 21));
        barEntries.add(new BarEntry(1, 33));
        barEntries.add(new BarEntry(2, 75));
        barEntries.add(new BarEntry(3, 42));
        barEntries.add(new BarEntry(4, 66));
        barEntries.add(new BarEntry(5, 12));
        barEntries.add(new BarEntry(6, 30));*/
    }

    //initialize XAxis values based on the day the expense was created
    private void SetDates()
    {
        theDates = new ArrayList<>();
        String entry;
        for(int i = 0; i < size; i++)
        {
            entry = days.get(i);
            theDates.add(entry);
        }
        /*theDates.add("1");
        theDates.add("3");
        theDates.add("7");
        theDates.add("9");
        theDates.add("14");
        theDates.add("19");
        theDates.add("20");*/
    }

    //go back menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.go_back, menu);
        return true;
    }

    //go back to ChartSelect menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.back_btn:
                intent = new Intent(getApplicationContext(), ChartSelect.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
