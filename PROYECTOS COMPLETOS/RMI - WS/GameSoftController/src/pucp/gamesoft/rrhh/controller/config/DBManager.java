package pucp.gamesoft.rrhh.controller.config;
 
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DBManager{
    private final String strMySQLDriverClass = "com.mysql.cj.jdbc.Driver";
    private final String strSQLServerDriverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final DBManager dbManager = new DBManager();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String url;
    private String user;
    private String password;
    
    public DBManager(){
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        FileReader reader;
        try{
            reader = new FileReader("src/pucp/gamesoft/config/config.xml");
            ConnectionParameters connParam =
            (ConnectionParameters) xstream.fromXML(reader);
            url = connParam.getUrl();
            password = connParam.getPassword();
            user = connParam.getUser();
            if(url.contains("mysql")){
                Class.forName(strMySQLDriverClass);
            }else{
                Class.forName(strSQLServerDriverClass);
            }
            System.out.println("Se ha registrado el Driver");
        }catch(FileNotFoundException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static DBManager getDBManager() {
	return dbManager;
    }	
}