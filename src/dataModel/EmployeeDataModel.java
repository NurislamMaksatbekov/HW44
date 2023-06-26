package dataModel;

import entity.Employee;

public class EmployeeDataModel {
     private Employee employee;

    public EmployeeDataModel(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
