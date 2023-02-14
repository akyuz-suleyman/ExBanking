package com.ExBanking.step_definitions;

import com.ExBanking.pojos.Address;
import com.ExBanking.pojos.BankAccount;
import com.ExBanking.pojos.MoneyTransfer;
import com.ExBanking.pojos.User;
import com.ExBanking.utilities.ConfiguraitonReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class StepDefinition {




    Response response;

    User user=new User();
    Address address=new Address();

    BankAccount bankAccount=new BankAccount();

    MoneyTransfer moneyTransfer=new MoneyTransfer();

    @Before
    public static void init() { baseURI = ConfiguraitonReader.get("url");
    }

    @Given("Prepare the request data for creating a new user account")
    public void prepare_the_request_data_for_creating_a_new_user_account() {

        user.setEmail("example@email.com");
        user.setPhone("123-456-7890");
        user.setFirstname("John");
        user.setLastName("Doe");
        user.setDateOfBirth("1990-01-01");
        address.setCity("New York");
        address.setState("NY");
        address.setCountry("USA");
        address.setZipcode("10001");
        user.setAdress(address);

    }
    @When("Send a POST request to the create_user API endpoint")
    public void sendAPOSTRequestToTheCreate_userAPIEndpoint() {

       response= given()
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post("/create_user");

        System.out.println(response.header("x-mock-match-request-headers"));

    }

    @Then("Verify that the API response is a {int} status code")
    public void verifyThatTheAPIResponseIsAStatusCode(int code) {
        Assertions.assertEquals(code,response.statusCode());

    }

    @Then("Verify that the response contains success field set to true")
    public void verifyThatTheResponseContainsSuccessFieldSetToTrue() {

        response.then().assertThat().body("success",is("true"));

    }

    @Given("Prepare the request data for making a deposit with valid input data")
    public void prepareTheRequestDataForMakingADepositWithValidInputData() {
        bankAccount.setAccountNumber("1234567890");
        bankAccount.setCurrency("USD");
        bankAccount.setAmount(1000);

    }

    @When("Send a POST request to the deposit API endpoint")
    public void sendAPOSTRequestToTheDepositAPIEndpoint() {
        response= given()
                .accept(ContentType.JSON)
                .body(bankAccount)
                .when()
                .post("/deposit");
    }

    @Then("Verify that the API response is a {int}O status code")
    public void verifyThatTheAPIResponseIsAOStatusCode(int code) {
        Assertions.assertEquals(code,response.statusCode());
    }


    @Given("Prepare the request data for making a withdrawal with a valid account number and amount")
    public void prepareTheRequestDataForMakingAWithdrawalWithAValidAccountNumberAndAmount() {
        bankAccount.setAccountNumber("123456");
        bankAccount.setCurrency("USD");
        bankAccount.setAmount(1000);

    }

    @When("Send a POST request to the withdraw API endpoint with the request data")
    public void sendAPOSTRequestToTheWithdrawAPIEndpointWithTheRequestData() {

        response= given()
                .accept(ContentType.JSON)
                .body(bankAccount)
                .when()
                .post("/withdraw");
    }


    @Given("Send a GET request to the get_balance API endpoint with the request data")
    public void sendAGETRequestToTheGet_balanceAPIEndpointWithTheRequestData() {

        response= given()
                .accept(ContentType.JSON)
                .queryParam("account_number",123456789)
                .when()
                .get("/get_balance");

    }

    @Given("Prepare the request data for sending money")
    public void prepareTheRequestDataForSendingMoney() {

        moneyTransfer.setFromAccountNumber("123456789");
        moneyTransfer.setToAccountNumber("987654321");
        moneyTransfer.setTransferAmount(1000.0);
        moneyTransfer.setComment("test money transfer");


    }

    @When("Send a POST request to the send API endpoint")
    public void sendAPOSTRequestToTheSendAPIEndpoint() {
        response= given()
                .accept(ContentType.JSON)
                .body(moneyTransfer)
                .when()
                .post("/send");
    }


}
