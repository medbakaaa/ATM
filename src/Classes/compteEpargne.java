package Classes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class compteEpargne extends compte implements Serializable{
    public static double taux=6;
    public compteEpargne(agence lAgence,client prop,double solde) throws IOException, ClassNotFoundException{
        super(lAgence,prop,solde);
        this.lAgence.addCompte(this);
        
    }
    public compteEpargne(agence lAgence,client prop) throws IOException, ClassNotFoundException{
        this(lAgence,prop,0);
        
    }
    public void retirer(double m){
        this.solde-=m;
    }
    public void deposer(double m){
        this.solde+=m;
    }
    
    public double getTaux(){return compteEpargne.taux;}
    public void setTaux(double taux){compteEpargne.taux=taux;}
    public void calculInteret(){this.solde*=1-(1/compteEpargne.taux);}
    public String toString(){return "------Compte------\nCode:"+this.getNumeroCompte()+"\nProprietaire:"+this.proprietaire.getNom()+"\nAgence:"+this.lAgence.getNumero()+"\nSolde:"+this.solde+"\nTaux: "+compteEpargne.taux;}
}
