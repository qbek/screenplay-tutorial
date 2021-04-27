package io.github.qbek.test;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RequestSample {


    @Step
    public void sendRequest() {
        SerenityRest.given()
                .baseUri("https://api.todoist.com/rest/v1/projects/2264273065")
                .header("Authorization", "Bearer d469ce54eca3a7ca5b6b5e7d4c8d51ced8d4c7b1")
                .contentType(ContentType.JSON)
                .log().all()
                .get().then().log().all();
    }
}
