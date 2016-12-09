package a7amdon.enis.tn.stopflood_onas.util;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class Delegation {
    private String id;
    private String name;
    private double populationByThousands;
    private Gouvernerat gouvernerat;


    public Delegation(String id,String name, double populationByThousands, Gouvernerat gouvernerat) {
        this.name = name;
        this.id = id;
        this.populationByThousands = populationByThousands;
        this.gouvernerat = gouvernerat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulationByThousands() {
        return populationByThousands;
    }

    public void setPopulationByThousands(double populationByThousands) {
        this.populationByThousands = populationByThousands;
    }

    public Gouvernerat getGouvernerat() {
        return gouvernerat;
    }

    public void setGouvernerat(Gouvernerat gouvernerat) {
        this.gouvernerat = gouvernerat;
    }
}
