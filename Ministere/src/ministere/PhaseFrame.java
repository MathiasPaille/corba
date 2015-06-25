package ministere;

import gestionVoeu.Phase;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import tools.IDValue;
import tools.IDValueCustomRenderer;

/**
 *
 * @author Yvan
 */
public class PhaseFrame extends javax.swing.JFrame {

    /**
     * Creates new form PhaseFrame
     */
    public PhaseFrame() {
        initComponents();
        this.comboBoxPhase.setRenderer(new IDValueCustomRenderer());
        DefaultComboBoxModel<IDValue> model = new DefaultComboBoxModel<>();
        model.addElement(new IDValue(Phase._PHASE_1+"", Phase.PHASE_1.toString()));
        model.addElement(new IDValue(Phase._PHASE_2+"", Phase.PHASE_2.toString()));
        model.addElement(new IDValue(Phase._PHASE_3+"", Phase.PHASE_3.toString()));
        model.addElement(new IDValue(Phase._PHASE_4+"", Phase.PHASE_4.toString()));
        model.addElement(new IDValue(Phase._PHASE_5+"", Phase.PHASE_5.toString()));
        this.comboBoxPhase.setModel(model);
        this.rafraichirPhaseActuelle();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void rafraichirPhaseActuelle(){
        this.phaseActuelleLibelle.setText(MinistereServeur.getInstance().getPhaseActuelle().toString());
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
        phaseActuelleLibelle = new javax.swing.JLabel();
        comboBoxPhase = new javax.swing.JComboBox();
        modifierButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ministère");
        setMaximumSize(new java.awt.Dimension(255, 65));
        setMinimumSize(new java.awt.Dimension(255, 65));
        setResizable(false);

        jLabel1.setText("Phase actuelle: ");

        phaseActuelleLibelle.setText(" ");

        modifierButton.setText("Modifier");
        modifierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phaseActuelleLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(phaseActuelleLibelle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPhase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierButtonActionPerformed
        MinistereServeur.getInstance().setPhaseActuelle(Phase.from_int(Integer.parseInt(((IDValue)this.comboBoxPhase.getSelectedItem()).ID)));
        this.rafraichirPhaseActuelle();
    }//GEN-LAST:event_modifierButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxPhase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modifierButton;
    private javax.swing.JLabel phaseActuelleLibelle;
    // End of variables declaration//GEN-END:variables
}