package edu.ucdavis.fiehnlab.spectra.hash.core;

import edu.ucdavis.fiehnlab.spectra.hash.core.types.Ion;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test case for 1 ion
 */
public class IonTest {

    @org.junit.jupiter.api.Test
    public void testToString() throws Exception {
        Ion ion = new Ion(100.0222222,122.011111);

	    assertEquals("100.022222:122.011111", ion.toString(), "test if the toString method generates the right Ion representation");
    }

    @org.junit.jupiter.api.Test
    public void testCompare(){
        Ion a = new Ion(1,1);
        Ion b = new Ion(2,1);

        assertEquals(-1,a.compareTo(b));
    }
}