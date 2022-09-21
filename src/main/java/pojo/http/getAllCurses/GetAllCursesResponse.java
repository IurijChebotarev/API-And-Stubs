package pojo.http.getAllCurses;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAllCursesResponse{

    @JsonProperty("getAllCursesResponse")
    private List<GetAllCursesResponseItem> getAllCursesResponse;

    public void setGetAllCursesResponse(List<GetAllCursesResponseItem> getAllCursesResponse){
        this.getAllCursesResponse = getAllCursesResponse;
    }

    public List<GetAllCursesResponseItem> getGetAllCursesResponse(){
        return getAllCursesResponse;
    }

    @Override
     public String toString(){
        return 
            "GetAllCursesResponse{" + 
            "getAllCursesResponse = '" + getAllCursesResponse + '\'' + 
            "}";
        }
}