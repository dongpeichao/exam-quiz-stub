package com.thoughtworks.exam.quiz;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public abstract class BlankPaperBase {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8002";
    }

}