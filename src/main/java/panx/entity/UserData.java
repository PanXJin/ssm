package panx.entity;

import java.util.List;

public class UserData {
    private String name;
    private List<AllBorrow> allBorrow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AllBorrow> getAllBorrow() {
        return allBorrow;
    }

    public void setAllBorrow(List<AllBorrow> allBorrow) {
        this.allBorrow = allBorrow;
    }
}
