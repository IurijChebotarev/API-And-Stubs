package pojo.http.getAllCurses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAllCursesResponseItem{

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("name")
    private String name;

    public void setPrice(Integer price){
        this.price = price;
    }

    public Integer getPrice(){
        return price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
     public String toString(){
        return 
            "GetAllCursesResponseItem{" + 
            "price = '" + price + '\'' + 
            ",name = '" + name + '\'' + 
            "}";
        }
}