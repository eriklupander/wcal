package se.lu.wcal.model;

import javax.persistence.*;

/**
 * Created by eriklupander on 2015-05-19.
 */
@Entity
public class UserCalendar {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    @Lob
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
