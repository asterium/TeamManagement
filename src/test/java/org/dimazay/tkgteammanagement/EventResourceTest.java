package org.dimazay.tkgteammanagement;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.dimazay.tkgteammanagement.config.ApiConfig;
import org.dimazay.tkgteammanagement.model.events.Event;
import org.dimazay.tkgteammanagement.model.events.EventType;
import org.dimazay.tkgteammanagement.rest.resources.EventResource;
import org.dimazay.tkgteammanagement.rest.resources.ResourceConstants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.core.Is.is;


/**
 * Created by Asterium on 14.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventResourceTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
//        RestAssuredMockMvc.standaloneSetup(EventResource.class);
//        RestAssuredMockMvc.basePath = ResourceConstants.EVENT_RESOURSE_PATH;
//        RestAssuredMockMvc.basePath = ResourceConstants.EVENT_RESOURSE_PATH;
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = ResourceConstants.EVENT_RESOURSE_PATH;
    }

    @Test
    public void TestCreateEvent() throws JsonProcessingException {
        LocalDate startDate = LocalDate.now();
        Event event = new Event();
        event.setEventType(EventType.TRAINING);
        event.setTitle("regularTraining");
        event.setStartDate(startDate);
//        event.setStartTime(LocalTime.now());

        String eventStr = new ObjectMapper().writeValueAsString(event);

      given()
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .body(event)
                .when()
                .post()

                .then()
                 .statusCode(200)
                .body("title", is(event.getTitle()))
                .body("startDate", is(startDate.format(DateTimeFormatter.ISO_DATE)))
                .body("eventType", is("TRAINING"));



    }
}
