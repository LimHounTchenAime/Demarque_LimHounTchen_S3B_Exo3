import java.text.Normalizer;
import java.util.*;

public class Etudiant implements Comparable<Etudiant>{
    private Identite id;
    private Formation form;
    private Map<String, Set<Double>> resultats;

    public Etudiant(Identite i, Formation f){
        this.id = i;
        this.form = f;
        Set<Double> s = new HashSet<Double>();
        this.resultats = new HashMap<String, Set<Double>>();
        for (String str: this.form.mat.keySet()) {
            this.resultats.put(str,s);
        }
    }

    public void addNote(String mat, Double note){
        if (this.resultats.containsKey(mat)){
            if(note>=0 && note<=20){
                Set<Double> s = new HashSet<Double>();
                for(Double elem:this.resultats.get(mat)){
                    s.add(elem);
                }
                s.add(note);
                this.resultats.put(mat,s);
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
        double moys = 0.0;
        double denom = 0.0;
        for(String s: this.resultats.keySet()){
            moys += calcMoyMat(s)*this.form.getCoeff(s);
            denom += this.form.getCoeff(s);
        }
        return moys/denom;
    }

    public Formation getForm(){
        return this.form;
    }

    public String toString(){
        String r="";
        Iterator<String> iteratorMatiere=this.form.mat.keySet().iterator();
        while(iteratorMatiere.hasNext()){
            String matiere=iteratorMatiere.next();
            r+=matiere+":\n";
            Iterator<Double> iteratorNote = this.resultats.get(matiere).iterator();
            while (iteratorNote.hasNext())
                r += "\t" + iteratorNote.next() + "\n";
        }
        return r;
    }

    public Identite getId(){
        return id;
    }
    @Override
    public int compareTo(Etudiant o) {
        return this.id.getNom().compareTo(o.id.getNom());
    }
}
