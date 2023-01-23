package com.smarquezp.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning() {

        String responseFromService = "[" +
                "{\"id\":1, \"name\":\"Pencil\", \"quantity\":5}," +
                "{\"id\":2, \"name\":\"Pen\", \"quantity\":15}," +
                "{\"id\":3, \"name\":\"Eraser\", \"quantity\":10}" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        //System.out.println(context.read("$..id").toString());
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1, 2, 3);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());
    }
}
                                                                                                                                                   