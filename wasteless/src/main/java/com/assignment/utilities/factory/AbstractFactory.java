package com.assignment.utilities.factory;

import com.assignment.utilities.report.Report;
import com.assignment.utilities.report.ReportType;

public abstract class AbstractFactory {
    public abstract Report getReport(ReportType reportType);
}
