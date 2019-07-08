package pucp.gamesoft.rrhh.controller.dao;
import java.util.ArrayList;
import pucp.gamesoft.rrhh.model.Department;

public interface DAODepartment extends java.rmi.Remote{
    ArrayList<Department> queryAllIndependent() throws java.rmi.RemoteException ;
    ArrayList<Department> queryAllDependent(int idDepartment)throws java.rmi.RemoteException;
}
