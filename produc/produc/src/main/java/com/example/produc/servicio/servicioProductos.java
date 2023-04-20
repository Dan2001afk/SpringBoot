package com.example.produc.servicio;
import com.example.produc.entidad.productos;
import java.math.BigDecimal;
import java.util.ArrayList;
public class servicioProductos {
    private ArrayList<productos> listaP = new ArrayList<>();
    public servicioProductos(){
        listaP.add(new productos(1,"sofa cama","mueble",300000,4));
        listaP.add(new productos(2,"Sofá 2 Puestos","mueble",2500000,1));
        listaP.add(new productos(3,"Silla Gamer","mueble",700000,2));
        listaP.add(new productos(4,"Silla Ergonomica","mueble",180000,4));
        listaP.add(new productos(5,"Armario 6 Puertas","mueble",650000,10));
        listaP.add(new productos(6,"HP 14AMD RZ5 12GB","portatiles",3000000,3));
        listaP.add(new productos(7,"LENOVO THINKPAD T14","portatiles",2500000,2));
        listaP.add(new productos(8,"Asus TUF A15 ","portatiles",6000000,7));
        listaP.add(new productos(9,"Lenovo IdeaPad 3","portatiles",1500000,1));
        listaP.add(new productos(10,"Hidrolavadora","Aseo",450000,1));
        listaP.add(new productos(11,"Trapero giratorio ","aseo",25000,7));
        listaP.add(new productos(12,"Taladro percutor","Mantenimiento",195000,2));
    }
    public int cantidadProductos(){/*cantidad de productos*/
    return listaP.size();
    }
    public ArrayList<productos>mostrarLista(){/*muestra lista de los productos*/
        return listaP;
    }

    public BigDecimal obtenerPrecioMasBarato() {/*muestra el precio mas bajo de toda la lista*/
        BigDecimal precioMasBarato = BigDecimal.valueOf(listaP.get(0).getPrecio());
        for (int i = 1; i < listaP.size(); i++) {
            if (BigDecimal.valueOf(listaP.get(i).getPrecio()).compareTo(precioMasBarato) < 0) {
                precioMasBarato = BigDecimal.valueOf(listaP.get(i).getPrecio());
            }
        }
        return precioMasBarato;
    }

    public productos buscarProductoPorId(int cod) {
        for (productos p : listaP) {
            if (p.getCodigo() == cod) {
                return p;
            }
        }
        return null;
    }

    public productos aplicarDescuento(int codigo) {
        productos p = buscarProductoPorId(codigo);
        if (p != null) {
            double precioOriginal = p.getPrecio();
            double descuento = precioOriginal * 0.05;
            double precioConDescuento = precioOriginal - descuento;
            productos pModificado = new productos(p.getCodigo(), p.getNombre(), p.getCategoria(), (int) precioConDescuento, p.getStock());
            int index = listaP.indexOf(p);
            listaP.set(index, pModificado);
            return pModificado;
        }
        return null;
    }

}
