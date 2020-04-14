package com.assignment.utilities.factory;

import com.assignment.utilities.report.Report;
import com.assignment.utilities.report.ReportType;
import com.assignment.utilities.report.WeeklyReport;

public class WeeklyFactory extends AbstractFactory {
    @Override
    public Report getReport(ReportType reportType){
        if (reportType.equals(ReportType.WEEKLY))
            return new WeeklyReport();
        return null;
    }
}

