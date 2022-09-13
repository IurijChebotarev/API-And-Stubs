package pojo.http;

public class RegisterUserResponse{
	private Integer id;
	private String token;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"RegisterUserResponse{" + 
			"id = '" + id + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
