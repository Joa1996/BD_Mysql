
package bd_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


    
public class ConectarDB
{
    
 private String usuario;
 private String clave;
 private String url;
 private String driverClassName;
 private Connection conn = null;
 private Statement estancia;
 
public ConectarDB (String usuario, String clave, String url, String driverClassName) //constructor para  asignar paramteros y conectarse a la BD
{
this.usuario = usuario;
this.clave = clave;
this.url = url;
this.driverClassName = driverClassName;
}
public ConectarDB () 
{
 try {
 //poner los datos apropiados
 this.usuario = "root";
 this.clave = "1996";
 this.url = "jdbc:mysql://localhost/bd1";
 this.driverClassName = "com.mysql.jdbc.Driver";
 this.conectar();
 }
 catch (SQLException ex) {
 Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
 }
}
public String getClave() {
return clave;
}
public String getUrl() {
return url;
}
public String getUsuario() {
return usuario;
}
public Connection getConn() {
return conn;
}
public String getDriverClassName() {
return driverClassName;
}
public void setClave(String clave) {
this.clave = clave;
}
public void setUrl(String url) {
this.url = url;
}
public void setUsuario(String usuario) throws SQLException {
this.usuario = usuario;
}
public void setConn(Connection conn) {
this.conn = conn;
}
public void setDriverClassName(String driverClassName) {
this.driverClassName = driverClassName;
}
public void conectar() throws SQLException //
{
try {
Class.forName(this.driverClassName).newInstance();
this.conn = DriverManager.getConnection(this.url,
this.usuario, this.clave);
} catch (Exception err) {
System.out.println("Error " + err.getMessage());
}
}
public void cierraConexion() throws SQLException {
this.conn.close();
}
public ResultSet consultar(String consulta) throws SQLException//devuelve juego de resultados
{
this.estancia = (Statement) conn.createStatement();
return this.estancia.executeQuery(consulta);
}
public void actualizar(String actualiza) throws SQLException {
this.estancia = (Statement) conn.createStatement();
estancia.executeUpdate(actualiza);
}
public ResultSet borrar(String borra) throws SQLException {
Statement st = (Statement) this.conn.createStatement();
return (ResultSet) st.executeQuery(borra);
}
public int insertar(String inserta) throws SQLException {
 Statement st = (Statement) this.conn.createStatement();
 return st.executeUpdate(inserta);  
    
}
}
