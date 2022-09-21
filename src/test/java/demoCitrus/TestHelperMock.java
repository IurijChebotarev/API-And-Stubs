package demoCitrus;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.http.getAllCurses.GetAllCursesResponse;
import pojo.http.getAllCurses.GetAllCursesResponseItem;
import pojo.http.getAllUsers.GetAllUsersResponse;
import pojo.http.getScore.GetScoreResponse;

import java.util.ArrayList;
import java.util.List;


public class TestHelperMock extends TestNGCitrusTestRunner {
  private TestContext context;

  @Test(description = "Проверка получения информации о пользователях")
  @CitrusTest
  public void getAllUsers() {
    this.context = citrus.createTestContext();

    http(httpActionBuilder -> httpActionBuilder
        .client("restClientHelperMock")
        .send()
        .get("user/get/all")
        .fork(true)
    );

    http(httpActionBuilder -> httpActionBuilder
        .server("restHelperServer")
        .receive()
        .get());

    http(httpActionBuilder -> httpActionBuilder
        .server("restHelperServer")
        .send()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload("{\n" +
            "\"name\":\"Test user\",\n" +
            "\"cource\":\"QA\",\n" +
            "\"email\":\"test@test.test\",\n" +
            "\"age\": 23\n" +
            "}")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("restClientHelperMock")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getAllUsersData(), "objectMapper"));
  }

  @Test(description = "Проверка получения информации о оценке")
  @CitrusTest
  public void getScore() {
    this.context = citrus.createTestContext();

    http(httpActionBuilder -> httpActionBuilder
        .client("restClientHelperMock")
        .send()
        .get("user/get/${Id}")
        .fork(true)
    );

    http(httpActionBuilder -> httpActionBuilder
        .server("restHelperServer")
        .receive()
        .get());

    http(httpActionBuilder -> httpActionBuilder
        .server("restHelperServer")
        .send()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload("{\n" +
            "\"name\":\"Test user\",\n" +
            "\"score\": 78\n" +
            "}")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("restClientHelperMock")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getScoreData(), "objectMapper"));
  }

  @Test(description = "Проверка получения информации о курсах")
  @CitrusTest
  public void getAllCurses() {
    this.context = citrus.createTestContext();

    http(httpActionBuilder -> httpActionBuilder
        .client("restClientHelperMock")
        .send()
        .get("cource/get/all")
        .fork(true)
    );

    http(httpActionBuilder -> httpActionBuilder
        .server("restHelperServer")
        .receive()
        .get());

    http(httpActionBuilder -> httpActionBuilder
        .server("restHelperServer")
        .send()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload("[\n" +
            "{\n" +
            "\"name\":\"QA java\",\n" +
            "\"price\": 15000\n" +
            "},\n" +
            "{\n" +
            "\"name\":\"Java\",\n" +
            "\"price\": 12000\n" +
            "}\n" +
            "]")
    );

    http(httpActionBuilder -> httpActionBuilder
        .client("restClientHelperMock")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(getAllCursesData().getGetAllCursesResponse(), "objectMapper"));
  }

  public GetAllUsersResponse getAllUsersData() {
    GetAllUsersResponse getAllUsersResponse = new GetAllUsersResponse();
    getAllUsersResponse.setName("Test user");
    getAllUsersResponse.setCource("QA");
    getAllUsersResponse.setEmail("test@test.test");
    getAllUsersResponse.setAge(23);

    return getAllUsersResponse;

  }

  public GetScoreResponse getScoreData() {
    GetScoreResponse getScoreResponse = new GetScoreResponse();
    getScoreResponse.setName("Test user");
    getScoreResponse.setScore(78);

    return getScoreResponse;

  }

  public GetAllCursesResponse getAllCursesData() {
    GetAllCursesResponse getAllCursesResponse = new GetAllCursesResponse();
    GetAllCursesResponseItem getAllCursesResponseItem1 = new GetAllCursesResponseItem();
    GetAllCursesResponseItem getAllCursesResponseItem2 = new GetAllCursesResponseItem();
    List<GetAllCursesResponseItem> getAllCursesList = new ArrayList<>();
    getAllCursesResponseItem1.setName("QA java");
    getAllCursesResponseItem1.setPrice(15000);
    getAllCursesResponseItem2.setName("Java");
    getAllCursesResponseItem2.setPrice(12000);
    getAllCursesList.add(getAllCursesResponseItem1);
    getAllCursesList.add(getAllCursesResponseItem2);
    getAllCursesResponse.setGetAllCursesResponse(getAllCursesList);

    return getAllCursesResponse;

  }
}
