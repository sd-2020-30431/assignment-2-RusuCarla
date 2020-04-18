package com.assignment.business_layer.factory;

import com.assignment.business_layer.report.ReportType;

public class FactoryProvider {
    public static AbstractFactory getFactory(ReportType reportType){
        if (reportType.equals(ReportType.MONTHLY))
            return new MonthlyFactory();
        else
            return new WeeklyFactory();
    }
}
