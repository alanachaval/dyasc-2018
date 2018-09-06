package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private List<Compra> compras;

    public Cuenta() {
        this.compras = new ArrayList<Compra>();
    }

    public void AgregarCompra(Compra compra) {
        this.compras.add(compra);
    }
    
    public List<Compra> getCompras() {
        return compras;
    }
    
}
