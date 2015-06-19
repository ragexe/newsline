package by.newsline.service;


import data.User;


public interface IUserService {

    User getByPK(Long pK);

    boolean checkUser(String email, String password);

    User authenticationProcess(String email);

    boolean registerNewUser(User User);

    User getUserByEmail(String email);

    User getUserById(long id);

    void updateUserInformation(User User);

}
