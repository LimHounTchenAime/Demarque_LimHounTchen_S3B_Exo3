import java.util.*;

public class Groupe {
    private String id;
    private Map<Etudiant,Formation> grp;

    public Groupe(String id){
        this.id = id;
        grp = new HashMap<Etudiant, Formation>();
    }

    public void addEtu(Etudiant etu){
        if(!this.grp.isEmpty()){
            if(this.grp.containsValue(etu.getForm())) {
                if (!this.grp.containsKey(etu)) {
                    this.grp.put(etu, etu.getForm());
                }
            }
        } else {
            this.grp.put(etu, etu.getForm());
        }
    }

    public void supEtu(Etudiant etu){
        if(this.grp.containsKey(etu)){
            this.grp.remove(etu);
        }
    }

    public double calcMoy(String mat){
        double moy = 0.0;
        for(Etudiant e: this.grp.keySet()){
            moy+=e.calcMoyMat(mat);
        }
        return moy/this.grp.size();
    }

    public double calcMoyGen(){
        double moy = 0.0;
        for(Etudiant e: this.grp.keySet()){
            moy+=e.calcMoyGen();
        }
        return moy/this.grp.size();
    }
    //System.out.println((((17.0*2.0)+(13.0*2.0)+(15.0*5.0)+(16.0*5.0))/(2.0+2.0+5.0+5.0)));

    public Map getGrp(){
        return this.grp;
    }
}
