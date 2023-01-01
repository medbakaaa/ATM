package IntefaceGraphics.EMLOYER_INT;

import java.awt.event.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Classes.*;
import IntefaceGraphics.ALERT_INT.AlertPin;
import IntefaceGraphics.CLIENT_INT.MenuPrinClt;

/**
 *
 * @author pc
 */
public class ribver extends javax.swing.JFrame {
    private compte co;
    private agence a;
    private int cnt=2;
    /**
     * Creates new form NewJFrame
     */
    public ribver() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField(4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Validé");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Saiser le Rib");

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPasswordField1.setText("1111111111");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pwd = new String(jPasswordField1.getPassword());
        int rib=Integer.parseInt(pwd);
        double d=this.getCompte(rib).getSolde();
        String s=String.valueOf(d);
        if(this.verifieRib(rib)){
            MenuPrinClt m=new MenuPrinClt();
            m.jTextPane1.setText(s);
            m.setCo(this.getCompte(rib));
            m.setLocationRelativeTo(null);
            m.setVisible(true);
            this.setVisible(false);
        }else{
                AlertPin p=new AlertPin();
                p.setLocationRelativeTo(null);
                p.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
    public  boolean verifieRib(int Rib){
        int i;
        for(i=0;i<a.getnbCompte();i++){
           if(a.getCompte(i).getRib()==Rib){
                return true;
           }
        }
        if(i==a.getnbCompte()) 
            {
            return false;}
        return false;
    }
    public compte getCompte(int rib){
        int x=0;
        for(int i=0;i<a.getnbCompte();i++){
            if(a.getCompte(i).getRib()==rib){
                 x=i;
            }
         }
         return a.getCompte(x);
    }
    public void setA(agence a) {
        this.a = a;
    }
   }


