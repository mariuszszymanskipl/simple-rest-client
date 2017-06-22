package api;

import domain.Country;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.ProcessingException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

    @Test
    public void shouldContainCountryWithProperValues() throws Exception {
//        Given
        String expectedName = "Afghanistan";
        String expectedCapital = "Kabul";
//        When
        final List<Country> countries = countriesClient.getAllCountries();
        final Country country = countries.get(0);
//        Then
        assertThat(country.getName(), is(expectedName));
        assertThat(country.getCapital(), is(expectedCapital));
    }

    @Test
    public void shouldGetCountryDetails() throws Exception {
//        Given
        String expectedName = "Poland";
        String expectedCapital = "Warsaw";
//        When
        final Country country = countriesClient.getCountryDetails("poland");
//        Then
        assertThat(country.getName(), is(expectedName));
        assertThat(country.getCapital(), is(expectedCapital));
    }

    @Test (expected = ProcessingException.class)
    public void shouldThrowExceptionWhenCountryNotFound() throws Exception {
//        When
        countriesClient.getCountryDetails("poolland");
    }
}