/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.gamesoft.web.server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pucp.gamesoft.rrhh.controller.Controller;
import pucp.gamesoft.rrhh.model.Department;
import pucp.gamesoft.rrhh.model.Employee;

/**
 *
 * @author alulab14
 */
@WebService(serviceName = "DBControllerWeb")
public class DBControllerWeb {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllDepartmentsIndependent")
    public ArrayList<Department> queryAllDepartmentsIndependent() {
        //TODO write your implementation code here:
        
        
        return Controller.queryAllDepartmentsIndependent();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "queryAllEmployeesIndependent")
    public ArrayList<Employee> queryAllEmployeesIndependent(@WebParam(name = "idDepartment") int idDepartment) {
        //TODO write your implementation code here:
        return Controller.queryAllEmployeesIndependent(idDepartment);
    }
}
