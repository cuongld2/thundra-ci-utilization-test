package features.api.serverless;

import common.ApiUtil;
import common.CoreConstant;
import io.restassured.response.Response;
import static net.serenitybdd.rest.SerenityRest.given;

public class Product {

    public Response createProduct(models.features.serverless.Product product){

        return given().baseUri(CoreConstant.SERVERLESS_URL)
                .header("Content-Type", "application/json")
                .body(ApiUtil.parseObjectToJSON(product, models.features.serverless.Product.class))
                .when()
                .post();

    }

    public Response getProduct(models.features.serverless.Product product, String movieId){

        return given().baseUri(CoreConstant.SERVERLESS_URL+"/"+movieId)
                .header("Content-Type", "application/json")
                .body(ApiUtil.parseObjectToJSON(product, models.features.serverless.Product.class))
                .when()
                .get();
    }
    
}
