package panx.entity;


public class AllBorrow {

  private String borrowid;
  private String bookcode;
  private String borrowdate;
  private String recdate;
  private String bookname;


  public String getBorrowid() {
    return borrowid;
  }

  public void setBorrowid(String borrowid) {
    this.borrowid = borrowid;
  }


  public String getBookcode() {
    return bookcode;
  }

  public void setBookcode(String bookcode) {
    this.bookcode = bookcode;
  }


  public String getBorrowdate() {
    return borrowdate;
  }

  public void setBorrowdate(String borrowdate) {
    this.borrowdate = borrowdate;
  }


  public String getRecdate() {
    return recdate;
  }

  public void setRecdate(String recdate) {
    this.recdate = recdate;
  }


  public String getBookname() {
    return bookname;
  }

  public void setBookname(String bookname) {
    this.bookname = bookname;
  }

}
