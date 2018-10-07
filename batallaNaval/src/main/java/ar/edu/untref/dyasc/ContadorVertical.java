package ar.edu.untref.dyasc;

public class ContadorVertical extends Contador {

    public ContadorVertical(int x, int y) {
        super(x, y);
    }

    public void incrementar() {
        y++;
    }

    public void decrementar() {
        y--;
    }

    public int getVariable() {
        return y;
    }

}