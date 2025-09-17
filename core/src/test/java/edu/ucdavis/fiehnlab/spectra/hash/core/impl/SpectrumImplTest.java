package edu.ucdavis.fiehnlab.spectra.hash.core.impl;

import edu.ucdavis.fiehnlab.spectra.hash.core.types.Ion;
import edu.ucdavis.fiehnlab.spectra.hash.core.types.SpectraType;
import edu.ucdavis.fiehnlab.spectra.hash.core.types.SpectrumImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  */
public class SpectrumImplTest {

    @Test
    public void testGetIons() throws Exception {
        Ion ion = new Ion(120, 111);
        ArrayList<Ion> list = new ArrayList<Ion>();
        list.add(ion);
        SpectrumImpl impl = new SpectrumImpl(list, "test", SpectraType.MS);

        assertNotNull(impl.getIons());
        assertEquals(impl.getIons().getFirst(), ion);
    }
}
