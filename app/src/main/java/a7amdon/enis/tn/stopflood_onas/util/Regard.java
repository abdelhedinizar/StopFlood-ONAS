package a7amdon.enis.tn.stopflood_onas.util;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class Regard {
    private String GSM_number;  //c'est l'id du regard
    private Street street;
    private Boolean OK;

    public Regard(String GSM_number, Street street, Boolean OK) {
        this.GSM_number = GSM_number;
        this.street = street;
        this.OK = OK;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getGSM_number() {
        return GSM_number;
    }

    public void setGSM_number(String GSM_number) {
        this.GSM_number = GSM_number;
    }

    public Boolean getOK() {
        return OK;
    }

    public void setOK(Boolean OK) {
        this.OK = OK;
    }
}
