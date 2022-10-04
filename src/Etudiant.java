import java.util.*;

public class Etudiant {
    private Identite id;
    private Formation form;
    private Map<String, Set<Double>> resultats;

    public Etudiant(Identite i, Formation f){
        this.id = i;
        this.form = f;
        Set<Double> s = new HashSet<Double>();
        this.resultats = new HashMap<String, Set<Double>>();
//        for (String str: this.form.mat.keySet()) {
//            this.resultats.put(str,s);
//        }
    }

    public void addNote(String mat, double note){
        if (this.resultats.containsKey(mat)){
            if(note>=0 && note<20){
                this.resultats.get(mat).add(note);
                System.out.println("Note ajouté avec succes");
            } else {
                System.out.println("La note doit etre entre 0 et 20");
            }
        } else {
            System.out.println("La matiere selectionne n'existe pas dans la formation");
        }
    }

    public double calcMoyMat(String mat){
        double moy = 0.0;
        if(this.resultats.containsKey(mat)){
            for(double d: this.resultats.get(mat)){
                moy += d;
                moy /= this.resultats.get(mat).size();
            }
        } else {
            moy = -1.0;
        }
        return moy;
    }

    public double calcMoyGen(){
        Set<Double> moys = new HashSet<Double>();
//        for(String s: this.resultats.keySet()){
//            moys.add(calcMoyMat(s)*this.form.getCoeff(s));
//        }
        double gen = 0.0;
        for(double d: moys){
            gen += d;
        }
        return gen/moys.size();
    }
}
