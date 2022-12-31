package Classes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Virement extends Operation implements Serializable{
    private compte Cod;
    private client Cld;
    private int ver=0;
    public Virement(compte Co,compte Cod,double mont){
        super(Co,mont);
        this.Cod=Cod;
        this.Cld=this.Cod.getClient();
        this.verser();
        }
    public void Save(){
        try{
            FileOutputStream f=new FileOutputStream("C:\\Users\\pc\\Desktop\\ATMProject\\src\\Relves\\relver"+Co.getnR(),true);
            ObjectOutputStream os=new ObjectOutputStream(f);
            os.writeObject(this);
            os.close();
            f.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
     
    public void verser(){
        if(this.mont<=(this.Co.getSolde())){
            if(Co instanceof compteEpargne){
                ((compteEpargne)Co).retirer(mont);
                Cod.deposer(mont);
               
            } else if(Co instanceof comptePayant){
                ((comptePayant)Co).retirer(mont);
                Cod.deposer(mont);
            } 
        }else{
            this.ver=1;}
        (new Reception(Co, Cod, mont)).Save();
    }
    public int getVer() {
        return ver;
    }
    public String toString(){
        return this.Dt+"\t|Virment vers "+Cod.getNumeroCompte()+"\t\t\t|"+Co.getSolde()+"\t\t|"+mont;
    }
}
