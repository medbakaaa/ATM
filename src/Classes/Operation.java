package Classes;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public abstract class Operation implements Serializable{
    private client Cl;
    protected double rest;
    protected compte Co;
    protected double mont; 
    protected String Dt;
    public Operation(compte Co,double mont){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        this.Dt=dtf.format(LocalDateTime.now());
        //this.Cl=this.Co.getClient();
        this.Co=Co;
        this.mont=mont;
    }
    public abstract void Save();
  
}
