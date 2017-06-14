package org.dimazay.tkgteammanagement;

import io.restassured.RestAssured;
import org.dimazay.tkgteammanagement.model.User;
import org.dimazay.tkgteammanagement.rest.resources.ResourceConstants;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by Asterium on 14.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
//        RestAssured.basePath = ResourceConstants.EVENT_RESOURSE_PATH;
    }

    @Test
    public void testCreateEvent(){
        User user = new User();
        user.setEmail("someTestEmail");
        user.setRole("admin");

        given()
                .basePath(ResourceConstants.USERS_RESOURSE_PATH)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(user)
                .when()
                .post("")
                .then()
                .statusCode(200)
        .body("email", equalTo(user.getEmail()))
        .body("role", is(user.getRole()));
    }

    @Test
    public void testGetAllUsers() {

        given()
                .basePath(ResourceConstants.USERS_RESOURSE_PATH)
        .when()
                .get("")
                .then()
                .body("size()", is(4));
        System.out.println();
    }


}
