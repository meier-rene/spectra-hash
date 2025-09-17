package edu.ucdavis.fiehnlab.spectra.hash.rest;

import edu.ucdavis.fiehnlab.spectra.hash.core.types.Ion;
import edu.ucdavis.fiehnlab.spectra.hash.core.Splash;
import edu.ucdavis.fiehnlab.spectra.hash.core.SplashFactory;
import edu.ucdavis.fiehnlab.spectra.hash.core.types.SpectraType;
import edu.ucdavis.fiehnlab.spectra.hash.rest.dao.Spectrum;
import edu.ucdavis.fiehnlab.spectra.hash.rest.dao.ValidationRequest;
import edu.ucdavis.fiehnlab.spectra.hash.rest.dao.ValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * simple rest service, which hashes submitted spectra data, as well as validate provided spectra hashes against the current reference implementation
 */
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private Splash spectraHash;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public RestController() {
        spectraHash = SplashFactory.create();
        logger.info("created hash generator of type: " + spectraHash);
    }

    /**
     * converts a spectra to the hash code
     * @param spectrum
     * @return splash code
     */
    @RequestMapping(value = "/splash/it", method = RequestMethod.POST)
    public String convert(@RequestBody Spectrum spectrum) {

        try {
            logger.info("received spectrum: " + spectrum);

            if (spectrum.getIons().isEmpty()) {
                throw new RuntimeException("spectrum must have at least one ion");
            }

            String hash = spectraHash.splashIt(spectrum);
            logger.info("generated hash: " + hash);

            return hash;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/splash/it/example" ,method = RequestMethod.GET)
    public Spectrum splashRequestExample() {
        Spectrum spectrum = new Spectrum();
        spectrum.setIons(Arrays.asList(new Ion(100, 1), new Ion(101, 2), new Ion(102, 3)));
        spectrum.setOrigin("where do I come from or null");
        spectrum.setType(SpectraType.MS);

        return spectrum;
    }

    /**
     * converts a spectra to the hash code
     * @param validationRequest
     * @return validation response
     */
    @RequestMapping(value = "/splash/validate", method = RequestMethod.POST)
    public ValidationResponse validate(@RequestBody ValidationRequest validationRequest) {

        try {
            String reference = spectraHash.splashIt(validationRequest.getSpectrum());
            String provided = validationRequest.getSplash();

            ValidationResponse validationResponse = new ValidationResponse();
            validationResponse.setRequest(validationRequest);
            validationResponse.setReferenceSplash(reference);
            validationResponse.setValidationSuccessful(reference.equals(provided));

            return validationResponse;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/splash/validate/example")
    public ValidationRequest splashValidationExample() {
        Spectrum spectrum = new Spectrum();
        spectrum.setIons(Arrays.asList(new Ion(100, 1), new Ion(101, 2), new Ion(102, 3)));
        spectrum.setOrigin("where do I come from or null");
        spectrum.setType(SpectraType.MS);

        ValidationRequest request = new ValidationRequest();
        request.setSpectrum(spectrum);
        request.setSplash(spectraHash.splashIt(spectrum));

        return request;
    }
}
