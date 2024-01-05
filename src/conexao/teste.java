package conexao;

import java.util.List;

/**
 *
 * @author João Fernandes
 */
public class teste {
    public static void main(String[] args) {
    gestao fg=new gestao();
    
//    BDPontos bd=new BDPontos("1", 1);
//    fg.SalvarPontos(bd);

        System.out.println("_________________Listando Jogadores_________________");
        List<BDPontos> lp4=fg.ListarJogadores();
        for (BDPontos lp1 : lp4) {
            System.out.println(lp1);           
        }
    }
}
