package ch11;

import java.sql.Timestamp;

public class LogonDataBean
{
  private String id;
  private String passwd;
  private String name;
  private Timestamp reg_date;
  private String address;
  private String tel;

  public String getId()
  {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPasswd() {
    return this.passwd;
  }
  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Timestamp getReg_date() {
    return this.reg_date;
  }
  public void setReg_date(Timestamp reg_date) {
    this.reg_date = reg_date;
  }
  public String getAddress() {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getTel() {
    return this.tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
}