package utilities.basic;

import java.io.Serializable;
import java.util.Date;

public class ExampleData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Date creationDate;
    private int value;

    public ExampleData() {
        this.creationDate = new Date();
    }

    public ExampleData(String name, int value) {
        this.name = name;
        this.value = value;
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ExampleData{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", value=" + value +
                '}';
    }
}