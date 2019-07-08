package pucp.gamesoft.rrhh.controller.dao;
import java.util.ArrayList;
import pucp.gamesoft.rrhh.model.Employee;
public interface DAOEmployee extends java.rmi.Remote{
    ArrayList<Employee> queryAllIndependent(int idDepartment) throws java.rmi.RemoteException;
    ArrayList<Employee> queryAllDependent(int idEmployee) throws java.rmi.RemoteException;
    Employee queryById(int idEmployee) throws java.rmi.RemoteException;
}