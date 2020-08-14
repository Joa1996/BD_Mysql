
package bd_mysql;

import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class BD_MYSQL {

  
    public static void main(String[] args) throws SQLException 
    {  
        Scanner sc=new Scanner(System.in);
        
        ConexionMySQL c=new ConexionMySQL();
        
        System.out.println("Ingresando datos a una BD MYsql");
        System.out.println("Empezamos\n");
        System.out.println("Ingrese la Identificacion");
        int id=sc.nextInt();
        System.out.println("Ingrese el Nombre");
        String n=sc.next();
        System.out.println("Ingrese la Edad");
        int edad=sc.nextInt();
        
        System.out.println("Dese cargarlo a una BD");
        String d=sc.next();
        if(d.equalsIgnoreCase("SI"))
        {
        c.conectarBaseDeDatos();
        
        try{ 
      
      //conectamos 
   c.sentencia.execute("insert  into  persona(Id,Nombre,Edad)  values ("+id+",'"+n+"',"+edad+")"); //En este caso a diferencia de la consulta con Acces, la comilla simple ' solo va cuando el dato es del tipo String
      //insertamos los datos       
    }catch (Exception e){} 
        
        }
        c.desconectarBaseDeDatos();
        
//     Usando la otra clase "ConectarDB"   
//        ConectarDB cdb=new ConectarDB();
//        cdb.conectar();
//        cdb.insertar("insert  into  persona(nombre,edad)  values ("+555+",'"+555+"')");
      
        
    
    } 
        
        
        
    }
    

