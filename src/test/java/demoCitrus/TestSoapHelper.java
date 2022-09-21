package demoCitrus;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import features.PojoToXML;
import org.testng.annotations.Test;
import pojo.xml.com.dataaccess.webservicesserver.NumberToWords;
import pojo.xml.com.dataaccess.webservicesserver.NumberToWordsResponse;

import java.math.BigInteger;


public class TestSoapHelper extends TestNGCitrusTestRunner {

  private TestContext context;

  @Test(description = "Проверка метода NumberToWords")
  @CitrusTest
  public void getTestActions() {
    this.context = citrus.createTestContext();

    PojoToXML<Class<NumberToWords>> convRequest = new PojoToXML<>();
    PojoToXML<Class<NumberToWordsResponse>> convResponse = new PojoToXML<>();


    soap(soapActionBuilder -> soapActionBuilder
        .client("soapHelperClient")
        .send()
        .payload(convRequest.convert(NumberToWords.class, getNumberToWordsRequest(), "http://www.dataaccess.com/webservicesserver/", "NumberToWords"))
    );

    soap(soapActionBuilder -> soapActionBuilder
        .client("soapHelperClient")
        .receive()
        .xsdSchemaRepository("schemaRepositoryService")
        .payload(convResponse.convert(NumberToWordsResponse.class, getNumberToWordsResponse(), "http://www.dataaccess.com/webservicesserver/", "NumberToWordsResponse"))
    );
  }

  public NumberToWords getNumberToWordsRequest() {
    NumberToWords numberToWords = new NumberToWords();
    numberToWords.setUbiNum(new BigInteger("20"));
    return numberToWords;
  }

  public NumberToWordsResponse getNumberToWordsResponse() {
    NumberToWordsResponse numberToWordsResponse = new NumberToWordsResponse();
    numberToWordsResponse.setNumberToWordsResult("twenty");
    return numberToWordsResponse;
  }

}
