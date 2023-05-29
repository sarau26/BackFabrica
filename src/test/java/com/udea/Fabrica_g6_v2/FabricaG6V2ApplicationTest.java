package com.udea.Fabrica_g6_v2;
import com.udea.Fabrica_g6_v2.FabricaG6V2Application;
import org.junit.jupiter.api.Test;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaG6V2ApplicationTest {

    @Test
    public void testApis() {
        FabricaG6V2Application app = new FabricaG6V2Application();
        Docket docket = app.apis();
        assertEquals(DocumentationType.SWAGGER_2, docket.getDocumentationType());
    }
}
