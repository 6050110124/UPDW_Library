package com.solutbit.updwandroidlibrary.ui.mp_android_chart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.solutbit.updwandroidlibrary.R;

import java.util.ArrayList;

public class MPAndroidChartFragment extends Fragment {

    private MPAndroidChartViewModel mpAndroidChartViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mpAndroidChartViewModel =
                ViewModelProviders.of(this).get(MPAndroidChartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mp_android_chart, container, false);

        // Content
// Bar Chart
        ArrayList<BarEntry> incomes = new ArrayList<>();

        incomes.add(new BarEntry(100f, 0));
        incomes.add(new BarEntry(120f, 1));
        incomes.add(new BarEntry(200f, 2));
        incomes.add(new BarEntry(250f, 3));
        incomes.add(new BarEntry(270f, 4));
        incomes.add(new BarEntry(340f, 5));
        incomes.add(new BarEntry(380f, 6));
        incomes.add(new BarEntry(450f, 7));

        ArrayList<String> years = new ArrayList<String>();

        years.add("2011");
        years.add("2012");
        years.add("2013");
        years.add("2014");
        years.add("2015");
        years.add("2016");
        years.add("2017");
        years.add("2018");

        BarChart barChart = root.findViewById(R.id.barChart);

        BarDataSet barDataSet = new BarDataSet(incomes, "Income");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(years, barDataSet);

        barChart.setDescription("This is example of Bar Chart");
        barChart.animateY(2000);
        barChart.setData(data);
        // End Bar Chart

        // Pie Chart
        PieChart pieChart = root.findViewById(R.id.pieChart);

        ArrayList transportation = new ArrayList();
        transportation.add(new Entry(54f, 0));
        transportation.add(new Entry(20f, 1));
        transportation.add(new Entry(14f, 2));
        transportation.add(new Entry(12f, 3));
        PieDataSet pieDataSet = new PieDataSet(transportation, "Transportation");

        ArrayList names = new ArrayList();
        names.add("Bus");
        names.add("Motorcycle");
        names.add("Car");
        names.add("Walk");

        PieData pieData = new PieData(names, pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setDescription("This is example of Pie Chart");
        pieChart.animateXY(2500, 2500);
        // End Pie Chart
        // End Content

        return root;
    }
}