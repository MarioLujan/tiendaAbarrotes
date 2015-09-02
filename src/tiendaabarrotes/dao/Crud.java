package tiendaabarrotes.dao;

import java.util.List;
import tiendaabarrotes.datos.Producto;
/**
 *
 * @author Mario Lujan
 */
public interface Crud {
    public List<Producto> list();
    
    public void create(Producto producto);
    
    public void update(Producto producto);
    
    public void delete(Integer id);
}