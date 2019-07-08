package pucp.gamesoft.rrhh.controller.mssql;
import java.util.ArrayList;
import pucp.gamesoft.rrhh.controller.dao.DAOEmployee;
import pucp.gamesoft.rrhh.model.Employee;

public class MSSQLEmployee implements DAOEmployee{

    @Override
    public ArrayList<Employee> queryAllIndependent(int idDeparment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Employee> queryAllDependent(int idEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee queryById(int idEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
