/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import boundaries.AdminFacade;
import boundaries.EmployeeFacade;
import entities.Admin;
import entities.Employee;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Sadakul
 */
@ManagedBean(name = "employeeMB")
@RequestScoped
public class EmployeeManagedBean {

    @EJB
    private AdminFacade adminFacade;

    @EJB
    private EmployeeFacade employeeFacade;

    private Employee emp;
    private Admin admin;
    private String employeeType;

    public EmployeeManagedBean() {
        emp = new Employee();
        admin = new Admin();
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String addEmployee() {
        if (employeeType.equals("Admin")) {
            admin.setName(emp.getName());
            admin.setDob(emp.getDob());
            admin.setEmail(emp.getEmail());
            adminFacade.create(admin);
        }
        //employeeFacade.create(emp);
        return "index";
    }

}
