package io.github.qbek.data;

public class StaticTestDataGenerator implements TestDataGenerator {
    @Override
    public String getProjectName() {
        return "Static project name";
    }

    @Override
    public boolean isTypeOf(String type) {
        return type.equals("static");
    }
}
