import java.util.*;

public class Groupe {
    private String id;
    private Map<Etudiant,Formation> grp;

    public Groupe(String id){
        this.id = id;
        grp = new HashMap<Etudiant, Formation>();
    }

    public void addEtu(Etudiant etu){
        if(this.grp.containsValue(etu.getForm())){
            if(!this.grp.containsKey(etu)) {
                this.grp.put(etu, etu.getForm());
            }
        } else {
            this.grp.put(etu, etu.getForm());
        }
    }

    public void supEt(Etudiant etu){
        if(this.grp.containsKey(etu)){
            this.grp.remove(etu);
        }
    }
}
