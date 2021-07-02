package test.project01.domain;

public class House {
    private int id;
    private String name;
    private int tel;
    private String adr;
    private double monthRent;
    private String status;

    public House(int id, String name, int tel, String adr, double monthRent, String status) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.adr = adr;
        this.monthRent = monthRent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public double getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(double monthRent) {
        this.monthRent = monthRent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\t" + id +
                "\t" + name +
                "\t" + tel +
                "\t" + adr +
                "\t" + monthRent +
                "\t" + status;
    }
}
