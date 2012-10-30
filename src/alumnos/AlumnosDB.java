/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Vector getDatos() throws SQLException
    {
        if (!conexion.isClosed())
        {
            Vector datos = new Vector();
            String consulta = "select * from alumnos";
            resultado = comando.executeQuery(consulta);
            int tamaño = resultado.getMetaData().getColumnCount();

            // Obtener cada fila de mi resultado
            while (resultado.next())
            {
                Vector fila = new Vector();
                // Obteniendo los valores de las columnas en la fila actual
                for (int i = 1; i <= tamaño; i++)
                {
                    fila.add(resultado.getString(i));
                }
                datos.add(fila);
            }
            return datos;
        }
        return null;
    }

    public Vector getNombreColumnas() throws SQLException
    {
        Vector columnas = new Vector();
        int tamaño = resultado.getMetaData().getColumnCount();

        for (int i = 1; i <= tamaño; i++)
        {
            String columna = resultado.getMetaData().getColumnName(i);
            columnas.add(columna);
        }

        return columnas;
    }

    public void insertarFila(String nombre, String paterno, String materno) throws SQLException
    {
        String consulta = new String("insert into alumnos (matricula, nombre, paterno, materno)"
                + "values(nextval('seq_alumnos'), '%1', '%2', '%3')").replace("%1", nombre).replace("%2", paterno).replace("%3", materno);
        comando.execute(consulta);
    }
}
