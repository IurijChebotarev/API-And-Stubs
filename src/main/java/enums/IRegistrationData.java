package enums;

public enum IRegistrationData {
  REGISTRATION_DATA1("eve.holt@reqres.in", "pistol", 4, "QpwL5tke4Pnpja7X4");

  private String email;
  private String password;
  private int id;
  private String token;

  IRegistrationData(String email, String password, int id, String token) {
    this.email = email;
    this.password = password;
    this.id = id;
    this.token = token;

  }

  public String getEmail() {
    return email;
  }
  public String getPassword() {
    return password;
  }
  public int getId() {
    return id;
  }
  public String getToken() {
    return token;
  }
}

