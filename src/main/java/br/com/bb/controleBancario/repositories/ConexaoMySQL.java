package br.com.bb.controleBancario.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

	public static Connection getConnection() {

        Connection con = null;

        try {
               con = DriverManager
            		   .getConnection( 
                 "jdbc:mysql://localhost:3306/sistema_bancario","root","root");  

        } catch (Exception e) {
               System.out.println(e);
        }
        return con;

  }

}
