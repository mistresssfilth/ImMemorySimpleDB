package entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public final class Record {

    private long account;
    private String name;
    private double value;

    @Override
    public String toString() {
        return " " + name + " " + value ;
    }
}
