package io.github.qbek.data;

import com.github.javafaker.Faker;

public class RandomTestDataGenerator implements TestDataGenerator {

    private static Faker generator = new Faker();

    @Override
    public String getProjectName() {
        return generator.beer().style();
    }

    @Override
    public String getTaskName() {
        return generator.backToTheFuture().quote();
    }

    @Override
    public boolean isTypeOf(String type) {
        return type.equals("random");
    }


}
