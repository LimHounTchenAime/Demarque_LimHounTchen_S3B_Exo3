import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Formation {
    public String identifiant;
    public HashMap<String, Double> mat;

    public Formation(){
        this.mat=new HashMap<String, Double>();
    }
    public void addMat(String nom, double coeff){
        if(!this.mat.containsKey(nom))
          this.mat.put(nom, coeff);
        else throw new Error("Impossible d'ajouter une matiere deja existante");
    }

    public void supMat(String nom){
        if(this.mat.containsKey(nom))
            this.mat.remove(nom);
        else throw new Error("La matiere n'existe pas");
    }

    public double getCoeff(String nom){
        if(this.mat.containsKey(nom))
            return this.mat.get(nom);
        throw new Error("Nom de matiere inexistant");
    }

    public String toString(){
        String r="";
        Set<String> keys=mat.keySet();
        for(String elem:keys){
            r+=elem+" "+mat.get(elem)+"\n";
        }
        return r;
    }
}