package com.assignment.business_layer.services;

import com.assignment.presentation_layer.dto.*;
import com.assignment.persistence_layer.repository.LoginRepository;
import com.assignment.persistence_layer.repository.*;
import com.assignment.business_layer.entity.Login;
import com.assignment.business_layer.factory.AbstractFactory;
import com.assignment.business_layer.factory.FactoryProvider;
import com.assignment.business_layer.report.Report;
import com.assignment.business_layer.report.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    GroceriesRepository groceriesRepository;
    @Autowired
    LoginRepository loginRepository;


    @Transactional
    public int register(LoginDto loginDto) {
        if (loginRepository.findByUsername(loginDto.getUsername()) != null)
            return -1;

        Login login = new Login();
        login.setUsername(loginDto.getUsername());
        login.setPassword(loginDto.getPassword());
        loginRepository.save(login);
        return 0;
    }

    public Integer login(LoginDto loginDto) {
        Login login = loginRepository.findByUsername(loginDto.getUsername());
        if (login != null)
            if (login.getPassword().equals(loginDto.getPassword()))
                return login.getId();
        return null;
    }

    public void logout(Integer id) {
    }

    public LoginDto findById(int id) {
        Login login = loginRepository.findById(id);
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        loginDto.setGoal(login.getGoal());
        return loginDto;
    }

    @Transactional
    public void setGoal(int id, int goal){
        Login login = loginRepository.findById(id);
        login.setGoal(goal);
        loginRepository.save(login);
    }

    @Transactional
    public StringObj generateWeeklyReport(int id){
        Login login = loginRepository.findById(id);
        AbstractFactory abstractFactory = FactoryProvider.getFactory(ReportType.WEEKLY);
        Report report =  abstractFactory.getReport(ReportType.WEEKLY);
        StringObj stringObj = new StringObj(report.computeReport(login));
        return stringObj;
    }

    @Transactional
    public StringObj generateMonthlyReport(int id){
        Login login = loginRepository.findById(id);
        AbstractFactory abstractFactory = FactoryProvider.getFactory(ReportType.MONTHLY);
        Report report =  abstractFactory.getReport(ReportType.MONTHLY);
        StringObj stringObj = new StringObj(report.computeReport(login));
        return stringObj;
    }


}
