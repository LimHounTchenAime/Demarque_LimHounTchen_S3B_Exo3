import java.util.HashMap;

public class Formation {
    public String identifiant;
    public HashMap<String, Integer> mat;

    public void addMat(String nom, int coeff){
        if(!this.mat.containsKey(nom))
          this.mat.put(nom, coeff);
        throw new Error("a faire");
    }

    public void supMat(String nom){
        if(this.mat.containsKey(nom))
            this.mat.remove(nom);
        throw new Error("a faire");
    }

    public float getCoeff(String nom){
        if(this.mat.containsKey(nom))
            return this.mat.get(nom);
        throw new Error("Nom de matiere inexistant");
    }
}
