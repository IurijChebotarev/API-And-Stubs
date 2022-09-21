package demoCitrus;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.http.postRegistration.RegisterUserResponse;


public class TestHttpHelper extends TestNGCitrusTestRunner {

  private TestContext context;

  @Test(description = "Проверка корректности регистрации")
  @CitrusTest
  public void postRegister() {
    this.context = citrus.createTestContext();

    http(httpActionBuilder -> httpActionBuilder
        .client("httpHelperClient")
        .send()
        .post("register")
        .payload("{\n" +
            "    \"email\":\"eve.holt@reqres.in\",\n" +
            "    \"password\":\"pistol\" " +
            "}")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("httpHelperClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getRegisterResponseJsonData(), "objectMapper"));
  }

  public RegisterUserResponse getRegisterResponseJsonData() {
    RegisterUserResponse response = new RegisterUserResponse();
    response.setId(4);
    response.setToken("QpwL5tke4Pnpja7X4");

    return response;
  }
}
