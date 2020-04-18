package com.assignment.business_layer.factory;

import com.assignment.business_layer.report.Report;
import com.assignment.business_layer.report.ReportType;

public abstract class AbstractFactory {
    public abstract Report getReport(ReportType reportType);
}
