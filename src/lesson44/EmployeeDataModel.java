package lesson44;

import entity.Employee;
import util.FileService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataModel {
    private final List<Employee> employee = new ArrayList<>();

    public EmployeeDataModel() {
        employee.addAll(FileService.readEmployers());
    }

    public List<Employee> getEmployee() {
        return employee;
    }
}
