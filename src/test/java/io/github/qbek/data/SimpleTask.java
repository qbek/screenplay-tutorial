package io.github.qbek.data;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLOutput;

public class SimpleTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("I'm " + actor.getName() + "! Hello World!!!");
    }
}
