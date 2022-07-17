package Get_list_auctions;

import Base_Url.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static io.restassured.RestAssured.given;

public class Get_list_auctions {
    @ParameterizedTest
    @CsvFileSource(resources = "/list_auctions.csv",numLinesToSkip = 2)
    public void Get_list_auctions(String status,String index,String count,String type,String user_id,String category_id){
        BaseClass.init();
        Input input = new Input();
        input.index=index;
        input.count=count;
        Response response = given().contentType(ContentType.JSON).when().body(input).get("/auctions/"+status);
        response.prettyPrint();
    }
}
class Input{
    public String index;
    public String count;
    public String type;
    public String user_id;
    public String category_id;
}
