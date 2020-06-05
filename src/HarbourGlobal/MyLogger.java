/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package HarbourGlobal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger {
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private DateFormat _formatDate = new SimpleDateFormat("dd/MM/YYYY - HH:mm:ss");
    private String _fileDest;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public MyLogger() {
        this("logs");
    }
    /*------------------------------------------*/
    public MyLogger(String text) {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        String fichier = rep + sep + text;
        _fileDest = fichier;

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methodes">
    // Date de maintenant en string
    public String Now() {
        Date date = new Date();
        return _formatDate.format(date);
    }
    /*------------------------------------------*/
    // Ecrit sur le fichier log
    public void Write(String ligne) {
        try {
            // True de FileWriter = append
            FileWriter f = new FileWriter(_fileDest, true);
            BufferedWriter bf = new BufferedWriter(f);
            bf.write("[" + this.Now() + "] : " + ligne);
            System.out.println("[" + this.Now() + "] : " + ligne);
            bf.newLine();
            bf.close();
        } catch (IOException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
    /*------------------------------------------*/
    // Ecrit sur le fichier log
    public void Write(String entete, String info) {
        Write(entete + "> " + info);
    }
    /*------------------------------------------*/
    // Lis le fichier log (entier)
    public String ReadAll() {
        try {
            String all = "";
            BufferedReader fin = new BufferedReader(new FileReader(_fileDest));
            String line;
            while ((line = fin.readLine()) != null) {
                all += line + System.getProperty("line.separator");
                //System.out.println(line);           
            }
            return all;
        } catch (FileNotFoundException e) {
            System.out.println("Erreur: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        return "";
    }
    //</editor-fold>
}