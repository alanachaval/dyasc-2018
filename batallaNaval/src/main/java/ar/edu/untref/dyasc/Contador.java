package ar.edu.untref.dyasc;

public abstract class Contador {

    protected int x;
    protected int y;

    public Contador(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public abstract void incrementar();

    public abstract void decrementar();

    public abstract int getVariable();
}