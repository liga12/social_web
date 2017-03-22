package socit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import socit.service.UserService;
import socit.web.RegistrationUserImp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

//    @ResponseBody
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getHomePage() {
//        User user = new User();
//        user.setEmail("2");
//        user.setLogin("2");
//        user.setFirstname("2");
//        user.setLastname("2");
//        user.setPassword("2");
//        userService.save(user);
//        return userService.byUserArgument("2", "login").getFirstname();
//    }
//
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        userService.byUserArgument("1", "login");
        return "login";
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.POST)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView getRegistration(@RequestParam("firstname") String firstname,
                                        @RequestParam("lastname") String lastname,
                                        @RequestParam("email") String email,
                                        @RequestParam("login") String login,
                                        @RequestParam("password") String password,
                                        @RequestParam("passwordtwo") String passwordTwo,
                                        HttpServletRequest req) {
        String data = "";
        ModelAndView modelAndView;
        List<String> registration = new RegistrationUserImp().setRegistration
                (firstname, lastname, email, login, password, passwordTwo, req);
        if (registration.size() == 0) {
            String[] emailc = email.split("@");
            String emailClient = emailc[1];
            modelAndView = new ModelAndView("onEmail");
            modelAndView.addObject("host", "https://" + emailClient);
        } else {
            for (String s : registration) {
                data += "  " + s;
            }
            modelAndView = new ModelAndView("registration");
            modelAndView.addObject("data", data);
            data = null;
        }
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping(value="/", method = RequestMethod.GET, produces = "text/plain")
//    public ModelAndView getHomePage2(){
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("name", userService.getList());
//        return modelAndView;
//    }

//    @RequestMapping(value="/", method = RequestMethod.GET, produces = "text/plain")
//    public String getHomePage(){
//        return "redirect:/static/home2.jsp";
//    }

//    @RequestMapping(value="/he/{name}", method = RequestMethod.GET)
//    public ModelAndView getHomePage22(@PathVariable("name") String name){
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("name", name);
//        return modelAndView;
//    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView getHomePage22(@RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
