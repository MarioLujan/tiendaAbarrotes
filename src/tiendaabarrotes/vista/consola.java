package tiendaabarrotes.vista;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import tiendaabarrotes.dao.ProductosDao;
import tiendaabarrotes.datos.Producto;

/**
 *
 * @author Mario Lujan
 */
public class consola {

    public static void main(String[] args) {
        List<Producto> p = new ProductosDao().list();

        ///////////////////
        long r1 = p.stream()
                .filter(a -> {
                    return a.getCantidad() > 20;
                })
                .count();
        System.out.println(String
                .format("\n Cantidad de productos con existencia mayor a 20: %d",
                        r1));

        ///////////////////
        long r2 = p.stream()
                .filter(a -> {
                    return a.getCantidad() < 15;
                })
                .count();
        System.out.println(String
                .format("\n Cantidad de productos con existencia menor a 15: %d",
                        r2));

        ///////////////////
        System.out.println("\n Productos con la misma clasificación"
                + " y precio mayor 15.50:");
        p.stream()
                .filter(a -> {return a.getPrecio() > 15.5;})
                .sorted((a, b) -> a.getClasificacion()
                        .compareTo(b.getClasificacion()))
                .forEach(a -> {System.out.println(a.cadena());;});

        ///////////////////
        System.out.println("\n Productos con precio "
                + "mayor a 20.30 y menor a 45.00:");
        p.stream()
                .filter(a -> {return a.getPrecio() > 20.30 && a.getPrecio()< 45;})
                .forEach(a -> {System.out.println(a.cadena());});

        ///////////////////        
        Map<String, Long> counted = p.stream()
            .collect(Collectors.groupingBy(o -> o.getClasificacion(), Collectors.counting()));
        System.out.println("\n Productos agrupados"
                + " por su clasificación: ");
        System.out.println(counted);
    }

}
