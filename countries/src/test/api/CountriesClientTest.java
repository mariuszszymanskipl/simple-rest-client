package api;

import domain.Country;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author Mariusz Szymanski
 */
public class CountriesClientTest {

    private CountriesClient countriesClient;

    @Before
    public void setUp() {
        countriesClient = new CountriesClient();
    }

    @Test
    public void getAllCountriesShouldNotBeNull() throws Exception {
//        Given & When
        final List<Country> countries = countriesClient.getAllCountries();
//        Then
        assertNotNull(countries);
    }
}