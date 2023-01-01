package Classes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class agence implements Serializable {
    private static int n=0;
    private String numero;
    private String adress;
    private client lesClient[];
    private compte lesCompte[];
    private int nbcl;
    private int nbco;
    private Employer emp[];
    private  int nbem=0;

    public agence(String adress)throws IOException, ClassNotFoundException{
        this.nbcl=nbco=0;
        this.numero=this.getClass().getName().substring(this.getClass().getPackage().getName().length()+1)+":"+(++n);
        this.adress=adress;
        this.lesClient=new client[20];
        this.lesCompte=new compte[40];
        this.emp=new Employer [20];

    }
    public String getAdress() {
        return adress;
    }
    public compte getCompte(int n){ 
        if(n>=0 && n<nbco){
        return lesCompte[n];}
        else
            return null; 
    };
    public client getClient(int ncl){
        if(ncl>=0 && ncl<=nbcl){
            return this.lesClient[ncl];
        }else
            return null;
    }
    public void addCompte(compte co){
        if(nbco<40){
            lesCompte[nbco]=co;
            nbco++;}
        else{System.out.println("place inssufisante!!");}
    }
    public void addClient(client cl){
        if(this.nbcl<20){
            this.lesClient[this.nbcl]=cl;
            this.nbcl++;
        }
        else System.out.println("place inssufisante!!");
    }
    public void addEmp(Employer em){
        if(this.nbem<20){
            this.emp[this.nbem]=em;
            this.nbem++;
        }
        else System.out.println("place inssufisante!!");
    }
    public  int getNbem() {
        return nbem;
    }
    public Employer getEmp(int d){
        if(d>=0 && d<=nbem){
            return this.emp[d];
        }else
            return null;
    }
    public client getCle(String id){
        for(client n:lesClient){
            if(n.getIdent()==id){
                return n;
            }else return null;
        }
        return null;
    }
    public void Save(){
        try{
            FileOutputStream f=new FileOutputStream("..\\ATMProject\\src\\LesAgence\\Agence",false);
            ObjectOutputStream os=new ObjectOutputStream(f);
            os.writeObject(this);
            os.close();
            f.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int getnbClient(){return this.nbcl;}
    public  int getnbCompte(){return nbco;}
    public String getNumero(){return this.numero;}
    public String toString(){return "------Agence------\nnumero:"+this.numero+"\nAdress:"+this.adress+"\nNombre de compte:"+this.nbco+"\nNombre de client:"+this.nbcl;}
    
}
