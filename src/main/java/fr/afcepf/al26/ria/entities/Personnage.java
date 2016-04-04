package fr.afcepf.al26.ria.entities;

import java.util.Date;

/**
 * Created by Stagiaire on 16/03/2016.
 */
public class Personnage {
    private Integer id;
    private String nom;
    private String espece;
    private String dessinAnime;
    private Date dateNaissance;

    public Personnage() {
    }

    public Personnage(Integer paramId, String paramNom, String paramEspece, String paramDessinAnime, Date paramDateNaissance) {
        id = paramId;
        nom = paramNom;
        espece = paramEspece;
        dessinAnime = paramDessinAnime;
        dateNaissance = paramDateNaissance;
    }

    public Personnage(String paramNom, String paramEspece, String paramDessinAnime, Date paramDateNaissance) {
        nom = paramNom;
        espece = paramEspece;
        dessinAnime = paramDessinAnime;
        dateNaissance = paramDateNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date paramDateNaissance) {
        dateNaissance = paramDateNaissance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer paramId) {
        id = paramId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String paramNom) {
        nom = paramNom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String paramEspece) {
        espece = paramEspece;
    }

    public String getDessinAnime() {
        return dessinAnime;
    }

    public void setDessinAnime(String paramDessinAnime) {
        dessinAnime = paramDessinAnime;
    }

}
