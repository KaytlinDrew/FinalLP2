package pucp.gamesoft.rrhh.controller.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pucp.gamesoft.rrhh.controller.config.DBManager;
import pucp.gamesoft.rrhh.controller.dao.DAOEmployee;
import pucp.gamesoft.rrhh.model.Employee;
import pucp.gamesoft.rrhh.model.Role;

public class MySQLEmployee extends java.rmi.server.UnicastRemoteObject implements DAOEmployee{

    private Connection con;
    public MySQLEmployee() throws java.rmi.RemoteException{}
    
    @Override
    public ArrayList<Employee> queryAllIndependent(int idDepartment) throws java.rmi.RemoteException {
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            con = DriverManager.getConnection(DBManager.getDBManager().getUrl(), DBManager.getDBManager().getUser(), DBManager.getDBManager().getPassword());
            CallableStatement cs = con.prepareCall("{call LIST_EMPLOYEES_INDEPENDENT(?)}");
            cs.setInt("_ID_DEPARTMENT", idDepartment);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID_EMPLOYEE"));
                employee.setRole(new Role());
                employee.getRole().setName(rs.getString("ROLE_NAME"));
                employee.setName(rs.getString("NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
                employee.setSecondLastName(rs.getString("SECOND_LAST_NAME"));
                employee.setDNI(rs.getString("DNI"));
                employee.setEmail(rs.getString("EMAIL"));
                employee.setBirthday(rs.getDate("BIRTHDAY"));
                employee.setSalary(rs.getDouble("SALARY"));
                employees.add(employee);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}}
        }
        return employees;
    }

    @Override
    public ArrayList<Employee> queryAllDependent(int idEmployee) throws java.rmi.RemoteException{
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            con = DriverManager.getConnection(DBManager.getDBManager().getUrl(), DBManager.getDBManager().getUser(), DBManager.getDBManager().getPassword());
            CallableStatement cs = con.prepareCall("{call LIST_EMPLOYEES_DEPENDENT(?)}");
            cs.setInt("_ID_EMPLOYEE", idEmployee);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID_EMPLOYEE"));
                employee.setRole(new Role());
                employee.getRole().setName(rs.getString("ROLE_NAME"));
                employee.setName(rs.getString("NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
                employee.setSecondLastName(rs.getString("SECOND_LAST_NAME"));
                employee.setDNI(rs.getString("DNI"));
                employee.setEmail(rs.getString("EMAIL"));
                employee.setBirthday(rs.getDate("BIRTHDAY"));
                employee.setSalary(rs.getDouble("SALARY"));
                employees.add(employee);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}}
        }
        return employees;
    }

    @Override
    public Employee queryById(int idEmployee) throws java.rmi.RemoteException {
        Employee employee = new Employee();
        try{
            con = DriverManager.getConnection(DBManager.getDBManager().getUrl(), DBManager.getDBManager().getUser(), DBManager.getDBManager().getPassword());
            CallableStatement cs = con.prepareCall("{call LIST_EMPLOYEE_BY_ID(?)}");
            cs.setInt("_ID_EMPLOYEE", idEmployee);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                employee.setId(rs.getInt("ID_EMPLOYEE"));
                employee.setRole(new Role());
                employee.getRole().setName(rs.getString("ROLE_NAME"));
                employee.setName(rs.getString("NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
                employee.setSecondLastName(rs.getString("SECOND_LAST_NAME"));
                employee.setDNI(rs.getString("DNI"));
                employee.setEmail(rs.getString("EMAIL"));
                employee.setBirthday(rs.getDate("BIRTHDAY"));
                employee.setSalary(rs.getDouble("SALARY"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}}
        }
        return employee;
    }
    
}
