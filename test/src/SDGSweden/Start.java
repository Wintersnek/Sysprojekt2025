package SDGSweden;

import oru.inf.InfDB;
import oru.inf.InfException;

public class Start {

    private static InfDB idb;

    public static void main(String[] args) {
        try {
            idb = new InfDB("SDGSweden", "3306", "dbAdmin2024", "dbAdmin2024PW");

        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        new Inloggning(idb).setVisible(true);
    }
}
