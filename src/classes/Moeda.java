package classes;

public class Moeda {

    public double x, y;
    public double vxcano;
    public Hitbox moedaBox;
    public static int xsVelocidade = -120;

    public Moeda(double x, double y) {
        this.x = x;
        this.y = y;

        moedaBox = new Hitbox(x, y + 30, x + 80, 50);
    }

    public void atualizarMoeda(double dt) {
        x += xsVelocidade * dt;
        moedaBox.mover(xsVelocidade * dt, 0);
    }

    public void desenharMoeda(Tela t) {
        t.imagem("flappy.png", 595, 270, 80, 50, 0, x-11, y + 30);
    }

}
