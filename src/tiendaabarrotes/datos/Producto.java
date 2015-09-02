package tiendaabarrotes.datos;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mario Lujan
 */
public class Producto {
    
    public static final String TABLA = "productos";
    public static final String[] FIELDS = {"idprod", "descripcion",
        "precio", "clasificacion", "cantidad", "existmin", "existmax"};

    private Integer idprod;
    private String descripcion;
    private Double precio;
    private String clasificacion;
    private Integer cantidad;
    private Integer existmin;
    private Integer existmax;

    public Producto(Integer idprod, String descripcion, Double precio, String clasificacion, Integer cantidad, Integer existmin, Integer existmax) {
        this.idprod = idprod;
        this.descripcion = descripcion;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.cantidad = cantidad;
        this.existmin = existmin;
        this.existmax = existmax;
    }    
    
    /**
     * Metodo que regresa la lista de campos en una cadena
     * @return list of fields
     */
    public static String fieldsToString(){
        String fieldsStr = "";
        List<String> fieldsToConvert = Arrays.asList(FIELDS);
        for(String field:fieldsToConvert){
            fieldsStr = String.format("%s, %s", fieldsStr, field);
        }
        return fieldsStr.replaceFirst(", ", "");
    }

    /**
     * @return the idprod
     */
    public Integer getIdprod() {
        if (this.idprod == null) {
            throw new NullPointerException(
                    String.format("El producto %s no existe.", this.descripcion));
        }
        return idprod;
    }

    /**
     * @param idprod the idprod to set
     */
    public void setIdprod(Integer idprod) {
        this.idprod = idprod;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the existmin
     */
    public Integer getExistmin() {
        return existmin;
    }

    /**
     * @param existmin the existmin to set
     */
    public void setExistmin(Integer existmin) {
        this.existmin = existmin;
    }

    /**
     * @return the existmax
     */
    public Integer getExistmax() {
        return existmax;
    }

    /**
     * @param existmax the existmax to set
     */
    public void setExistmax(Integer existmax) {
        this.existmax = existmax;
    }
    
    public  String cadena(){
        String s = "ID: " + this.idprod + ", Desc: " + this.descripcion +
                ", Class: " + this.clasificacion + ", Precio: " + this.precio;
        return s;
    }

}
