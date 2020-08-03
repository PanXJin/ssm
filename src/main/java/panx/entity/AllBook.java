package panx.entity;

import java.util.Date;

public class AllBook {
    private Integer codenum;
    private String bookname;
    private String insite;
    private String booknum;
    private String isin;
    private Date backtime;

    public Integer getCodenum() {
        return codenum;
    }

    public void setCodenum(Integer codenum) {
        this.codenum = codenum;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getInsite() {
        return insite;
    }

    public void setInsite(String insite) {
        this.insite = insite;
    }

    public String getBooknum() {
        return booknum;
    }

    public void setBooknum(String booknum) {
        this.booknum = booknum;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Date getBacktime() {
        return backtime;
    }

    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }
}
