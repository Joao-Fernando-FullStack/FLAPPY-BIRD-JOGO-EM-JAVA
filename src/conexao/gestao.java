package conexao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;
import classes.FlappyBird;

/**
 *
 * @author João Fernandes
 */
public class gestao {
    private Conexao con;
    private ObjectContainer db;

    public gestao() {
        con = new Conexao();
        con.AbrirConexao();
        db = con.getConexao();
    }

    public void SalvarPontos(BDPontos a) {     
            db.store(a); 
    }
    
//    public void EliminarJogador(int id) {
//        BDPontos f = new BDPontos();
//        f.setId(id);
//        ObjectSet<BDPontos> r = db.queryByExample(f);
//        if (r.hasNext()) {
//            f = r.next();
//            db.delete(f);
//            db.commit();
//            db.close();
//        }
//    }
//    
//    public void salvarJogadores(BDPontos a){
////        int maior[] = 0;
//        long maior = 0;
//        for (int i = 0; i < ListarJogadores().size(); i++) {
//            
//            if(ListarJogadores().get(i).getPontuacao() > maior){
//                maior=ListarJogadores().get(i).getPontuacao();
//                
//                if(FlappyBird.pontuacao>maior){
//                    
//                }
//                
//            }
//        }
//        
//    }
    
    public List<BDPontos> ListarJogadores() {
        ObjectSet listPessoa = db.queryByExample(BDPontos.class);
        List<BDPontos> lp = new ArrayList<>();

        for (Object listpessoa1 : listPessoa) {
            lp.add((BDPontos) listpessoa1);
        }
        return lp;
    }
    
}
