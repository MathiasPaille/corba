package tools;

/**
 *
 * @author Yvan
 */
public enum Databases {
    MINISTERE("ministere"),
    RECTORAT("rectorat"),
    UNIVERSITE("universite");
   
    private String value;
    
    //constructeur
    Databases(String v){
        this.value = v;
    }
    
    public String getValue(){
        return value;
    }
    
}
