//package api.serverless;
//
//import java.io.IOException;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import common.BaseTest;
//import io.restassured.response.Response;
//import io.thundra.agent.lambda.localstack.LambdaServer;
//import models.features.serverless.Product;
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.thucydides.core.annotations.WithTag;
//import io.thundra.agent.trace.TraceSupport;
//import io.thundra.agent.trace.span.ThundraSpan;
//import io.thundra.agent.trace.span.impl.ErrorInjectorSpanListener;
//import io.thundra.agent.trace.span.impl.FilteringSpanListener;
//
//
//public class ProductTest extends BaseTest{
//
//
//    private static final features.api.serverless.Product productApi = new features.api.serverless.Product();
//    private static final Product productModel = new Product();
//
//
//    @WithTag("product")
//    @Test
//    public void create_new_product() throws IOException{
//
//        // LambdaServer.registerFunctionEnvironmentInitializer(
//        //         ChaosInjector.createDynamoDBChaosInjector("createProduct"));
//
//        //         ErrorInjectorSpanListener errorListener =
//        // ErrorInjectorSpanListener.
//        //         builder().
//        //         injectOnFinish(false).
//        //         errorType(java.lang.ClassNotFoundException.class).
//        //         errorMessage("As AWS CTO Werner Vogels said, 'Everything fails, all the time.'").
//        //         injectPercentage(100).
//        //         build();
//        //         TraceSupport.registerSpanListener(errorListener);
//
//                ErrorInjectorSpanListener errorListener =
//                ErrorInjectorSpanListener.
//                        builder().
//                        injectOnFinish(false).
//                        errorType(java.lang.ClassNotFoundException.class).
//                        errorMessage("As AWS CTO Werner Vogels said, 'Everything fails, all the time.'").
//                        injectPercentage(100).
//                        build();
//        FilteringSpanListener errorFilteringSpanListener =
//                FilteringSpanListener.
//                        builder().
//                        listener(errorListener).
//                        filter(FilteringSpanListener.
//                                    filterBuilder().
//                                    className("AWS-DynamoDB").
//                                    build()).
//                        build();
//        TraceSupport.registerSpanListener(errorFilteringSpanListener);
//        String productName = "Test product";
//        Double price = 9.6;
//
//
//
//        productModel.setName(productName);
//        productModel.setPrice(price);
//
//        Response responseProduct = productApi.createProduct(productModel);
//        Product responseProductActual = responseProduct.as(Product.class);
//        softAssertImpl.assertThat("Verify status code is 200",responseProduct.getStatusCode(), 200);
//        softAssertImpl.assertThat("Verify title is correct",responseProductActual.getName(),productName);
//
//    }
//
//
//
//
//
//}
