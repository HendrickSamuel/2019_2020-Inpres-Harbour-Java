/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Equipage;

public class SailorWithoutIdentificationException extends Exception {

    /**
     * Creates a new instance of
     * <code>SailorWithoutIdentificationException</code> without detail message.
     */
    public SailorWithoutIdentificationException() {
    }

    /**
     * Constructs an instance of
     * <code>SailorWithoutIdentificationException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SailorWithoutIdentificationException(String msg) {
        super(msg);
    }
}
