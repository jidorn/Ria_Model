package fr.afcepf.al26.ria.data;

import fr.afcepf.al26.ria.entities.Personnage;
import fr.afcepf.al26.ria.exception.DisneyException;

import java.util.List;

/**
 * Created by Stagiaire on 16/03/2016.
 */
public interface IDaoPersonnage {
    Personnage ajouter(Personnage paramPersonnage) throws DisneyException;
    List<Personnage> rechercher(String paramDessinAnime);
    void supprimer(Personnage paramPersonnage);
}
