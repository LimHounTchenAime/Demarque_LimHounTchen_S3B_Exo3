import java.util.*;

public class Etudiant {
    private Identite id;
    private Formation form;
    private Map<String, Set<Float>> resultats;

    public Etudiant(Identite i, Formation f){
        this.id = i;
        this.form = f;
        this.resultats = new HashMap<String, Set<Float>>();
//        for (this.form.mat.keySet():) {
//
//        }
//        resultats.keySet()
    }

    public void addNote(String mat, float note){

    }
}
