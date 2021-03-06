package tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Dialogue Custom d'entrée d'un mandant
 * @author Yvan
 */
public class MandantDialog extends javax.swing.JDialog {

    private String mandant;
    
    /**
     * Creates new form MandantDialog
     * @param parent
     * @param modal
     */
    private MandantDialog(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        mandant = "";
        initComponents();
        this.setTitle(title);
        this.mandantField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {}

            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                    okButtonActionPerformed(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {}
        });
    }
    
    private String showDialog(){
        this.setLocationRelativeTo(null);
        setVisible(true);
        return mandant;
    }
    
    /**
     * Initialise un dialogue modal et bloquant
     * @return le mandant
     */
    public static String getMandant(){
        return new MandantDialog(null, true, "Mandant").showDialog();
    }
    
    /**
     * Initialise un dialogue modal et bloquant
     * @param title titre du dialogue
     * @return le mandant
     */
    public static String getMandant(String title){
        return new MandantDialog(null, true, title).showDialog();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JToggleButton();
        mandantField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mandant");
        setModal(true);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mandantField)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(okButton)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mandantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        mandant = this.mandantField.getText();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField mandantField;
    private javax.swing.JToggleButton okButton;
    // End of variables declaration//GEN-END:variables
}
