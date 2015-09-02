package tiendaabarrotes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tiendaabarrotes.datos.Producto;
/**
 *
 * @author Mario Lujan
 */
public class ProductosDao implements Crud{

    @Override
    public List<Producto> list() {
        List<Producto> productos = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getConexion()
                    .createStatement();
            System.out.println(Producto.fieldsToString());
            ResultSet rs = st.executeQuery(String
                    .format("SELECT %s FROM %s", 
                            Producto.fieldsToString(), Producto.TABLA));
            while(rs.next()){
                Integer idprod = rs.getInt(Producto.FIELDS[0]);
                String descripcion = rs.getString(Producto.FIELDS[1]);
                Double precio = Double.parseDouble(rs
                        .getString(Producto.FIELDS[2]));
                String clasificacion = rs.getString(Producto.FIELDS[3]);
                Integer cantidad = rs.getInt(Producto.FIELDS[4]);
                Integer existmin = rs.getInt(Producto.FIELDS[5]);
                Integer existmax = rs.getInt(Producto.FIELDS[6]);
                Producto prd = new Producto(idprod, descripcion, precio,
                        clasificacion, cantidad, existmin, existmax);
                productos.add(prd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    @Override
    public void create(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
