package classes;

public class Cano {
    public double x, y;
    public double vxcano;
    public static int xsVelocidade = -120;
    public static int BURACO = 120;
    public Hitbox boxcima;
    public Hitbox boxbaixo;
    public boolean counted = false;

    public Cano(double x, double y) {
        this.x = x;
        this.y = y;

        boxcima = new Hitbox(x, y - 270 - 220, x + 52, y);
        boxbaixo = new Hitbox(x, y + Cano.BURACO, x + 52, y + Cano.BURACO + 242);
    }

    public void atualizarCano(double dt) {
        x += xsVelocidade * dt;
        boxcima.mover(xsVelocidade * dt, 0);
        boxbaixo.mover(xsVelocidade * dt, 0);
    }

    public void desenharCano(Tela t) {
        t.imagem("flappy.png", 660, 0, 52, 242, 0, x, y + BURACO); //Cano virado pra cima
        t.imagem("flappy.png", 660, 42, 52, 200, 0, x, y + BURACO + 242); //resto do cano virado pra cima

        t.imagem("flappy.png", 604, 0, 52, 270, 0, x, y - 270); //cano virado pra baixo
        t.imagem("flappy.png", 604, 0, 52, 220, 0, x, y - 270 - 220); //resto do cano virado pra baixo
    }
}
