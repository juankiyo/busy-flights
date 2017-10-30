package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpStatusCodeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BusyFlightsApplicationTests {

    private TestUtils testUtils = new TestUtils();

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
    }

    @Test
    public void busyFlights_ShouldReturn_BusyFlightsResponseList() {
        try {
            String request = testUtils
                    .readFile("Input-BusyFlights-Request-Success.json");
            String expectedResponse = testUtils
                    .readFile("Output-BusyFlights-Response-Success.json");
            String actualResponse = testUtils.makePostCall("/busyflights/all", port, request,
                    MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON);
            assertEquals("busyFlightsTest: JSON output does not match", expectedResponse, actualResponse);

        } catch (Exception ex) {
            fail(ex.getLocalizedMessage());
        }
    }
}
