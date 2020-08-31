package ch08;

import java.sql.Timestamp;

public class RegisterBean
{
  private String idt;
  private String passwd;
  private String name;
  private Timestamp reg_date;

  public String getIdt()
  {
    return this.idt;
  }
  public void setIdt(String idt) {
    this.idt = idt;
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
}