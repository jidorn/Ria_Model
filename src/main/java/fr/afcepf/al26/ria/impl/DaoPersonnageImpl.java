package fr.afcepf.al26.ria.impl;

import fr.afcepf.al26.ria.data.IDaoPersonnage;
import fr.afcepf.al26.ria.entities.Personnage;
import fr.afcepf.al26.ria.exception.DisneyException;
import fr.afcepf.al26.ria.utils.RiaDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stagiaire on 16/03/2016.
 */
public class DaoPersonnageImpl implements IDaoPersonnage {
    private Logger log = Logger.getLogger(getClass());
    private Connection cnx;
    private DataSource ds = new RiaDataSource();

    @Override
    public Personnage ajouter(Personnage paramPersonnage) throws DisneyException {
        DisneyException de = null;
        try {
            cnx = ds.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO personnage(nom, date_naissance, espece, dessin_anime) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, paramPersonnage.getNom());
            pstmt.setDate(2, new Date(paramPersonnage.getDateNaissance().getTime()));
            pstmt.setString(3, paramPersonnage.getEspece());
            pstmt.setString(4, paramPersonnage.getDessinAnime());
            int nb = pstmt.executeUpdate();
            if (nb == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                paramPersonnage.setId(rs.getInt(1));
            }
        } catch (SQLException paramE) {
            de = new DisneyException("Erreur lors de ajout",DisneyException.CodeErreur.ERREUR_LORS_DE_AJOUT);
            paramE.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (SQLException paramE) {
                de = new DisneyException("Erreur lors de ajout",DisneyException.CodeErreur.CA_MARCHE_PAS);
                paramE.printStackTrace();
            }
        }
        return paramPersonnage;
    }

    @Override
    public List<Personnage> rechercher(String paramDessinAnime) {
        DisneyException de = null;
        List<Personnage> personnageList = new ArrayList<>();
        try {
            cnx = ds.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement("SELECT*FROM personnage WHERE dessin_anime like ?");
            pstmt.setString(1,"%" + paramDessinAnime + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                personnageList.add(rsToPersonnage(rs));
            }
        } catch (SQLException paramE) {
            log.info(paramE.getMessage());
            paramE.printStackTrace();
        }
        finally {
            try {
                cnx.close();
            } catch (SQLException paramE) {
                log.info(paramE.getMessage());
                paramE.printStackTrace();
            }
        }
        return personnageList;
    }

    @Override
    public void supprimer(Personnage paramPersonnage) {
        DisneyException ex = null;
        try {
            cnx = ds.getConnection();
            log.info("l'identifiant : "+paramPersonnage.getId());
            PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM personnage WHERE id = ?");
            pstmt.setInt(1,paramPersonnage.getId());
            int nbLigne = pstmt.executeUpdate();
            if (nbLigne==0){
                ex = new DisneyException("suppression ratée", DisneyException.CodeErreur.NE_PEUT_ETRE_SUPPRIME_LES_ENFANT_AIMENT_TROP);
            }
        } catch (SQLException paramE) {
            ex = new DisneyException("suppression ratée", DisneyException.CodeErreur.NE_PEUT_ETRE_SUPPRIME_LES_ENFANT_AIMENT_TROP);
            paramE.printStackTrace();
        }
        finally {
            try {
                cnx.close();
            } catch (SQLException paramE) {
                paramE.printStackTrace();
            }
        }
    }


    private Personnage rsToPersonnage(ResultSet paramRs) throws SQLException {
        return new Personnage(paramRs.getInt("id"),
                paramRs.getString("nom"),
                paramRs.getString("espece"),
                paramRs.getString("dessin_anime"),
                paramRs.getDate("date_naissance"));
    }
}
