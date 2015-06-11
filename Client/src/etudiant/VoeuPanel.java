package etudiant;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.EtatDecision;
import gestionVoeu.EtatVoeu;
import java.awt.Color;

/**
 *
 * @author Yvan
 */
public class VoeuPanel extends javax.swing.JPanel {
    
    private CandidatureDetail candidatureDetail;
    private EtudiantChoice etudiantChoice;

    /**
     * Creates new form VoeuPanel
     */
    public VoeuPanel(CandidatureDetail voeu,  EtudiantChoice parent) {
        this.candidatureDetail = voeu;
        this.etudiantChoice = parent;
        initComponents();
        this.classementLabel.setText(""+this.candidatureDetail.voeuxDetail.classement);
        Color colorFont;
        switch(candidatureDetail.etatVoeu.value()){
            case EtatVoeu._CREE: colorFont = Color.BLUE; desactiverButtons(); break;
            case EtatVoeu._ACCEPTE: colorFont = Color.GREEN; activerButtons(); break;
            default: colorFont = Color.BLACK; desactiverButtons(); break;
        };
        this.voeuDesc.setForeground(colorFont);
        Color colorBack;
        switch(candidatureDetail.etatDecision.value()){
            case EtatDecision._ADMIS: colorBack = Color.GREEN; break;
            case EtatDecision._REFUSE: colorBack = Color.RED; break;
            default: colorBack = Color.LIGHT_GRAY; break;
        }
        colorBack = new Color(colorBack.getRed(), colorBack.getGreen(), colorBack.getBlue(), 100);
        this.setBackground(colorBack);
    }
    
    private void desactiverButtons(){
        nonDefButton.setEnabled(false);
        nonMaisButton.setEnabled(false);
        ouiDefButton.setEnabled(false);
        ouiMaisButton.setEnabled(false);
    }
    
    private void activerButtons(){
        nonDefButton.setEnabled(true);
        nonMaisButton.setEnabled(true);
        ouiDefButton.setEnabled(true);
        ouiMaisButton.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voeuDesc = new javax.swing.JLabel();
        nonDefButton = new javax.swing.JToggleButton();
        ouiDefButton = new javax.swing.JToggleButton();
        ouiMaisButton = new javax.swing.JToggleButton();
        nonMaisButton = new javax.swing.JToggleButton();
        classementLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(640, 36));
        setMinimumSize(new java.awt.Dimension(640, 36));

        voeuDesc.setText("voeuDesc");

        nonDefButton.setText("Non définitif");
        nonDefButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nonDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonDefButtonActionPerformed(evt);
            }
        });

        ouiDefButton.setText("Oui Définitif");
        ouiDefButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ouiDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouiDefButtonActionPerformed(evt);
            }
        });

        ouiMaisButton.setText("Oui mais");
        ouiMaisButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ouiMaisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouiMaisButtonActionPerformed(evt);
            }
        });

        nonMaisButton.setText("Non mais");
        nonMaisButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nonMaisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonMaisButtonActionPerformed(evt);
            }
        });

        classementLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(voeuDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ouiDefButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nonDefButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ouiMaisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nonMaisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ouiDefButton)
                            .addComponent(nonDefButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nonMaisButton)
                            .addComponent(ouiMaisButton))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(voeuDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classementLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ouiDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouiDefButtonActionPerformed
        this.etudiantChoice.makeChoice(candidatureDetail, EtatVoeu.OUI_DEFINITIF);
    }//GEN-LAST:event_ouiDefButtonActionPerformed

    private void ouiMaisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouiMaisButtonActionPerformed
        this.etudiantChoice.makeChoice(candidatureDetail, EtatVoeu.OUI_MAIS);
    }//GEN-LAST:event_ouiMaisButtonActionPerformed

    private void nonMaisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonMaisButtonActionPerformed
        this.etudiantChoice.makeChoice(candidatureDetail, EtatVoeu.NON_MAIS);
    }//GEN-LAST:event_nonMaisButtonActionPerformed

    private void nonDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonDefButtonActionPerformed
        this.etudiantChoice.makeChoice(candidatureDetail, EtatVoeu.NON_DEFINITIF);
    }//GEN-LAST:event_nonDefButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel classementLabel;
    private javax.swing.JToggleButton nonDefButton;
    private javax.swing.JToggleButton nonMaisButton;
    private javax.swing.JToggleButton ouiDefButton;
    private javax.swing.JToggleButton ouiMaisButton;
    private javax.swing.JLabel voeuDesc;
    // End of variables declaration//GEN-END:variables
}
