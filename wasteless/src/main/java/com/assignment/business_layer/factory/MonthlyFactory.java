package com.assignment.business_layer.factory;

import com.assignment.business_layer.report.MonthlyReport;
import com.assignment.business_layer.report.Report;
import com.assignment.business_layer.report.ReportType;

public class MonthlyFactory extends AbstractFactory {
    @Override
    public Report getReport(ReportType reportType){
        if (reportType.equals(ReportType.MONTHLY))
            return new MonthlyReport();
        return null;
    }
}
