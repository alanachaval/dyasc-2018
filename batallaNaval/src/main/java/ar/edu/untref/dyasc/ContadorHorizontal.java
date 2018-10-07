package ar.edu.untref.dyasc;

public class ContadorHorizontal extends Contador {

    public ContadorHorizontal(int x, int y) {
        super(x, y);
    }

    public void incrementar() {
        x++;
    }

    public void decrementar() {
        x--;
    }

    public int getVariable() {
        return x;
    }

}