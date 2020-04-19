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

