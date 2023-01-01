package Classes;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Random;

public class compte implements Serializable {
    private String numeroCompte;
    private int rib; 
    private static int c=0;
    private int nR;
    protected double solde;
    protected agence lAgence;
    protected client proprietaire;
    protected FileOutputStream f;
    private int pin;
    Random n=new Random();
    public compte(agence lAgence,client proprietaire,double solde) throws IOException,StreamCorruptedException{
        this.numeroCompte=this.getClass().getName().substring(this.getClass().getPackage().getName().length()+1)+":"+(++c);
        this.lAgence=lAgence;
        this.proprietaire=proprietaire;
        this.solde=solde;
        proprietaire.addCompte(this);
        this.pin=n.nextInt(8999)+1000;
        this.nR=c;
        this.rib=n.nextInt(999999999);
    }
    public int getPin(){return pin;}
    public int getnR() {return this.nR;}
    public client getClient(){return this.proprietaire;}
    public String getNumeroCompte(){return this.numeroCompte;}
    public void setSalaire(double s){this.solde=s;}
    public double getSolde(){return this.solde;}
    public String toString(){return "------Compte------\nCode:"+this.numeroCompte+"\n\tProprietaire:"+this.proprietaire+"\nAgence:"+this.lAgence+"\nSolde:"+this.solde;}
   
    public void setPin() {
        this.pin =n.nextInt(9999);
    }
    
    public void retirer(double m){
        this.solde-=m;
    }
    public void deposer(double m){
        this.solde+=m;
    }
    public int getRib() {
        return rib;
    }
    public String toPin(){
        return this.numeroCompte+"\t|\t"+this.pin+"\n";
    }
    public static void setC(int n) {
        compte.c=n;
    }
    public String PRI(){return this.numeroCompte+"\tpin:"+this.pin+"\trib:"+this.rib+"\tId:"+proprietaire.getIdent()+"\n";}
    public void Sauvgarde(String s) throws IOException{
        File f=new File("..\\ATMProject\\src\\Classes\\lesCompte\\Comptes.txt");
        FileWriter v=new FileWriter(f,true);
        v.append(s);
        v.close();
    }
    
}
