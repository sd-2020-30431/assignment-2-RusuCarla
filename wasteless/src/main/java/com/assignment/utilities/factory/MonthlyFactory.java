package com.assignment.utilities.factory;

import com.assignment.utilities.report.MonthlyReport;
import com.assignment.utilities.report.Report;
import com.assignment.utilities.report.ReportType;

public class MonthlyFactory extends AbstractFactory {
    @Override
    public Report getReport(ReportType reportType){
        if (reportType.equals(ReportType.MONTHLY))
            return new MonthlyReport();
        return null;
    }
}
