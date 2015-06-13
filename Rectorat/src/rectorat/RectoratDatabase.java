package rectorat;

import com.google.gson.Gson;
import gestionVoeu.CandidatureDetail;
import gestionVoeu.EtatDecision;
import gestionVoeu.EtatInscription;
import gestionVoeu.EtatVoeu;
import gestionVoeu.EtudiantDetail;
import gestionVoeu.MoyenObtention;
import gestionVoeu.Quartile;
import gestionVoeu.SemestreDetail;
import gestionVoeu.VoeuxDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Databases;
import tools.SQLConnexion;

/**
 *
 * @author Yvan
 */
public class RectoratDatabase extends SQLConnexion {

    private Gson gson = new Gson();
    private static final RectoratDatabase INSTANCE = new RectoratDatabase();

    public static RectoratDatabase getInstance() {
        return RectoratDatabase.INSTANCE;
    }

    private RectoratDatabase() {
        super(Databases.RECTORAT);
    }

    /**
     * Get un etudiant en fonction de son mandat (xd) et de son numéro étudiant
     *
     * @param mandant mandant correspondant au rectorat de de l'étudiant
     * @param etu_ine numéro ine de l'étudiant concerné par la requête
     * @return l'étudiant correspondant a son numéro ine
     */
    public EtudiantDetail getUnEtudiant(int mandant, String etu_ine) {
        EtudiantDetail e = null;
        try {
            ResultSet res = this.makeRequest("select * from etudiant where etudiant.mandant=" + mandant + " and etudiant.etu_ine=" + etu_ine);
            if (res != null) {
                while (res.next()) {
                    String res_etu_ine = res.getString("etu_ine");
                    String res_etu_nom = res.getString("etu_nom");
                    String res_etu_prenom = res.getString("etu_prenom");
                    String res_etu_adresse = res.getString("etu_adresse");
                    Integer res_etu_universite = res.getInt("etu_universite");
                    Integer res_etu_license = res.getInt("etu_license");
                    String res_etu_notes = res.getString("etu_notes");

                    semestreJson s = gson.fromJson(res_etu_notes, semestreJson.class);
                    //list est la liste des moyennes de semestres
                    SemestreDetail[] list = new SemestreDetail[6];
                    list[0] = s.getS1();
                    list[1] = s.getS2();
                    list[2] = s.getS3();
                    list[3] = s.getS4();
                    list[4] = s.getS5();
                    list[5] = s.getS6();

                    e = new EtudiantDetail(res_etu_ine, res_etu_nom, res_etu_prenom, res_etu_adresse, res_etu_universite, res_etu_license, list);
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RectoratDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    /**
     * Verification du password a la connexion d'un utilisateur
     *
     * @param mandant mandant correspondant au rectorat de de l'étudiant
     * @param etu_ine numéro ine de l'étudiant concerné par la requête
     * @param pwd password de l'utilisateur
     * @return si oui ou non, l'utilisateur peut se connecter. :)
     */
    public EtudiantDetail verifierPassword(int mandant, String etu_ine, String pwd) {
        EtudiantDetail e = new EtudiantDetail();
        String res_etu_pwd;
        res_etu_pwd = "";
        if (!pwd.isEmpty()) {
            if (!etu_ine.isEmpty()) {
                try {
                    ResultSet res = this.makeRequest("select password from etudiant where etudiant.mandant=" + mandant + " and etudiant.etu_ine=" + etu_ine);
                    if (res != null) {
                        while (res.next()) {
                            res_etu_pwd = res.getString("password");
                        }
                        res.close();
                    }
                    //SI LE MDP EST BON, MON BOOL SE MET A TRUE
                    if (res_etu_pwd.equals(pwd)) {
                        e = this.getUnEtudiant(mandant, etu_ine);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RectoratDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return e;
    }

    /**
     * Récupération d'une liste de candidature en fonction d'un numéro étudiant
     * @param mandat rectorat correspondant
     * @param voeux_ine numéro ine de l'étudiant
     * @return la liste de candidature de l'étudiant 
     */
    public CandidatureDetail[] recupererVoeuxEtudiant(int mandat, String voeux_ine) {
        CandidatureDetail[] cc = null;
        try {
            ResultSet res = this.makeRequest("select * from voeux where voeux.mandant=" + mandat + " and voeux.voeux_ine=" + voeux_ine);
            if (res != null) {
                int rowcount = 0;
                //récupération de la taille du resultSet
                if (res.last()) {
                    rowcount = res.getRow();
                    res.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
                }
                cc = new CandidatureDetail[rowcount];
                while (res.next()) {
                    Integer res_voe_master = res.getInt("voeux_master");
                    Integer res_voe_universite = res.getInt("voeux_universite");
                    Short res_voe_classement = res.getShort("voeux_classement");
                    Integer res_voe_inscription = res.getInt("voeux_inscription");
                    Integer res_voe_etat_voeu = res.getInt("voeux_etat_voeu");
                    Integer res_voe_decision = res.getInt("voeux_decision");

                    EtudiantDetail e = this.getUnEtudiant(mandat, voeux_ine);
                    VoeuxDetail v = new VoeuxDetail(res_voe_master, res_voe_universite, res_voe_classement, e);

                    cc[res.getRow() - 1] = new CandidatureDetail(v, EtatInscription.from_int(res_voe_inscription), EtatVoeu.from_int(res_voe_etat_voeu), EtatDecision.from_int(res_voe_decision));
                }
                res.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RectoratDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cc;
    }

    class semestreJson {

        class SemestreDetailJson {

            public int moyenne;
            public int quartile;
            public int moyenObtention;
            public int numSemestre;
        }

        public SemestreDetailJson s1;
        public SemestreDetailJson s2;
        public SemestreDetailJson s3;
        public SemestreDetailJson s4;
        public SemestreDetailJson s5;
        public SemestreDetailJson s6;

        public SemestreDetail getS1() {
            return new SemestreDetail(s1.moyenne, Quartile.from_int(s1.quartile), MoyenObtention.from_int(s1.moyenObtention), s1.numSemestre);
        }

        public SemestreDetail getS2() {
            return new SemestreDetail(s2.moyenne, Quartile.from_int(s2.quartile), MoyenObtention.from_int(s2.moyenObtention), s2.numSemestre);
        }

        public SemestreDetail getS3() {
            return new SemestreDetail(s3.moyenne, Quartile.from_int(s3.quartile), MoyenObtention.from_int(s3.moyenObtention), s3.numSemestre);
        }

        public SemestreDetail getS4() {
            return new SemestreDetail(s4.moyenne, Quartile.from_int(s4.quartile), MoyenObtention.from_int(s4.moyenObtention), s4.numSemestre);
        }

        public SemestreDetail getS5() {
            return new SemestreDetail(s5.moyenne, Quartile.from_int(s5.quartile), MoyenObtention.from_int(s5.moyenObtention), s5.numSemestre);
        }

        public SemestreDetail getS6() {
            return new SemestreDetail(s6.moyenne, Quartile.from_int(s6.quartile), MoyenObtention.from_int(s6.moyenObtention), s6.numSemestre);
        }
    }
}
