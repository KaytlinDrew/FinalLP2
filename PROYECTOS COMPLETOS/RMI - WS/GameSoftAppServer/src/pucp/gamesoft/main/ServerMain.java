package pucp.gamesoft.main;

import java.rmi.registry.LocateRegistry;
import pucp.gamesoft.rrhh.controller.dao.DAODepartment;
import pucp.gamesoft.rrhh.controller.dao.DAOEmployee;
import pucp.gamesoft.rrhh.controller.mysql.MySQLDepartment;
import pucp.gamesoft.rrhh.controller.mysql.MySQLEmployee;

public class ServerMain {
    public static void main(String[] args){
        try{
           System.setProperty("java.rmi."
                   + "server.hostname","192.168.1.4"); //IPServer
            LocateRegistry.createRegistry(1236); 
            DAOEmployee daoEmployee = new MySQLEmployee();
            DAODepartment daoDepartment = new MySQLDepartment();
            java.rmi.Naming.rebind("//192.168.1.4:1236/daoEmployee", daoEmployee);
            java.rmi.Naming.rebind("//192.168.1.4:1236/daoDepartment", daoDepartment);
            System.out.println("Se ha levantado el servidor...");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
