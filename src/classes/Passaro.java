package classes;


public class Passaro {

    public double x, y;
    public double vy = 0;

    public static double G = 1000;
    public static double FLAP = -300;
    public Timer sprite_timer;

    public int sprite_state = 0;
    public int[] sprite_states = {0, 1, 2, 1};
    public int[] sprites_x = {528, 528, 446};
    public int[] sprites_y = {128, 180, 248};

    public Hitbox box;

    private Acao mudasprite() {
        return new Acao() {
            public void executa() {
                sprite_state += 1;
                sprite_state = sprite_state % sprite_states.length;
            }
        };
    }

    public Passaro(double x, double y) {
        this.x = x;
        this.y = y;
        this.vy = 0;
        this.box = new Hitbox(x, y, x + 34, y + 24);
        sprite_timer = new Timer(0.1, true, mudasprite());
    }

    public void atualiza(double dt) {
        vy += G * dt;
        y += vy * dt;

        box.mover(0, vy * dt);
    }

    public void flap() {
        vy = FLAP;
    }

    public void desenhar(Tela t) {
        //Passáro
        t.imagem("flappy.png", 528, 128, 34, 24, Math.atan(vy / 150), x, y);
    }

    public void atualizarSprites(double dt) {
        sprite_timer.tique(dt);
    }

    public void desenharMesmoPassaro(Tela t) {
        t.imagem("flappy.png", sprites_x[sprite_states[sprite_state]], sprites_y[sprite_states[sprite_state]], 34, 24, Math.atan(vy / 200), x, y);
    }

    public int bater(int a) {
        this.x = a;
        return a;
    }

}
