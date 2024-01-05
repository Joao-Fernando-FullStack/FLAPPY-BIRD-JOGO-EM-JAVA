package classes;

public class Pontuacao {
    
    public int numero;
    public static String snumero;
    public static int record = 0;
    public static int[][] dadosNumero = {
        {576, 200},
        {578, 236},
        {578, 268},
        {578, 300},
        {574, 346},
        {574, 370},
        {330, 490},
        {350, 490},
        {370, 490},
        {390, 490}
    };

    public Pontuacao(int n) {
        this.numero = n;
        setSNumero();
    }

    public Pontuacao() {
    }

    public void setSNumero() {
        snumero = String.valueOf(numero);
    }

    public void setSCore(int n) {
        numero = n;
        setSNumero();
    }

    public int getPontuacao() {
        return numero;
    }

    public void modificarPontuacao(int dn) {
        numero += dn;
        setSNumero();
    }

    public void desenharPontuacao(Tela t, int x, int y) {
        for (int i = 0; i < snumero.length(); i++) {
            desenharNumero(t, Integer.parseInt(snumero.substring(i, i + 1)), x + 15 * i, y);
        }
    }

    public void desenharRecord(Tela t, int x, int y) {
        String srecord = String.valueOf(Pontuacao.record);
        for (int i = 0; i < srecord.length(); i++) {
            desenharNumero(t, Integer.parseInt(srecord.substring(i, i + 1)), x + 15 * i, y);
        }
    }

    public void desenharNumero(Tela t, int numero, int x, int y) {
        t.imagem("flappy.png", dadosNumero[numero][0], dadosNumero[numero][1], 14, 20, 0, x, y);
    }
    

}
