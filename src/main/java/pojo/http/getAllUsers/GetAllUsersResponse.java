package pojo.http.getAllUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAllUsersResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("cource")
    private String cource;

    @JsonProperty("email")
    private String email;

    @JsonProperty("age")
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCource(String cource){
        this.cource = cource;
    }

    public String getCource(){
        return cource;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
     public String toString(){
        return 
            "GetAllCoursesResponse{" + 
            "name = '" + name + '\'' + 
            ",cource = '" + cource + '\'' + 
            ",email = '" + email + '\'' + 
            ",age = '" + age + '\'' + 
            "}";
        }
}