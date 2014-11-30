/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import boundaries.EmployeeFacade;
import entities.Employee;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Sadakul
 */
@ManagedBean(name="employeeMB")
@RequestScoped
public class EmployeeManagedBean {
    
    @EJB
    private EmployeeFacade employeeFacade;
    
    private Employee emp;


    public EmployeeManagedBean() {
        emp = new Employee();
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    
    public String addEmployee(){
        employeeFacade.create(emp);
        return "index";
    }
    
    
    
}
