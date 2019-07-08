/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.gamesoft.web.services;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pucp.gamesoft.rrhh.controller.dao.DAODepartment;
import pucp.gamesoft.rrhh.model.Department;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "DBControllerWS")
public class DBControllerWS {

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
    @WebMethod(operationName = "queryAllIndependent")
    public ArrayList<Department> queryAllIndependent() throws NotBoundException, MalformedURLException, RemoteException {
        //TODO write your implementation code here:
        DAODepartment daoDepartment;
        System.setProperty("java.rmi.server.hostname","192.168.1.4");
        daoDepartment=(DAODepartment)java.rmi.Naming.lookup("//192.168.1.4:1236/daoDepartment");
        return daoDepartment.queryAllIndependent();
    }
    
    
    
    
}
