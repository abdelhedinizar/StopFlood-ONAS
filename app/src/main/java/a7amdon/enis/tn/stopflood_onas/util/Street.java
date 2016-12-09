package a7amdon.enis.tn.stopflood_onas.util;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class Street {
    private String id;
    private String name;
    private Delegation delegation;

    public Street(String id,String name, Delegation delegation) {
        this.id = id;
        this.name = name;
        this.delegation = delegation;
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

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }
}
