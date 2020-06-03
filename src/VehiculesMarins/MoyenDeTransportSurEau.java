/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

import HarbourGlobal.MyAppProperties;
import HarbourGlobal.PropertiesEnum;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import HarbourGlobal.GestionLocale;
import static HarbourGlobal.PropertiesEnum.Locale;
import java.util.Locale;

public abstract class MoyenDeTransportSurEau extends MoyenDeTransport implements Serializable
{
    protected boolean _submersible;
    protected Date _dateArrivee;
    protected Date _dateDepart;
    
    
    public MoyenDeTransportSurEau(boolean doesFloat, Energie energie)
    {
        super(energie);
        setSubmersible(!doesFloat);
    }
    
    public void setSubmersible(boolean sub)
    {
        _submersible = sub;
    }
    
    public boolean IsSubmersible()
    {
        return _submersible;
    }
    
    public void SetDateArrivee(Date date)
    {
        _dateArrivee = date;
    }
    
    public String GetDateArrivee()
    {
        if(_dateArrivee != null)
        {
            MyAppProperties map = new MyAppProperties(); // afin de pouvoir modifier en runtime

            Locale fuseau = GestionLocale.stringToLocale(map.getPropertie(PropertiesEnum.Locale));

            int formatDate = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatDate));
            int formatHeure = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatHeure));

            return DateFormat.getDateTimeInstance(formatDate, formatHeure, fuseau).format(_dateArrivee);
        }
        else
            return "Amarrage en cours de validation";
    }
}
