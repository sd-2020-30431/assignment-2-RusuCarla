package com.assignment.utilities.factory;

import com.assignment.utilities.report.ReportType;

public class FactoryProvider {
    public static AbstractFactory getFactory(ReportType reportType){
        if (reportType.equals(ReportType.MONTHLY))
            return new MonthlyFactory();
        else
            return new WeeklyFactory();
    }
}
