import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {

    @Test
    void addEtu() {
        Formation form1 = new Formation("uneFormation");
        Formation form2 = new Formation("deuxFormation");
        Etudiant e1 = new Etudiant(new Identite("A01","Demarque", "Amaury"),form1);
        Etudiant e2 = new Etudiant(new Identite("LHT02","LimHounTchen","Aime"),form2);
        Groupe grp = new Groupe("MonGrp");

        grp.addEtu(e1);
        grp.addEtu(e2);

        assertTrue(grp.getGrp().containsKey(e1));
        assertFalse(grp.getGrp().containsKey(e2));
    }

    @Test
    void supEt() {
        Formation form1 = new Formation("uneFormation");
        Etudiant e1 = new Etudiant(new Identite("A01","Demarque", "Amaury"),form1);
        Etudiant e2 = new Etudiant(new Identite("LHT02","LimHounTchen","Aime"),form1);
        Groupe grp = new Groupe("MonGrp");

        grp.addEtu(e1);
        grp.addEtu(e2);

        grp.supEtu(e2);

        assertFalse(grp.getGrp().containsKey(e2));
    }

    @Test
    void calcMoy() {
        Formation form1 = new Formation("uneFormation");
        form1.addMat("Math", 2);
        Etudiant e1 = new Etudiant(new Identite("A01","Demarque", "Amaury"),form1);
        Etudiant e2 = new Etudiant(new Identite("LHT02","LimHounTchen","Aime"),form1);
        Groupe grp = new Groupe("MonGrp");

        e1.addNote("Math",17.0);
        e2.addNote("Math",13.0);

        grp.addEtu(e1);
        grp.addEtu(e2);

        assertEquals(15.0, grp.calcMoy("Math"));
    }

    @Test
    void calcMoyGen() {
        Formation form1 = new Formation("uneFormation");
        form1.addMat("Math", 2);
        form1.addMat("Java", 5);
        Etudiant e1 = new Etudiant(new Identite("A01","Demarque", "Amaury"),form1);
        Etudiant e2 = new Etudiant(new Identite("LHT02","LimHounTchen","Aime"),form1);
        Groupe grp = new Groupe("MonGrp");

        e1.addNote("Math",17.0);
        e1.addNote("Java", 15.0);
        e2.addNote("Java", 16.0);
        e2.addNote("Math",13.0);

        grp.addEtu(e1);
        grp.addEtu(e2);


        assertEquals(11.125, grp.calcMoyGen());
    }
}