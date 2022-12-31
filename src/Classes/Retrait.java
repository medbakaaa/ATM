package Classes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Retrait extends Operation implements Serializable{
    private int ver=0;
    public Retrait(compte Co,double mont){
        super(Co,mont);
        this.retirer();
    }
    public void Save(){
        
        try{
            FileOutputStream f=new FileOutputStream("C:\\Users\\pc\\Desktop\\ATMProject\\src\\Relves\\relver"+Co.getnR(),true);
            ObjectOutputStream os=new ObjectOutputStream(f);
            os.writeObject(this);
            os.close();f.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void retirer(){
        if(this.mont<=(this.Co.getSolde())){
            if(Co instanceof compteEpargne){
                ((compteEpargne)Co).retirer(mont);
               
            } else if(Co instanceof comptePayant){
                ((comptePayant)Co).retirer(mont);
            } 
        }else this.ver=1;
        this.rest=Co.getSolde();
    }
    public int getVer() {
        return ver;
    }
     
    public String toString(){
        return this.Dt+"\t|Retrait\t\t\t\t|"+this.rest+"\t\t|"+mont;
    }
    
}
