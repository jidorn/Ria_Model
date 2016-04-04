package fr.afcepf.al26.ria.exception;

/**
 * Created by Stagiaire on 16/03/2016.
 */
public class DisneyException extends Exception {
    private CodeErreur erreur = CodeErreur.CA_MARCHE_PAS;
    public enum CodeErreur {
        CA_MARCHE_PAS,
        ERREUR_LORS_DE_AJOUT,
        NE_PEUT_ETRE_SUPPRIME_LES_ENFANT_AIMENT_TROP
    }

    public DisneyException(CodeErreur paramErreur) {
        erreur = paramErreur;
    }

    public DisneyException(String message, CodeErreur paramErreur) {
        super(message);
        erreur = paramErreur;
    }

    public CodeErreur getErreur() {
        return erreur;
    }

    public void setErreur(CodeErreur paramErreur) {
        erreur = paramErreur;
    }
}
