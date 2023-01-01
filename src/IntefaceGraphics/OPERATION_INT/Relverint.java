package IntefaceGraphics.OPERATION_INT;

import java.awt.Dimension;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import Classes.*;
import IntefaceGraphics.CLIENT_INT.MenuPrinClt;

import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */
public class Relverint extends javax.swing.JFrame {

    /**
     * Creates new form Relverint
     */
    public Relverint() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Relevé Bancaire");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Quiter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, 500)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        double solde=MenuPrinClt.getCo().getSolde();
        String s=String.valueOf(solde);
        MenuPrinClt m=new MenuPrinClt();
        m.jTextPane1.setText(s);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    public void AfficherRe(JTextArea j) throws IOException,EOFException{
        FileInputStream relver=new FileInputStream("..\\ATMProject\\src\\Relves\\relver"+MenuPrinClt.getCo().getnR());
        boolean cont=true;
        j.append("Date\t\t|Opération\t\t\t\t|Solde\t\t|Montant\n");
        j.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        while(cont){
            ObjectInputStream os=new ObjectInputStream(relver);
            try{
            Object obj=os.readObject();
            if(obj==null){cont=false;j.append("Votre solde: "+MenuPrinClt.getCo().getSolde());}
                else if(obj instanceof Retrait){
                    Retrait e=(Retrait)obj;
                    j.append(e.toString()+"\n");
                    j.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                }else if(obj instanceof Depot){
                    Depot e=(Depot)obj;
                    j.append(e.toString()+"\n");
                    j.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                }else if(obj instanceof Virement){
                    Virement e=(Virement)obj;
                    j.append(e.toString()+"\n");
                    j.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                }else if(obj instanceof Reception){
                    Reception e=(Reception)obj;
                    j.append(e.toString()+"\n");
                    j.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                }}catch(Exception e){
            e.printStackTrace();
        }
    
    }}
    public javax.swing.JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void satA(agence a) {
    }
}

