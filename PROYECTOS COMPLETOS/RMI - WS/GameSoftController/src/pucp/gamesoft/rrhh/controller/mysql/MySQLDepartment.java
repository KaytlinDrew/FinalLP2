package pucp.gamesoft.rrhh.controller.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pucp.gamesoft.rrhh.controller.config.DBManager;
import pucp.gamesoft.rrhh.controller.dao.DAODepartment;
import pucp.gamesoft.rrhh.model.Department;
public class MySQLDepartment extends java.rmi.server.UnicastRemoteObject implements DAODepartment{

    private Connection con;
    public MySQLDepartment() throws java.rmi.RemoteException{}
    @Override
    public ArrayList<Department> queryAllIndependent() throws java.rmi.RemoteException{
        ArrayList<Department> departments = new ArrayList<>();
        try{
            con = DriverManager.getConnection(DBManager.getDBManager().getUrl(), DBManager.getDBManager().getUser(), DBManager.getDBManager().getPassword());
            CallableStatement cs = con.prepareCall("{call LIST_DEPARTMENTS()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setHeadDepartment(new Department());
                department.setId(rs.getInt("ID_DEPARTMENT"));
                department.setName(rs.getString("NAME"));
                departments.add(department);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}}
        }
        return departments;
    }

    @Override
    public ArrayList<Department> queryAllDependent(int idDepartment) throws java.rmi.RemoteException {
        ArrayList<Department> departments = new ArrayList<>();
        try{
            con = DriverManager.getConnection(DBManager.getDBManager().getUrl(), DBManager.getDBManager().getUser(), DBManager.getDBManager().getPassword());
            CallableStatement cs = con.prepareCall("{call LIST_DEPARTMENTS_DEPENDENT(?)}");
            cs.setInt("_ID_DEPARTMENT", idDepartment);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setHeadDepartment(new Department());
                department.setId(rs.getInt("ID_DEPARTMENT"));
                department.setName(rs.getString("NAME"));
                departments.add(department);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}}
        }
        return departments;
    }
    
}
