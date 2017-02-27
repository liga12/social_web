import controller.HtmlToString;
import controller.Mailer;
import controller.RegistrationUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import model.dao.entityDao.PostDaoImpl;
import model.dao.entityDao.URLDaoImpl;
import model.entity.Post;
import model.entity.URLMassage;
import model.entity.User;
import service.UserServiceImpl;
import util.HibernateUtil;

/**
 * Created by liga on 08.02.17.
 */
public class Main {

  public static void main(String[] args) {


//    Post post = new Post();
//    PostDaoImpl postDao = new PostDaoImpl();
//    UserServiceImpl userService = new UserServiceImpl();
//    User user2 = userService.byId(40);
//    System.out.println(user2);
//    post.setUser(user2);
//    postDao.save(post);

    URLMassage urlMassage = new URLMassage();
    URLDaoImpl urlDao = new URLDaoImpl();
    URLMassage urlfff = urlDao.byId(8);
    urlDao.remove(urlfff);

    HibernateUtil.getSessionFactory().close();

//    if (32 < 33) {
//      System.out.println("222");
//    }
//
//    for (int i = 999; i > 99; i--) {
//      for (int j = i; j > 99; j--) {
//        Integer pol = 0;
//        Integer k = i * j;
////        System.out.print(i + " * " + j + " = " + k);
////        String polrev = new StringBuilder(k.toString()).reverse().toString();
//
//
//
//        if (reverse(k) == k) {
//          if (pol<k){
//            pol = k;
//          }
////          System.out.print(" pol\n");
//          System.out.println(i + " * " + j + " = " + k);
//          System.out.println("pol = "+ pol);
//
//        } else {
////          System.out.print(" net\n");
//        }
//
//      }
  }

  public static int reverse(int input) {
    int last_digit = 0;
    int reversedNum = 0;
    while (input != 0) {
      last_digit = input % 10;
        reversedNum = reversedNum * 10 + last_digit;

      input = input / 10;
    }
    return reversedNum;
  }

}
