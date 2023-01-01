package Classes;
import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class client implements Serializable {
    private static int c=0;
    private String code;
    private String nom;
    private String prenom;
    private String ident;
    private agence monagence;
    private int nbco; 
    private compte mesCompte[]; 
    public client(String nom,String prenom,String adress,agence monagence){
        this.nbco=0;
        this.code=this.getClass().getName()+":"+(++c);
        this.monagence=monagence;
        this.nom=nom;
        this.prenom=prenom;
        this.ident=adress;
        mesCompte=new compte[4];
    }
    public compte getcompte(int nco){
        if(nco>=0 && nco<=nbco){
            return this.mesCompte[nco];}
        else return null;}
    public void addCompte(compte co){
        if(this.nbco<4){
            this.mesCompte[this.nbco]=co;
            this.nbco++;
            this.monagence.addClient(this);
        }
        else System.out.println("place inssufisante!!");
    }
    public String getIdent() {
        return ident;
    }
    public compte getCo(String nu){
        compte c=null;
        for(int i=0;i<nbco;i++){
            if(mesCompte[i].getNumeroCompte()==nu){
                c=mesCompte[i];
            }
        }
        return c;
    }
    public void creeCompte(agence a,double d,int i) throws StreamCorruptedException, IOException, ClassNotFoundException{
        if(i==0){
            comptePayant c=new comptePayant(a, this, d);
            a.addCompte(c);
            c.Sauvgarde(c.PRI());
            System.out.println("le code payant"+c.getPin());
        }else if(i==1){
            compteEpargne c=new compteEpargne(a, this, d);
            a.addCompte(c);
            c.Sauvgarde(c.PRI());
            System.out.println("le code epargne"+c.getPin());
            System.out.println("le code epargne"+c.getRib());
        }
    }
    
    
    public int getNbCompte(){return this.nbco;}
    public String getNom(){ return this.nom+" "+this.prenom;}
    public String getCode(){return this.code;}
    public String toString(){return "------client------\nCode:"+this.code+"\nNom et Prenom:"+this.nom+" "+this.prenom+"\nAdress:"+ident+"\nAgence:"+this.monagence.getNumero()+"\nNombre de compte:"+this.nbco;}
}
