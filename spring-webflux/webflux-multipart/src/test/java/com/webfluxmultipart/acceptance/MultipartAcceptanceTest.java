package com.webfluxmultipart.acceptance;

import com.webfluxmultipart.util.SpringBootTestPrefix;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.nio.file.Path;
import java.nio.file.Paths;


public class MultipartAcceptanceTest extends SpringBootTestPrefix {

    private static final String TEXT_FILE_NAME = "text.txt";

    private Path path;

    @BeforeEach
    void beforeEach() {
        Path resourceDirectory = Paths.get("src", "test", "resources", "things");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.out.println(absolutePath);
        path = Paths.get(absolutePath, TEXT_FILE_NAME);
        System.out.println(path);
    }

    @DisplayName("업로드")
    @Test
    public void test() {
        var extractableResponse = RestAssured.given().log().all()
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .multiPart("files", path.toFile())
                .log().all()
                .when()
                .post("/file")
                .then().extract();

        var text = extractableResponse.response().body().print();
        System.out.println(text);
    }

}
