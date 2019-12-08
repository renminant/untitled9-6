package pojo;

public class Power {
    Integer id;
    String powername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", powername='" + powername + '\'' +
                '}';
    }
}
