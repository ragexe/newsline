package util;


import data.User;

/**
 * Created by alexanderleonovich on 29.04.15.
 */
public interface IUserService {

    User getByPK(Long pK);

    boolean checkUser(String email, String password);

    User authenticationProcess(String email);

    boolean registerNewUser(User User);

    User getUserByEmail(String email);

    void updateUserInformation(User User);

}
