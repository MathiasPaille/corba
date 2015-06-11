package etudiant;

import javax.swing.JFrame;

/**
 *
 * @author Yvan
 */
public class Etudiant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EtudiantChoice panel = new EtudiantChoice();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setVisible(true);
    }
    
    
}
