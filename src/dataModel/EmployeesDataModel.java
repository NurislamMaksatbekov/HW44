package dataModel;

import entity.Employee;
import util.FileService;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDataModel {

    private final List<Employee> employee = new ArrayList<>();

    public EmployeesDataModel() {
        employee.addAll(FileService.readEmployees());
    }

    public List<Employee> getEmployee() {
        return employee;
    }
}
