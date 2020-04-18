/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package utilisateurs;

import java.util.Hashtable;

public class VerificateurMotDePasse {
    
    static Hashtable<String, String> logins = new Hashtable<String, String>();
    
    static 
    {
        logins.put("sam", "333");
        logins.put("fab", "444");
        logins.put("kev", "555");
        logins.put("loi", "666");
    }
    
    public VerificateurMotDePasse()
    {}
    
    public boolean TryLogin(String user, String pass) throws LoginException
    {
        //if(logins.containsKey(user)); user inexistant
        if(user.length() < 1 || logins.get(user).compareTo(pass) != 0)
            {
                throw new LoginException();
            }
        else return true;
    }
    
    public boolean DoesUserExist(String user)
    {
        return logins.contains(user);
    }
    
    public boolean AddUser(String user, String pwd)
    {
        if(!DoesUserExist(user))
        {
            logins.put(user, pwd);
            return true;
        }
        else
            return false;
    }
}
