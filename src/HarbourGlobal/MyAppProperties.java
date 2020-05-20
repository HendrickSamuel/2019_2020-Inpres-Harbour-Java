/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 19/05/2020                        */
/******************************************************/
package HarbourGlobal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class MyAppProperties {
    
    private Properties _properties;
    
    public MyAppProperties()
    {
        _properties = new Properties();
        Load();
        
        //AddUser("sam","333");
    }
    
    public void Save()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        try (OutputStream output = new FileOutputStream(rep+sep+"config.properties")) {            
            _properties.store(output,null);
        } catch (IOException io) {
            System.out.println("Erreur de sauvegarder "+io.getMessage());
        }
    }
    
    public void Load()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        try (InputStream input = new FileInputStream(rep+sep+"config.properties")) {            
            _properties.load(input);
        } catch (IOException io) {
            // si fichier non trouvé 
            this.setPropertie(PropertiesEnum.PortDepart, "50001");
            this.setPropertie(PropertiesEnum.PortArrive, "50000");
            this.setPropertie(PropertiesEnum.ReferencesSimulation, "7");
            this.setPropertie(PropertiesEnum.TempsSommeil, "7");

            this.setPropertie(PropertiesEnum.FileAmarrages, "amarrages.data");
            this.setPropertie(PropertiesEnum.FileBateauxAttente, "bateaux.data");
            this.setPropertie(PropertiesEnum.FileLogCapitainerie, "capitainerie.log");
            this.setPropertie(PropertiesEnum.FileLogPhare, "phare.log");
            this.setPropertie(PropertiesEnum.Locale, "FR,fr");
            this.setPropertie(PropertiesEnum.FormatDate, "1");
            this.setPropertie(PropertiesEnum.FormatHeure, "1");
            
            this.Save();
        }
    }
    
    public String getPropertie(PropertiesEnum prop)
    {
        if(_properties.containsKey(prop.toString()))
            return _properties.getProperty(prop.toString());
        else
            return "";
    }
    
    public void setPropertie(PropertiesEnum prop, String val)
    {
        _properties.setProperty(prop.toString(), val);
    }
}
