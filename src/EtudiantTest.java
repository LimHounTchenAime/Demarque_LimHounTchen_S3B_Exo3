import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    Etudiant etudiant;
    Formation formation;

    @BeforeEach
    public void init(){
        formation=new Formation("f1");
        formation.addMat("maths", 2);
        formation.addMat("histoire", 1);
        etudiant=new Etudiant(new Identite("nip", "nom", "prenom"), formation);
    }

    @Test
    public void testAddNote(){
        etudiant.addNote("maths", 20.0);
        assertEquals("histoire:\n"+
                "maths:\n" +
                "\t20.0\n", etudiant);

        etudiant.addNote("histoire", 16.0);
        etudiant.addNote("maths", 15.0);

        assertEquals("histoire:\n" +
                "\t16.0\n" +
                "maths:\n" +
                "\t20.0\n" +
                "\t15.0\n", etudiant);
    }
}