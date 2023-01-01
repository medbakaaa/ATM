package Classes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class comptePayant extends compte implements Serializable{
    private static final double taux_operation=5;
    public comptePayant(agence lAgence,client prop,double solde) throws IOException, ClassNotFoundException{
        super(lAgence,prop,solde);
        this.lAgence.addCompte(this);
    }
    public comptePayant(agence lAgence,client prop) throws IOException, ClassNotFoundException{
        this(lAgence,prop,0);
        
    }
    
    public void deposer(double mont){this.solde=(this.solde+mont)-comptePayant.taux_operation;}
    public void retirer(double mont){this.solde=(this.solde-mont)-comptePayant.taux_operation;}
    public String toString(){return "------Compte------\nCode:"+this.getNumeroCompte()+"\nProprietaire:"+this.proprietaire.getNom()+"\nAgence:"+this.lAgence.getNumero()+"\nSolde:"+this.solde+"\nTaux_operation:"+comptePayant.taux_operation;}
}
