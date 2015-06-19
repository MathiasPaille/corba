package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Yvan
 */
public class ConverterArrayCORBA {
    
    public static ArrayList<Object> fromArrayToList(Object[] a){
        return new ArrayList<>(Arrays.asList(a));
    }
    
    public static Class<?>[] fromListToArray(List<Class<?>> l){
        Class<?>[] t = new Class<?>[l.size()];
        for(int i = 0; i < l.size(); i++){
            t[i] = l.get(i);
        }
        return t;
    }
    
    /* pour transformer un array en tableau
    */
//    public static Object[] ToTableau(ArrayList<?> array)
//    {
//        Object[] tab = new Object[array.size()];
//        for (int i = 0; i < array.size();i++)
//        {
//            tab[i] = array.get(i);
//        }
//        return tab;
//    }
//    
}
