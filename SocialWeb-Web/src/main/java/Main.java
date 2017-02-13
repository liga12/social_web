import controller.RegistrationUser;
import java.util.List;
import util.HibernateUtil;

/**
 * Created by liga on 08.02.17.
 */
public class Main {

  public static void main(String[] args) {
//    User b = new UserServiceImpl().getExistEmail("e");
//    if (b==null){
//      System.out.println("yes");
//    }
//    else {
//      System.out.println("no");
//    }


    String email = "emaff";
    String login = "lffog";

    List<String> arr = new RegistrationUser().setRegistration("f", "l",
        "1", "d", "1");
//    for (String s : arr) {
//      if (s.equals("login")){
//        System.out.println("login");
//      }
//      if (s.equals("email")){
//        System.out.println("email");
//      }
//    }
    if (arr.size()==0){
      System.out.println("save");
    }


//    new UserServiceImpl().getEncryptedMd5ApacheAndAES("1");


//    User user = new UserServiceImpl().getUserAuthorization("d", "1" );
//if (user!= null){
//  System.out.println("yes");
//}else {
//  System.out.println("no");
//}

//    String s = "23";
//    RegistrationUser registrationUser = new RegistrationUser();
//    if (registrationUser.validationRegistrationData("f", "l",
////        "1", "d", "1").size())
//    List<User> users = new UserServiceImpl().getList();
//    for (User user : users) {
//      System.out.println(user);
//    }


    HibernateUtil.getSessionFactory().close();
  }
}
