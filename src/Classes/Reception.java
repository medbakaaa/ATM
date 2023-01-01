package Classes;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Reception extends Operation implements Serializable{
    private compte Cos;
    private client Cld;
    public Reception(compte Cos,compte Co,double mont){
        super(Co,mont);
        this.Cos=Cos;
        this.Cld=this.Cos.getClient();
    }
    public void Save(){
        try{
            FileOutputStream f=new FileOutputStream("..\\ATMProject\\src\\Relves\\relver"+Co.getnR(),true);
            ObjectOutputStream os=new ObjectOutputStream(f);
            os.writeObject(this);
            os.close();
            f.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return this.Dt+"\t|Virment depuis "+Cos.getNumeroCompte()+"\t\t|"+Co.getSolde()+"\t\t|"+mont;
    }
}
