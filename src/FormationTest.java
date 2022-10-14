import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {
    Formation f;
    @BeforeEach
    public void init(){
        f=new Formation("123");
        f.mat.put("histoire", 2.0);
    }

    @Test
    public void testAddMat(){
        f.addMat("geo", 2.5);
        assertEquals("geo 2.5\n" +
                "histoire 2.0\n", f.toString());
    }

    @Test
    public void testSupMat(){
        f.supMat("histoire");
        assertEquals("", f.toString());
    }

    @Test
    public void testGetCoeff(){
        assertEquals(2.0, f.getCoeff("histoire"));
    }
}