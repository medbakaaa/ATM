/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IntefaceGraphics.OPERATION_INT;

import Classes.*;
import IntefaceGraphics.ALERT_INT.AlertRet;
import IntefaceGraphics.CLIENT_INT.MenuPrinClt;
/**
 *
 * @author pc
 */
public class Retraitint extends javax.swing.JFrame {
    private agence a;
    /**
     * Creates new form Retraitint
     */
    public Retraitint() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("validé");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Combien voulez-vous retairer?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jButton1))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String S=jTextPane1.getText();
        double d=Double.parseDouble(S);
        Retrait R=new Retrait(MenuPrinClt.getCo(),d);
        if(R.getVer()==0){
            R.Save();
            double solde=MenuPrinClt.getCo().getSolde();
            String s=String.valueOf(solde);
            this.setVisible(false);
            MenuPrinClt m=new MenuPrinClt();
            m.setA(a);
            a.Save();
            m.setLocationRelativeTo(null);
            m.jTextPane1.setText(s);
            m.setVisible(true);
            }else{
                this.setVisible(false);
                AlertRet m=new AlertRet();
                m.setA(a);
                m.setLocationRelativeTo(null);
                m.setVisible(true);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
    public void setA(agence a2) {
        this.a=a2;
    }
}
