/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package HarbourGlobal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger
{
    private DateFormat _formatDate = new SimpleDateFormat("HH:mm:ss");
    
    public MyLogger()
    {
        
    }
    
    public String Now()
    {
        Date date = new Date();
        return _formatDate.format(date);
    }
}

