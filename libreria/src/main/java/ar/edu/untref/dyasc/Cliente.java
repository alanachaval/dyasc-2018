package ar.edu.untref.dyasc;

public class Cliente {

    private String direccion;
    private Cuenta cuenta;
    
    public Cliente(Cuenta cuenta, String direccion) {
        this.cuenta = cuenta;
        this.direccion = direccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public String getDireccion() {
        return direccion;
    }
    
}
