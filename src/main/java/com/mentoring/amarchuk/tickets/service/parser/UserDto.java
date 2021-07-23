package com.mentoring.amarchuk.tickets.service.parser;

import com.mentoring.amarchuk.tickets.model.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;



@XmlRootElement(name = "users")
public class UserDto {

    private List<User> userList;

    @XmlElement(name = "user")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
