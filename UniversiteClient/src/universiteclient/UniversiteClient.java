package universiteclient;

import gestionVoeu.CandidatureDetail;
import gestionVoeu.DiplomeDetail;
import gestionVoeu.EtatDecision;
import gestionVoeu.EtatInscription;
import gestionVoeu.EtatVoeu;
import gestionVoeu.Ministere;
import gestionVoeu.MinistereHelper;
import gestionVoeu.Phase;
import gestionVoeu.Rectorat;
import gestionVoeu.RectoratDetail;
import gestionVoeu.RectoratHelper;
import gestionVoeu.Universite;
import gestionVoeu.UniversiteDetail;
import gestionVoeu.UniversiteHelper;
import gestionVoeu.diplomeInconnu;
import gestionVoeu.malformedInformation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.DistantObjectManager;
import tools.MandantDialog;

/**
 *
 * @author Yvan
 */
public class UniversiteClient {

    private static final UniversiteClient INSTANCE = new UniversiteClient();
    
    private String mandantRectorat;
    private String universiteMandant;
    private DiplomeDetail[] diplomes;
    private Ministere ministere;
    private Universite universite;
    private Rectorat rectorat;
    
    private UniversiteClient(){
        this.universiteMandant = MandantDialog.getMandant("ID de l'université");
        this.mandantRectorat = MandantDialog.getMandant("ID du rectorat");
        this.universite = UniversiteHelper.narrow(DistantObjectManager.getInstance().getReference(universiteMandant));
        this.ministere = MinistereHelper.narrow(DistantObjectManager.getInstance().getReference("Ministere"));
        this.rectorat = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(mandantRectorat));
        this.diplomes = ministere.getListDiplomes();
    }
    
    public static UniversiteClient getInstance(){
        return INSTANCE;
    }

    public String getRectoratMandant() {
        return mandantRectorat;
    }
    
    public String getUniversitetMandant() {
        return universiteMandant;
    }
    
    public String getUniversiteLibelle(){
        UniversiteDetail[] uds = this.rectorat.recupererUniversites();
        for(UniversiteDetail ud : uds){
            if(ud.id.equals(universiteMandant)){
                return ud.name;
            }
        }
        return "Université inconnue";
    }
    
    public String getRectoratLibelle() {
        RectoratDetail[] rds = ministere.getListRectorats();
        for(RectoratDetail rd : rds){
            if(rd.id.equals(mandantRectorat)){
                return rd.name;
            }
        }
        return "Rectorat inconnu";
    }
    
    public DiplomeDetail[] getFormationsList(){
        int[] diplomesReal = this.universite.getAffiliations();
        DiplomeDetail[] diplomesRecu = new DiplomeDetail[diplomesReal.length];
        for(int i = 0; i < diplomesReal.length; i++){
            for(DiplomeDetail d : this.diplomes){
                if(d.id == diplomesReal[i]) diplomesRecu[i] = d;
            }
        }
        return diplomesRecu;
    }
    
    public CandidatureDetail[] getVoeux(int master){
        ArrayList<CandidatureDetail> listeTot = new ArrayList<>();
        RectoratDetail[] rds = ministere.getListRectorats();
        for(RectoratDetail rd : rds){
            try {
                Rectorat r = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(rd.id));
                CandidatureDetail[] cds = r.recupererVoeuxMaster(this.universiteMandant, master);
                listeTot.addAll(Arrays.asList(cds));
            } catch (diplomeInconnu ex) {
                Logger.getLogger(UniversiteClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CandidatureDetail[] cdTotal = new CandidatureDetail[listeTot.size()];
        for(int i = 0; i < listeTot.size(); i++){
            cdTotal[i] = listeTot.get(i);
        }
        return cdTotal;
    }
    
    public Phase getPhase(){
        return this.ministere.getPhase();
    }
    
    public void choixCandidature(CandidatureDetail cd, EtatDecision ed){
        Rectorat r = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(cd.voeuxDetail.etu.rectorat_ref));
        try {
            r.modifierCandidatureEtat(cd, cd.etatVoeu, ed, cd.etatInscription);
        } catch (malformedInformation ex) {
            Logger.getLogger(UniversiteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cloreCandidature(CandidatureDetail cd){
        Rectorat r = RectoratHelper.narrow(DistantObjectManager.getInstance().getReference(cd.voeuxDetail.etu.rectorat_ref));
        try {
            if(!cd.etatVoeu.equals(EtatVoeu.OUI_DEFINITIF)) r.modifierCandidatureEtat(cd, cd.etatVoeu, EtatDecision.REFUSE, EtatInscription.CLOTURE);
            else r.modifierCandidatureEtat(cd, cd.etatVoeu, cd.etatDecision, EtatInscription.CLOTURE);
        } catch (malformedInformation ex) {
            Logger.getLogger(UniversiteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UniversiteChoice universiteChoice = new UniversiteChoice();
    }
    
}
