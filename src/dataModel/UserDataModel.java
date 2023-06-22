package dataModel;

import entity.User;

public class UserDataModel {
    private User user;

    public UserDataModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
