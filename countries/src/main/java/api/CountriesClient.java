package api;


import domain.Country;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mariusz Szymanski
 */
class CountriesClient {

    private static final String COUNTRIES_SERVICE_URL
            = "https://restcountries.eu/rest/v2/{code}fields=name;capital;region;population;flag";

    List<Country> getAllCountries(){
        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target(COUNTRIES_SERVICE_URL.replace("{code}", "all?"));
        final Response response = target.request().get();
        final Country[] countries = response.readEntity(Country[].class);
        response.close();

        return Arrays.asList(countries);
    }

    Country getCountryDetails(String countryFullName){
        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target(COUNTRIES_SERVICE_URL
                .replace("{code}", "name/" + countryFullName + "?fullText=true&"));
        final Response response = target.request().get();
        final Country[] countries = response.readEntity(Country[].class);
        response.close();

        return countries[0];
    }

}
