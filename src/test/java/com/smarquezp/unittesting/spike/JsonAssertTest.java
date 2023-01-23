package com.smarquezp.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{" + "\"id\": 1," + "\"name\": \"Ball\"," + "\"price\": 10," + "\"quantity\": 100" + "}";

    @Test
    public void jsonAssert() throws JSONException {
        String exceptedResponse = "{" + "\"id\": 1," + "\"name\": \"Ball\"," + "\"price\": 10," + "\"quantity\": 100" + "}";

        JSONAssert.assertEquals(exceptedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String exceptedResponse = "{" + "\"id\":1," + "\"name\": \"Ball\"," + "\"price\":10," + "\"quantity\":100" + "}";

        JSONAssert.assertEquals(exceptedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String exceptedResponse = "{" + "\"id\":1," + "\"name\": \"Ball\"," + "\"price\":10" + "}";
        // String exceptedResponse = "{" + "\"id\":1," + "\"name\": \"Ball\"," + "\"price\":11" + "}"; // ERROR

        JSONAssert.assertEquals(exceptedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String exceptedResponse = "{id:1, name: Ball, price:10}";
        // Escaping only necessary when value has spaces, for example, 'Ball 2'

        JSONAssert.assertEquals(exceptedResponse, actualResponse, false);
    }
}

