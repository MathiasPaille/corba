package etudiant;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.DiplomeDetail;
import gestionVoeu.EtatVoeu;
import gestionVoeu.Phase;
import gestionVoeu.RectoratDetail;
import gestionVoeu.UniversiteDetail;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import tools.IDValue;
import tools.IDValueCustomRenderer;

/**
 *
 * @author Yvan
 */
public class EtudiantChoice extends javax.swing.JPanel {
    
    private ArrayList<VoeuPanel> voeuxAffiches;
    private DefaultComboBoxModel<Integer> modelClassement;

    /**
     * Creates new form EtudiantChoiceAdd
     */
    public EtudiantChoice() {
        voeuxAffiches = new ArrayList<>();
        initComponents();
        this.ineField.setText(Etudiant.getInstance().getDetails().num_etudiant);
        this.nomField.setText(Etudiant.getInstance().getDetails().nom);
        this.prenomField.setText(Etudiant.getInstance().getDetails().prenom);
        this.adresseField.setText(Etudiant.getInstance().getDetails().adresse);
        this.universiteField.setText(Etudiant.getInstance().getDetails().universite);
        this.licenseField.setText(Etudiant.getInstance().getDetails().license);
        
        this.modelClassement = new DefaultComboBoxModel<>();
        for(int i = 1; i <= 5; i++){
            modelClassement.addElement(i);
        }
        this.refreshVoeuxAffiches();
        this.comboClassement.setModel(modelClassement);
        
        this.rectoratList.setCellRenderer(new IDValueCustomRenderer());
        this.universityList.setCellRenderer(new IDValueCustomRenderer());
        this.formationList.setCellRenderer(new IDValueCustomRenderer());
        
        DefaultListModel<IDValue> modelRectorat = new DefaultListModel();
        for(RectoratDetail rect : Etudiant.getInstance().getRectorats()){
            modelRectorat.addElement(new IDValue(rect.id, rect.name));
        }
        this.rectoratList.setModel(modelRectorat);
        this.rectoratList.addListSelectionListener(new RectoratListListener());
        if(Etudiant.getInstance().getPhase().equals(Phase.PHASE_1)){
            this.addChoice.setEnabled(true);
        } else {
            this.addChoice.setEnabled(false);
        }
    }
    
    public final void refreshVoeuxAffiches(){
        this.voeuxAffiches = new ArrayList<>();
        for (CandidatureDetail voeu : Etudiant.getInstance().getListeVoeux()) {
            modelClassement.removeElement(voeu.voeuxDetail.classement);
            VoeuPanel v = new VoeuPanel(voeu, this);
            this.voeuxAffiches.add(v);
        }
        this.seeChoices.removeAll();
        this.voeuxAffiches.sort(null);
        this.seeChoices.add(Box.createRigidArea(new Dimension(0, 5)));
        for(VoeuPanel vp : this.voeuxAffiches){
            this.seeChoices.add(vp);
            this.seeChoices.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
    
    class RectoratListListener implements ListSelectionListener{

        private String lastMember = null;
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(!lse.getValueIsAdjusting()){
                String str = ((IDValue) rectoratList.getModel().getElementAt(lse.getFirstIndex())).ID;
                String str2 = ((IDValue) rectoratList.getModel().getElementAt(lse.getLastIndex())).ID;
                if(str == null ? lastMember != null : !str.equals(lastMember)){
                    lastMember = str;
                } else {
                    lastMember = str2;
                }
                DefaultListModel<IDValue> modelUniversite = new DefaultListModel();
                for(UniversiteDetail univ : Etudiant.getInstance().getUniversitesList(lastMember)){
                    modelUniversite.addElement(new IDValue(univ.id, univ.name));
                }
                universityList.setModel(modelUniversite);
                formationList.setModel(new DefaultListModel());
                for(ListSelectionListener el : universityList.getListSelectionListeners()){
                    universityList.removeListSelectionListener(el);
                }
                universityList.addListSelectionListener(new UniversiteListListener());
            }
        }
        
    }
    
    class UniversiteListListener implements ListSelectionListener {

        private String lastMember = null;
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(!lse.getValueIsAdjusting()){
                String str = ((IDValue) universityList.getModel().getElementAt(lse.getFirstIndex())).ID;
                String str2 = ((IDValue) universityList.getModel().getElementAt(lse.getLastIndex())).ID;
                if(str == null ? lastMember != null : !str.equals(lastMember)){
                    lastMember = str;
                } else {
                    lastMember = str2;
                }
                DefaultListModel<IDValue> modelFormation = new DefaultListModel<>();
                formationList.setSelectedIndex(-1);
                for(DiplomeDetail form : Etudiant.getInstance().getFormationsList(lastMember)){
                    modelFormation.addElement(new IDValue(Integer.toString(form.id), form.libelle));
                }
                formationList.setModel(modelFormation);
            }
        }
        
    }
    
    public void makeChoice(CandidatureDetail voeu, EtatVoeu choix){
        Etudiant.getInstance().faireVoeu(voeu, choix);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootTabPane = new javax.swing.JTabbedPane();
        scrollPane = new javax.swing.JScrollPane();
        seeChoices = new javax.swing.JPanel();
        createVoeu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rectoratList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        universityList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        formationList = new javax.swing.JList();
        addChoice = new javax.swing.JButton();
        comboClassement = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ineField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomField = new javax.swing.JLabel();
        prenomField = new javax.swing.JLabel();
        adresseField = new javax.swing.JLabel();
        universiteField = new javax.swing.JLabel();
        licenseField = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setPreferredSize(new java.awt.Dimension(900, 650));

        rootTabPane.setMaximumSize(new java.awt.Dimension(900, 650));
        rootTabPane.setMinimumSize(new java.awt.Dimension(900, 650));

        seeChoices.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        seeChoices.setMaximumSize(new java.awt.Dimension(845, 533));
        seeChoices.setMinimumSize(new java.awt.Dimension(845, 533));
        seeChoices.setLayout(new javax.swing.BoxLayout(seeChoices, javax.swing.BoxLayout.Y_AXIS));
        scrollPane.setViewportView(seeChoices);

        rootTabPane.addTab("Voir ses voeux", scrollPane);

        rectoratList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rectoratList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(rectoratList);

        universityList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        universityList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(universityList);

        formationList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        formationList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(formationList);

        addChoice.setText("Ajouter le voeu");
        addChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChoiceActionPerformed(evt);
            }
        });

        jLabel2.setText("Classement");

        javax.swing.GroupLayout createVoeuLayout = new javax.swing.GroupLayout(createVoeu);
        createVoeu.setLayout(createVoeuLayout);
        createVoeuLayout.setHorizontalGroup(
            createVoeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createVoeuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createVoeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createVoeuLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(createVoeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createVoeuLayout.createSequentialGroup()
                                .addComponent(comboClassement, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createVoeuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addChoice)))
                .addContainerGap())
        );
        createVoeuLayout.setVerticalGroup(
            createVoeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createVoeuLayout.createSequentialGroup()
                .addGroup(createVoeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createVoeuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(createVoeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(createVoeuLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboClassement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(addChoice)
                .addContainerGap())
        );

        rootTabPane.addTab("Ajouter un voeu", createVoeu);

        jLabel1.setText("INE:");

        ineField.setText("jLabel2");

        jLabel3.setText("Nom:");

        jLabel4.setText("Prénom:");

        jLabel5.setText("Adresse:");

        jLabel6.setText("Université:");

        jLabel7.setText("License:");

        nomField.setText("jLabel8");

        prenomField.setText("jLabel9");

        adresseField.setText("jLabel10");

        universiteField.setText("jLabel11");

        licenseField.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rootTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ineField, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(nomField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prenomField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(adresseField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(licenseField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(universiteField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ineField)
                    .addComponent(jLabel5)
                    .addComponent(adresseField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(nomField)
                    .addComponent(universiteField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(prenomField)
                    .addComponent(licenseField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rootTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChoiceActionPerformed
        IDValue rectorat = (IDValue) rectoratList.getSelectedValue();
        IDValue university = (IDValue) universityList.getSelectedValue();
        IDValue formation = (IDValue) formationList.getSelectedValue();
        int classement = (int) comboClassement.getSelectedItem();
        Etudiant.getInstance().ajoutVoeu(Integer.parseInt(formation.ID), university.ID, rectorat.ID, classement);
        this.formationList.setModel(new DefaultListModel());
        for(ListSelectionListener el : universityList.getListSelectionListeners()){
            universityList.removeListSelectionListener(el);
        }
        this.universityList.setModel(new DefaultListModel());
        this.rectoratList.setSelectedIndex(0);
        this.refreshVoeuxAffiches();
    }//GEN-LAST:event_addChoiceActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addChoice;
    private javax.swing.JLabel adresseField;
    private javax.swing.JComboBox comboClassement;
    private javax.swing.JPanel createVoeu;
    private javax.swing.JList formationList;
    private javax.swing.JLabel ineField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel licenseField;
    private javax.swing.JLabel nomField;
    private javax.swing.JLabel prenomField;
    private javax.swing.JList rectoratList;
    private javax.swing.JTabbedPane rootTabPane;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel seeChoices;
    private javax.swing.JLabel universiteField;
    private javax.swing.JList universityList;
    // End of variables declaration//GEN-END:variables
}
