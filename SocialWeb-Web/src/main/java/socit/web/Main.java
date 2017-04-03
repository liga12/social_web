package socit.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import socit.service.UserService;

@Component
public class Main {

    @Autowired
    static UserService userService;

    public static void main(String[] args) {
        System.out.println(userService.getList());

    }
}
