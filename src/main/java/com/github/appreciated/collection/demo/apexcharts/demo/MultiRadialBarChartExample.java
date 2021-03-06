package com.github.appreciated.collection.demo.apexcharts.demo;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.vaadin.flow.component.html.Div;

public class MultiRadialBarChartExample extends Div {
    public MultiRadialBarChartExample() {
        ApexCharts multiRadialBarChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.radialBar)
                        .build())
                .withSeries(44.0, 55.0, 67.0, 83.0)
                .withLabels("Apples", "Oranges", "Bananas", "Berries")
                .build();
        add(multiRadialBarChart);
        setWidth("100%");
    }
}
