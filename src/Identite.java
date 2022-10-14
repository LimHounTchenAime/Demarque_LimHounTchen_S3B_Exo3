public class Identite {
    private String NIP,nom,prenom;

    public Identite(String nip, String n,String p){
        this.NIP = nip;
        this.nom = n;
        this.prenom = p;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }
}
