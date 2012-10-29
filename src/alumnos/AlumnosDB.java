/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author francisco
 */
public class AlumnosDB
{

    Connection conexion;
    Statement comando;
    ResultSet resultado;

    public AlumnosDB() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "xenia");
        comando = conexion.createStatement();
        resultado = null;
    }

    public Vector getData() throws SQLException
    {
        Vector< Vector> datos = new Vector<>();
        resultado = comando.executeQuery("select * from alumnos");
        int tamaño = resultado.getMetaData().getColumnCount();

        while (resultado.next())
        {
            Vector row = new Vector();
            for (int i = 1; i <= tamaño; i++)
            {
                row.add(resultado.getString(i));
            }
            datos.add(row);
        }
        return datos;
    }

    public Vector getNombreColumnas() throws SQLException
    {
        if (resultado != null)
        {
            Vector columnas = new Vector();
            int tamaño = resultado.getMetaData().getColumnCount();

            for (int i = 1; i <= tamaño; i++)
            {
                columnas.add(resultado.getMetaData().getColumnName(i));
            }
            return columnas;
        }
        return null;
    }
}
