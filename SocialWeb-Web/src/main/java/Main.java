import controller.HtmlToString;
import controller.Mailer;
import controller.RegistrationUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.dao.entityDao.PostDaoImpl;
import model.dao.entityDao.URLDaoImpl;
import model.entity.Post;
import model.entity.URLMassage;
import model.entity.User;
import service.UserServiceImpl;
import util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        UserServiceImpl userService = new UserServiceImpl();
        user = userService.byId(40);
//
//
        System.out.println(user);
        userService.remove(user);
        HibernateUtil.getSessionFactory().close();

//    Post post = new Post();
//    PostDaoImpl postDao = new PostDaoImpl();
//    post.setUser(user);
//
//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

//
//    post.setDate(new Date());
//    postDao.save(post);


//    if (32 < 33) {soc
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
