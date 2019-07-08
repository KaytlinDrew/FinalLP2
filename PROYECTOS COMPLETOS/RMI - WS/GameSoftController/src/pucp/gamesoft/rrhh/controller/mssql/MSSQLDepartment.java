package pucp.gamesoft.rrhh.controller.mssql;
import java.util.ArrayList;
import pucp.gamesoft.rrhh.controller.dao.DAODepartment;
import pucp.gamesoft.rrhh.model.Department;

public class MSSQLDepartment implements DAODepartment{

    @Override
    public ArrayList<Department> queryAllIndependent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Department> queryAllDependent(int idDepartment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
