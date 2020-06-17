package com.thoughtworks.exam.quiz;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public abstract class BlankQuizBase {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8000";
    }

}