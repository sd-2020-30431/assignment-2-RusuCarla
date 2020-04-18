package com.assignment.business_layer.report;

import com.assignment.business_layer.entity.Login;

public interface Report {
    String computeReport(Login login);
}
