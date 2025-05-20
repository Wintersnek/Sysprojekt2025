package SDGSweden;

import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author nicklas
 */
public class SDGSweden {
    
    private static InfDB idb;
    
    public static void main(String[] args)
    {
        try{
            idb = new InfDB("SDGSweden", "3306", "dbAdmin2024", "dbAdmin2024PW");
            //new Inloggning(idb).setVisible(true);
            System.out.println("funkar");
        } catch (InfException ex){
            System.out.println(ex.getMessage());
        }
    }
}
