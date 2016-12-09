package a7amdon.enis.tn.stopflood_onas.util;

import java.util.Date;

/**
 * Created by 7amdon on 26/10/2016.
 */

//cette classe pour créer une notification car on nécessite coté onas
    //de faire une pile/file des notifications à gérer chaque fois

public class Notification {

    private String id;
    private int niveau;
    private Date date;
    private Regard regard;
    private Boolean fixed;

    public Notification(String id,Date date, Regard regard, Boolean fixed,int niveau) {
        this.id = id;
        this.date = date;
        this.regard = regard;
        this.fixed = fixed;
        this.niveau = niveau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public Regard getRegard() {
        return regard;
    }

    public void setRegard(Regard regard) {
        this.regard = regard;
    }
}
