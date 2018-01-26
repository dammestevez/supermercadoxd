/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hib;

import java.util.List;
import javax.persistence.*;
import org.hibernate.HibernateException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



/**
 *
 * @author Marc
 */
public class Hib {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Scanner sc = new Scanner(System.in);
       Connection c = null;
       String sql;
       Statement stmt = null;
       int opcio=1;

        
       Class.forName("org.postgresql.Driver");
       c = DriverManager
               .getConnection("jdbc:postgresql://192.168.173.151:5432/consulta_stock",
                       "postgres", "postgres");
       c.setAutoCommit(false);
        
       while(opcio!=6){
                System.out.println("Selecciona la accio que vols fer: ");
                System.out.println("1. Consulta Stock Individual");
                System.out.println("2. Consulta Stock Global");
                System.out.println("3. Afegir Productes");
                System.out.println("4. Retirar Producte");
                System.out.println("5. Mostrar informacio de un producte");
                System.out.println("6. Sortir");

                opcio=sc.nextInt();

                switch (opcio){
                    case 1:

                        System.out.println("Introdueix un 1 si es un producte a granel o un 2 si te envàs: ");
                        
                        String opcio2=sc.next();
                        
                        if(opcio2.equals("1")){
                            dni=sc.next();
                            nom=sc.next();
                            dataNaix=sc.next();
                            adreça=sc.next();
                            telf=sc.next();
                        }else if(opcio2.equals("2")){
                            dni=sc.next();
                            nom=sc.next();
                            dataNaix=sc.next();
                            adreça=sc.next();
                            telf=sc.next();
                        }
                        
                         

                        stmt = c.createStatement();
                        sql = "INSERT INTO Cens (dni,nom,data_naixement,adreça,telefon) "
                                + "VALUES ('"+dni+"', '"+nom+"', '"+dataNaix+"', '"+adreça+"', "+telf+" );";
                        stmt.executeUpdate(sql);

                        stmt.close();

                        System.out.println("Alta feta");

                        c.commit();
                        break;
                    case 2:

                        System.out.println("Escriu el dni que vols donar de baixa: ");
                        dni=sc.next();
                        stmt = c.createStatement();
                        sql = "DELETE from cens where dni = '"+dni+"';";
                        stmt.executeUpdate(sql);

                        c.commit();

                        System.out.println("Baixa feta");

                        break;
                    case 3:

                        System.out.println("Introdueix les dades separades per un insert: ");
                         dni=sc.next();
                         nom=sc.next();
                         dataNaix=sc.next();
                         adreça=sc.next();
                         telf=sc.next();

                        stmt = c.createStatement();
                        sql = "UPDATE cens set nom = '"+nom+"', data_naixement = '"+dataNaix+"', adreça= '"+adreça+"', telefon="+telf+" where dni='"+dni+"' ;";
                        stmt.executeUpdate(sql);

                        c.commit();

                        System.out.println("Modificacio feta");

                        break;
                    case 4:

                        System.out.println("Escriu el dni que vols consultar: ");
                        dni=sc.next();

                        stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT * FROM cens where dni='"+dni+"';" );
                        while ( rs.next() ) {

                            dni = rs.getString("dni");
                            nom = rs.getString("nom");
                            dataNaix = rs.getString("data_naixement");
                            adreça = rs.getString("adreça");
                            telf = rs.getString("telefon");

                            System.out.println( "Dni = " + dni );
                            System.out.println( "Nom = " + nom );
                            System.out.println( "Data Naix = " + dataNaix );
                            System.out.println( "Adreça = " + adreça );
                            System.out.println( "Telefon = " + telf );
                            System.out.println();


                        }

                        rs.close();
                        stmt.close();

                        break;
                    case 5:

                        System.out.println("Escriu el dni que vols consultar: ");
                        dni=sc.next();

                        stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT * FROM cens where dni='"+dni+"';" );
                        while ( rs.next() ) {

                            dni = rs.getString("dni");
                            nom = rs.getString("nom");
                            dataNaix = rs.getString("data_naixement");
                            adreça = rs.getString("adreça");
                            telf = rs.getString("telefon");

                            System.out.println( "Dni = " + dni );
                            System.out.println( "Nom = " + nom );
                            System.out.println( "Data Naix = " + dataNaix );
                            System.out.println( "Adreça = " + adreça );
                            System.out.println( "Telefon = " + telf );
                            System.out.println();


                        }

                        rs.close();
                        stmt.close();

                        break;
                        
                    default : break;
                        

                }

            }
            c.close();
       
    }
    
}
@Entity
@Table(name = "Test")
class test{
    @Column(name = "Col1")
    String Col1;
    @Column(name = "Col2")
    String Col2;
}
