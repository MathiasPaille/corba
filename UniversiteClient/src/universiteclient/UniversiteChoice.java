package universiteclient;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.DiplomeDetail;
import gestionVoeu.EtatVoeu;
import gestionVoeu.Phase;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import tools.IDValue;
import tools.IDValueCustomRenderer;

/**
 *
 * @author Yvan
 */
public class UniversiteChoice extends javax.swing.JFrame {

    private ArrayList<CandidaturePanel> candidaturesList;
    private CandidatureDetail[] candidatureDetail;
    
    /**
     * Creates new form UniversiteChoice
     */
    public UniversiteChoice() {
        this.candidaturesList = new ArrayList<>();
        initComponents();
        
        //initialiser les éléments
        this.universiteLibelle.setText(UniversiteClient.getInstance().getUniversiteLibelle());
        this.rectoratLibelle.setText(UniversiteClient.getInstance().getRectoratLibelle());
        
        this.comboFormation.setRenderer(new IDValueCustomRenderer());
        this.comboFormation.addActionListener(new ComboFormationListener());
        DefaultComboBoxModel<IDValue> modelFormation = new DefaultComboBoxModel<>();
        for(DiplomeDetail form : UniversiteClient.getInstance().getFormationsList()){
            modelFormation.addElement(new IDValue(Integer.toString(form.id), form.libelle));
        }
        this.comboFormation.setModel(modelFormation);
        this.buttonClore.setEnabled(UniversiteClient.getInstance().getPhase().equals(Phase.PHASE_4));
        this.magicButton.setEnabled(UniversiteClient.getInstance().getPhase().equals(Phase.PHASE_4));
            
        //ouvrir la fenêtre
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public int compteOuiDefinitif(){
        int i = 0;
        for(CandidatureDetail cd : this.candidatureDetail){
            if(cd.etatVoeu.value()==EtatVoeu._OUI_DEFINITIF) i++;
        }
        return i;
    }
    
    public void rafraichirVoeux(int id){
        this.seeVoeux.removeAll();
        this.candidaturesList.clear();
        this.candidatureDetail = UniversiteClient.getInstance().getVoeux(id);
        this.seeVoeux.add(Box.createRigidArea(new Dimension(0, 5)));
        for(CandidatureDetail cd : this.candidatureDetail){
            CandidaturePanel pan = new CandidaturePanel(cd, this);
            this.candidaturesList.add(pan);
            this.seeVoeux.add(pan);
            this.seeVoeux.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        this.seeVoeux.repaint();
        this.jScrollPane1.revalidate();
        this.nombreOuiDefLibelle.setText(this.compteOuiDefinitif()+"");
    }
    
    class ComboFormationListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(comboFormation.getSelectedIndex() >= 0){
                String str = ((IDValue) comboFormation.getModel().getSelectedItem()).ID;
                //utiliser lastMember
                rafraichirVoeux(Integer.parseInt(str));
            }
        }
    }
    
    private void letTheMagicHappen(File file){
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.append("Nom;Prenom;Adresse;Formation d'origine\n");
            for(CandidatureDetail cd : this.candidatureDetail){
                if(cd.etatVoeu.equals(EtatVoeu.OUI_DEFINITIF)){
                    StringBuilder strBld = new StringBuilder();
                    strBld.append(cd.voeuxDetail.etu.nom);
                    strBld.append(";");
                    strBld.append(cd.voeuxDetail.etu.prenom);
                    strBld.append(";");
                    strBld.append(cd.voeuxDetail.etu.adresse);
                    strBld.append(";");
                    strBld.append(cd.voeuxDetail.etu.license);
                    strBld.append("\n");
                    fw.append(strBld.toString());
                }
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(UniversiteChoice.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        universiteLibelle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rectoratLibelle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboFormation = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        nombreOuiDefLibelle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seeVoeux = new javax.swing.JPanel();
        buttonClore = new javax.swing.JButton();
        magicButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 650));
        setMinimumSize(new java.awt.Dimension(960, 650));
        setResizable(false);

        jLabel1.setText("Université: ");

        universiteLibelle.setText("jLabel2");

        jLabel3.setText("Rectorat: ");

        rectoratLibelle.setText("jLabel4");

        jLabel5.setText("Formation: ");

        comboFormation.setMaximumRowCount(10);

        jLabel6.setText("Nombre de Oui Défnitif dans la formation: ");

        nombreOuiDefLibelle.setText(" ");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(938, 543));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(938, 543));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(938, 543));

        seeVoeux.setMaximumSize(new java.awt.Dimension(938, 454545454));
        seeVoeux.setMinimumSize(new java.awt.Dimension(938, 0));
        seeVoeux.setPreferredSize(new java.awt.Dimension(938, 543));
        seeVoeux.setLayout(new javax.swing.BoxLayout(seeVoeux, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(seeVoeux);

        buttonClore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonClore.setForeground(new java.awt.Color(255, 0, 0));
        buttonClore.setText("CLORE LES INSCRIPTIONS !!!!!!!!!!!!!!!!");
        buttonClore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloreActionPerformed(evt);
            }
        });

        magicButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        magicButton.setForeground(new java.awt.Color(0, 0, 204));
        magicButton.setText("MAGIC");
        magicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magicButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFormation, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(universiteLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rectoratLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreOuiDefLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonClore, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(magicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(universiteLibelle)
                    .addComponent(jLabel3)
                    .addComponent(rectoratLibelle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboFormation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(nombreOuiDefLibelle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonClore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(magicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloreActionPerformed
        for(CandidatureDetail cd : this.candidatureDetail){
            UniversiteClient.getInstance().cloreCandidature(cd);
        }
        this.rafraichirVoeux(Integer.parseInt(((IDValue) comboFormation.getModel().getSelectedItem()).ID));
    }//GEN-LAST:event_buttonCloreActionPerformed

    private void magicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choisir la destination");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = new File(chooser.getSelectedFile().toString() + File.separator + "data.csv");
            letTheMagicHappen(file);
        }
    }//GEN-LAST:event_magicButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClore;
    private javax.swing.JComboBox comboFormation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton magicButton;
    private javax.swing.JLabel nombreOuiDefLibelle;
    private javax.swing.JLabel rectoratLibelle;
    private javax.swing.JPanel seeVoeux;
    private javax.swing.JLabel universiteLibelle;
    // End of variables declaration//GEN-END:variables
}
