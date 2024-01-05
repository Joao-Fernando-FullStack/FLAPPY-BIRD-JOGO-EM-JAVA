package classes;

import conexao.BDPontos;
import conexao.gestao;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import telas.Jogador;
import telas.Menu;

public class FlappyBird implements Jogo {

    public Passaro passaro;
    public ArrayList<Cano> canos = new ArrayList<>();
    public ArrayList<Moeda> moedas = new ArrayList<>();
    public Random gerador = new Random();
    public Timer tempo_cano;
    public Hitbox box_chao;
    public Timer auxtimer;

    public double chao_offset = 0;
    public double scenario_offset = 0;

    public int estado_jogo = 0; //[0->Tela de Começo] [1->Get Ready] [2->Game] [3->Game Over]
    public static Pontuacao pontuacao;

    boolean nivel = false;

    public FlappyBird() {
        passaro = new Passaro(50, getLargura() / 4);
        tempo_cano = new Timer(2, true, addCano());
        pontuacao = new Pontuacao(0);
        box_chao = new Hitbox(0, getAltura() - 112, getLargura(), getAltura());
    }

    private Acao addCano() {
        return new Acao() {
            public void executa() {
                int numAleatorio = gerador.nextInt(getAltura() - 112 - Cano.BURACO);
                canos.add(new Cano(getLargura(), numAleatorio));
                moedas.add(new Moeda(getLargura() + 10, numAleatorio));
            }
        };
    }

    public void gameOver() {
        bateu();
//        try {
//            HighScore();
//        } catch (Exception e) {
//        }
        
        canos = new ArrayList<Cano>();
        moedas = new ArrayList<Moeda>();
        passaro = new Passaro(50, getAltura() / 4);
        proximaCena().executa();
    }

    private Acao proximaCena() {
        return new Acao() {
            public void executa() {
                estado_jogo += 1;
                estado_jogo = estado_jogo % 4;
            }
        };
    }

    public void tique(Set<String> keys, double dt) {
        scenario_offset += dt * 25;
        scenario_offset = scenario_offset % 288;
        chao_offset += dt * 100;
        chao_offset = chao_offset % 308;

        switch (estado_jogo) {
            case 0: //Carregar Jogo
                break;
            case 1: //Tela de Get Ready
                auxtimer.tique(dt);
                passaro.atualizarSprites(dt);
                break;
            case 2: //Tela do Game
                tempo_cano.tique(dt);
                passaro.atualiza(dt);
                passaro.atualizarSprites(dt);
                if (box_chao.intersecao(passaro.box) != 0) {
                    gameOver();
                    return;
                }
                if (passaro.y < -5) {
                    gameOver();
                    return;
                }
                for (Cano cano : canos) {
                    cano.atualizarCano(dt);
                    //Passáro interceptando os canos
                    if (cano.boxcima.intersecao(passaro.box) != 0 || cano.boxbaixo.intersecao(passaro.box) != 0) {

                        if (pontuacao.getPontuacao() > Pontuacao.record) {
                            Pontuacao.record = pontuacao.getPontuacao();
                        }

                        gameOver();
                        return;
                    }

                    if (!cano.counted && cano.x < passaro.x) {
                        cano.counted = true;
                        pontuacao.modificarPontuacao(1);
                    }

                    if (pontuacao.getPontuacao() > 10) {
                        nivel = true;
                    }
                }

                for (Moeda coinn : moedas) {
                    coinn.atualizarMoeda(dt);
                    //Passáro interceptando a moeda
                    if (passaro.box.intersecao(coinn.moedaBox) != 0) {
                        moedas.remove(0);
                        moeda();
                    }
                }

                if (canos.size() > 0 && canos.get(0).x < -70) {
                    canos.remove(0);
                }

                break;
            case 3: //Tela de Game Over
                break;
        }
    }

    public String getTitulo() {
        return "Flappy Bird";
    }

    public int getLargura() {
        return 384;
    }

    public int getAltura() {
        return 512;
    }

    //Evento do Teclado
    public void tecla(String c) {
        switch (estado_jogo) {
            case 0:
                if (c.equals(" ")) {
                    auxtimer = new Timer(1.6, false, proximaCena());
                    proximaCena().executa();
                }
                break;
            case 1:
                break;
            case 2:
                if (c.equals(" ")) {
                    saltar();
                    passaro.flap();
                }
                break;
            case 3:
                if (c.equals(" ")) {
                    pontuacao.setSCore(0);
                    proximaCena().executa();
                }
                break;
        }
    }

    @Override
    public void desenhar(Tela t) {
        //Desenhando o fundo
        if (nivel) {
            t.imagem("h.png", 0, 0, 300, 512, 0, (int) (-scenario_offset), 0);
            t.imagem("h.png", 0, 0, 300, 512, 0, (int) (288 - scenario_offset), 0);
            t.imagem("h.png", 0, 0, 300, 512, 0, (int) ((288 * 2) - scenario_offset), 0);
        } else if (nivel == false) {
            t.imagem("flappy.png", 0, 0, 288, 512, 0, (int) -scenario_offset, 0);
            t.imagem("flappy.png", 0, 0, 288, 512, 0, (int) (288 - scenario_offset), 0);
            t.imagem("flappy.png", 0, 0, 288, 512, 0, (int) ((288 * 2) - scenario_offset), 0);
        }

        //Desenhando os Canos
        for (Cano cano : canos) {
            cano.desenharCano(t);
        }

        //Desenhando as Moedas
        for (Moeda cano : moedas) {
            cano.desenharMoeda(t);
        }

        //Desenhando o Chão
        t.imagem("flappy.png", 292, 0, 308, 112, 0, -chao_offset, getAltura() - 112);
        t.imagem("flappy.png", 292, 0, 308, 112, 0, 308 - chao_offset, getAltura() - 112);
        t.imagem("flappy.png", 292, 0, 308, 112, 0, (308 * 2) - chao_offset, getAltura() - 112);

        switch (estado_jogo) {
            case 0:
                nivel = false;
                t.imagem("flappy.png", 292, 346, 192, 44, 0, getLargura() / 2 - 192 / 2, 100);
                t.imagem("flappy.png", 352, 306, 70, 36, 0, getLargura() / 2 - 70 / 2, 175);              
                break;
            case 1:
                passaro.desenharMesmoPassaro(t);
                t.imagem("flappy.png", 292, 442, 174, 44, 0, getLargura() / 2 - 174 / 2, getAltura() / 3);
                pontuacao.desenharPontuacao(t, 5, 5);
                break;
            case 2:
                pontuacao.desenharPontuacao(t, 5, 5);
                passaro.desenharMesmoPassaro(t);
                break;
            case 3:
                t.imagem("flappy.png", 292, 398, 188, 38, 0, getLargura() / 2 - 188 / 2, 100);
                t.imagem("flappy.png", 292, 116, 226, 116, 0, getLargura() / 2 - 226 / 2, getAltura() / 2 - 116 / 2);
                pontuacao.desenharPontuacao(t, getLargura() / 2 + 50, getAltura() / 2 - 25);
                pontuacao.desenharRecord(t, getLargura() / 2 + 55, getAltura() / 2 + 16);
                break;
        }
    }

    public static void main(String[] args) {
        roda();
        saltar();
    }

    public static void saltar() {
        Motor.tocar("pulo.wav");
    }

    public static void moeda() {
        Motor.tocar("ponto.wav");
    }

    public static void bateu() {
        Motor.tocar("hit.wav");
    }

    public static void record() {
        Motor.tocar("record.wav");
    }

    private static void roda() {
        new Motor(new FlappyBird());
    }
    
    void HighScore(){

        gestao b = new gestao();
        long maior = 0;
        for (int i = 0; i < b.ListarJogadores().size(); i++) {

            if (b.ListarJogadores().get(i).getPontuacao() > maior) {
                maior = b.ListarJogadores().get(i).getPontuacao();
                if (maior < pontuacao.record) {
                    Jogador j = new Jogador();
                    j.show();
                }
            }

        }
        
    }

}
