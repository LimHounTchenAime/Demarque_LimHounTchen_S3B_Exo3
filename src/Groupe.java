import java.util.*;

public class Groupe {
    private String id;
    private Map<Etudiant, Formation> grp;

    public Groupe(String id) {
        this.id = id;
        grp = new HashMap<Etudiant, Formation>();
    }

    public void addEtu(Etudiant etu) {
        if (!this.grp.isEmpty()) {
            if (this.grp.containsValue(etu.getForm())) {
                if (!this.grp.containsKey(etu)) {
                    this.grp.put(etu, etu.getForm());
                }
            }
        } else {
            this.grp.put(etu, etu.getForm());
        }
    }

    public void supEtu(Etudiant etu) {
        if (this.grp.containsKey(etu)) {
            this.grp.remove(etu);
        }
    }

    public double calcMoy(String mat) {
        double moy = 0.0;
        for (Etudiant e : this.grp.keySet()) {
            moy += e.calcMoyMat(mat);
        }
        return moy / this.grp.size();
    }

    public double calcMoyGen() {
        double moy = 0.0;
        for (Etudiant e : this.grp.keySet()) {
            moy += e.calcMoyGen();
        }
        return moy / this.grp.size();
    }

    public Map getGrp() {
        return this.grp;
    }

    public void triAlpha() {
        this.grp=new TreeMap<Etudiant, Formation>(this.grp);
    }

    public void triAntiAlpha(){
        Map<Etudiant, Formation> tmp=new TreeMap<Etudiant, Formation>(Collections.reverseOrder());
        tmp.putAll(this.grp);
        this.grp=tmp;
    }

    public String toString(){
        String r=id+"\n\n";
        for(Etudiant etudiant:this.grp.keySet())
            r+=etudiant.getId().getNom()+" "+etudiant.getId().getPrenom()+"\n"+this.grp.get(etudiant)+"\n";
        return r;
    }

    public void triParMerite(){
        Map<Etudiant, Double> moyennes=new TreeMap<Etudiant, Double>();
        for(Etudiant etudiant:this.grp.keySet()){
            moyennes.put(etudiant, etudiant.calcMoyGen());
        }

        Map<Etudiant, Formation> map=new TreeMap<Etudiant, Formation>();
        for(Etudiant etudiant:moyennes.keySet()){
            map.put(etudiant, etudiant.getForm());
        }
        this.grp=map;
    }
}
