package demoCitrus;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.message.MessageType;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.http.RegisterUserResponse;

public class TestHttpHelper extends TestNGCitrusTestRunner {

//  private TestContext context;
  @CitrusResource
  private TestRunner runner;

  @Пусть("Я отправляю запрос на регистрацию с email {string} и паролем {string}")
  public void postRegister(String email, String pass) {
//    this.context = citrus.createTestContext();

    runner.http(httpActionBuilder -> httpActionBuilder
        .client("httpHelperClient")
        .send()
        .post("register")
        .payload("{\n" +
            "    \"email\": \"" + email + "\",\n" +
            "    \"password\": \"" + pass + "\"\n" +
            "}")
    );
  }

  @Тогда("Я проверяю, что вернулся ответ с id {int} и токеном {string}")
    public void getRegisterResponse(int id, String token) {
    runner.http(httpActionBuilder -> httpActionBuilder
        .client("httpHelperClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getRegisterResponseJsonData(id, token), "objectMapper"));
  }

  public RegisterUserResponse getRegisterResponseJsonData(int id, String token) {
    RegisterUserResponse response = new RegisterUserResponse();
    response.setId(id);
    response.setToken(token);

    return response;
  }
}
