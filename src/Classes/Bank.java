package Classes;
public class Bank {
    private String name;
    private double capitale;
    private String siege;
    private agence Lesagence[];
    public Bank(String name,double cap,String sie){
        this.name=name;
        this.capitale=cap;
        this.siege=sie;
        this.Lesagence=new agence[20];
    }
    public double getCapitale() {
        return capitale;
    }
    public void setCapitale(double capitale) {
        this.capitale = capitale;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSiege() {
        return siege;
    }
    public void setSiege(String siege) {
        this.siege = siege;
    }
}
