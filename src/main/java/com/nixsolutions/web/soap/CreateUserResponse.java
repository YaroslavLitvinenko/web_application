package com.nixsolutions.web.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlType
@XmlRootElement (name = "createUserResponse")
public class CreateUserResponse {

    protected long userID;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long value) {
        this.userID = value;
    }
}
