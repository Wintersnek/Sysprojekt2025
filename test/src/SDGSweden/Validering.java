/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SDGSweden;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Validering {
    
    private InfDB idb;
    
    public Validering(InfDB idb)
    {
        this.idb = idb;
        
    }
    public static boolean textFaltHarVarde(JTextField rutaAttKolla)
    {
        boolean resultat = true; 
        
        if(rutaAttKolla.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Inmatningsrutan är tom!");
            resultat = false;
        }
        
        return resultat;
    }
    
    public  static boolean datumArGiltigt(String datumStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            sdf.parse(datumStr);
            return true;
        } catch (ParseException e){
            JOptionPane.showMessageDialog(null, datumStr);
            JOptionPane.showMessageDialog(null, e);
            return false;
        }     
    }
    
    public static String hamtaRoll(InfDB idb, String aid) throws InfException {
        
        if (idb.fetchSingle("SELECT aid FROM admin WHERE aid = " + aid) != null) {
            return "admin";
        } if (idb.fetchSingle("SELECT aid FROM handlaggare WHERE aid = " + aid) != null) {
            
        String sqlProjekt = "SELECT COUNT(*) FROM projekt WHERE projektchef = " + aid;
        int antalProjekt = Integer.parseInt(idb.fetchSingle(sqlProjekt));
        if (antalProjekt > 0) {
            
            return "projektchef";
        }
        return "handläggare";
        }
        return "anställd";
    }
    
}
