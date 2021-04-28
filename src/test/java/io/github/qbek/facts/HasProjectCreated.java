package io.github.qbek.facts;

import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.data.Notes;
import io.github.qbek.restapi.ProjectRequest;
import io.github.qbek.restapi.ProjectResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.facts.Fact;

import static io.github.qbek.data.Notes.PROJECT;

public class HasProjectCreated implements Fact {

    public HasProjectCreated(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void setup(Actor actor) {
        ProjectRequest payload = new ProjectRequest();
        payload.setName(name);
        actor.remember(Notes.PROJECT_NAME, name);
//        actor.attemptsTo(
//                SilentTask.where(
//                    Post.to("/projects").with(req -> {
//                        req.headers("Authorization", actor.usingAbilityTo(AuthoriseHimself.class).getToken());
//                        req.contentType(ContentType.JSON);
//                        req.body(payload);
//                        req.log().all();
//                        return req;
//                    })
//                )
//        );
        ProjectResponse prj = RestAssured.given()
                    .baseUri("https://api.todoist.com/rest/v1")
                    .headers("Authorization", actor.usingAbilityTo(AuthoriseHimself.class).getToken())
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when().post("/projects")
                .then().extract().body().as(ProjectResponse.class);
        actor.remember(PROJECT, prj);

        actor.wasAbleTo(
                Task.where("Created project details",
                        a -> Serenity.recordReportData().withTitle("Created project").andContents(
                                String.format("Project name: %s \n project id: %d", prj.getName(), prj.getId()))

                        )
        );
    }
}
