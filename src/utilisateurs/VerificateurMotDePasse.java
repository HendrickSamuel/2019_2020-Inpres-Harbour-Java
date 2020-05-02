/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package utilisateurs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Properties;

public final class VerificateurMotDePasse {
        
    private Properties login;
    
    public VerificateurMotDePasse()
    {
        login = new Properties();
        Load();
        
        Save();
        //AddUser("sam","333");
    }
    
    public void Save()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        try (OutputStream output = new FileOutputStream(rep+sep+"logins.properties")) {            
            login.store(output,null);
        } catch (IOException io) {
            System.out.println("Erreur de sauvegarder "+io.getMessage());
        }
    }
    
    public void Load()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        //login = new Properties();
        try (InputStream input = new FileInputStream(rep+sep+"logins.properties")) {            
            login.load(input);
        } catch (IOException io) {
            System.out.println("chargement de fichier problematique "+io.getMessage());
        }
    }
    
    public boolean TryLogin(String user, String pass) throws LoginException
    {
        //if(logins.containsKey(user)); user inexistant
        if(user.length() < 1 || login.getProperty(user).compareTo(pass) != 0)
            {
                throw new LoginException();
            }
        else return true;
    }
    
    public boolean DoesUserExist(String user)
    {
        return login.containsKey(user);
    }
    
    public boolean AddUser(String user, String pwd)
    {
        if(!DoesUserExist(user))
        {
            login.setProperty(user, pwd);
            Save();
            return true;
        }
        else
            return false;
    }
}
