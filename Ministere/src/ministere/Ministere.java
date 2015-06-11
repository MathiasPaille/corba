package ministere;

import java.util.TreeMap;

/**
 *
 * @author Yvan
 */
public class Ministere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeMap<String, String> dp = MinistereBase.getInstance().getDiplomes();
        for(int i = 0; i < dp.size(); i++){
            System.out.println("Clé: " + dp.keySet().toArray()[i] + " - Valeur : " + dp.entrySet().toArray()[i]);
        }
    }

}
