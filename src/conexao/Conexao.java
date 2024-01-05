package conexao;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class Conexao {
    private static ObjectContainer db;
    
    public Conexao(){       
    }
    
     public void AbrirConexao() {
        db = Db4o.openFile("C:\\Users\\João Fernandes\\Documents\\NetBeansProjects\\Flyppy Bird\\BDJogo3.yap");
    }
    
    public void FecharConexao(){
        try {
            db.commit();
            db.close();           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ObjectContainer getConexao(){
        return this.db;    
    }
    
}
