package pojo.http.getScore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetScoreResponse{

    @JsonProperty("score")
    private int score;

    @JsonProperty("name")
    private String name;

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}