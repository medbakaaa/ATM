package Classes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.AuthProvider;

import IntefaceGraphics.Authenti;



public class tst implements Serializable{
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        FileInputStream relver=new FileInputStream("..\\ATMProject\\src\\LesAgence\\Agence");
        try (ObjectInputStream os = new ObjectInputStream(relver)) {
            Object obj;
            obj=os.readObject();
            agence a;
            if(obj instanceof agence)a=(agence)obj;
            else a=null;
            compte.setC((a.getnbCompte())-1);
            System.out.println(a.getEmp(0).getPin());
            Authenti c=new Authenti();
            Authenti.setA(a);
            c.setLocationRelativeTo(null);
            c.setVisible(true);
        }
    }
   
}
