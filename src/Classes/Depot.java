package Classes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author pc
 */
public class Depot extends Operation implements Serializable{
    public Depot(compte Co,double mont){
        super(Co,mont);
        this.deposer();
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
    
    public void deposer(){
            if(Co instanceof compteEpargne){
                ((compteEpargne)Co).deposer(mont);;
               
            } else if(Co instanceof comptePayant){
                ((comptePayant)Co).deposer(mont);
            } 
            this.rest=Co.getSolde();
            }
    


    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return this.Dt+"\t|Depot\t\t\t\t|"+this.rest+"\t\t|"+mont;
    }
}
