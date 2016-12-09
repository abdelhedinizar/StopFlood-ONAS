package a7amdon.enis.tn.stopflood_onas.util;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class Gouvernerat {
    private String id;
    private String name;
    private double populationByThousands;

    public Gouvernerat(String id,String name, double populationByThousands) {
        this.id = id;
        this.name = name;
        this.populationByThousands = populationByThousands;
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
}
