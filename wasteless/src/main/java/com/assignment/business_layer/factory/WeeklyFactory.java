package com.assignment.business_layer.factory;

import com.assignment.business_layer.report.Report;
import com.assignment.business_layer.report.ReportType;
import com.assignment.business_layer.report.WeeklyReport;

public class WeeklyFactory extends AbstractFactory {
    @Override
    public Report getReport(ReportType reportType){
        if (reportType.equals(ReportType.WEEKLY))
            return new WeeklyReport();
        return null;
    }
}

