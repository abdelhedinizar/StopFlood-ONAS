package a7amdon.enis.tn.stopflood_onas.util;

/**
 * Created by 7amdon on 26/10/2016.
 */

public class Intervention {
    private String id;
    private Regard regard;
    private Boolean done;

    public Intervention(String id, Regard regard, Boolean done) {
        this.id = id;
        this.regard = regard;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Regard getRegard() {
        return regard;
    }

    public void setRegard(Regard regard) {
        this.regard = regard;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
