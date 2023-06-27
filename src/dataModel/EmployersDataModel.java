package dataModel;

import entity.Employee;
import util.FileService;

import java.util.ArrayList;
import java.util.List;

public class EmployersDataModel {

    private final List<Employee> employee = new ArrayList<>();

    public EmployersDataModel() {
        employee.addAll(FileService.readEmployees());
    }

    public List<Employee> getEmployee() {
        return employee;
    }
}
