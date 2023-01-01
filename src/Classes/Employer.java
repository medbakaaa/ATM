package Classes;
import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Employer  implements Serializable{
    private String numeroEmp;
    private static int c=0;
    private String nom;
    private agence ag;
    private client clt[];
    private int nc=0;
    private String dtE;
    private int pin;
    Random n=new Random();
    public Employer(agence ag,String nom,int pin){
        this.numeroEmp=this.getClass().getName().substring(this.getClass().getPackage().getName().length()+1)+":"+(++c);
        this.nom=nom;
        this.ag=ag;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        this.dtE=dtf.format(LocalDateTime.now());
        this.clt=new client[10];
        this.pin=pin;
    }
    public agence getAg() {
        return ag;
    }
    public int getNc() {
        return nc;
    }
    public String getNumeroEmp() {
        return numeroEmp;
    }
    public void addClt(client cl,double d,int i) throws StreamCorruptedException, IOException, ClassNotFoundException{
        if(this.nc<10){
            this.clt[this.nc]=cl;
            this.nc++;
            this.ag.addClient(cl);
            cl.creeCompte(this.ag, d,i);
        }
        else System.out.println("place inssufisante!!");
    }
    
    public client getCl(String id){
        client c=null;
        for(int i=0;i<nc;i++){
            if(clt[i].getIdent().equals(id)){
                c=clt[i];
            }}
        if(c!=null){
            return c;
        }else return null;
    }
    
    public int getPin() {
        return pin;
    }
    public String getNom() {
        return nom;
    }
    
}
