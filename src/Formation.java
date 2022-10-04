import java.util.HashMap;

public class Formation {
    public String identifiant;
    public HashMap<String, Double> mat;

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
}
