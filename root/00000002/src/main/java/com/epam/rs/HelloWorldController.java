package com.epam.rs;

/**
 * Created by Raman_Susla1 on 2/23/2016.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

@Controller
public class HelloWorldController {
    String message = "Welcome!";
    private final static Logger LOGGER = Logger.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public ModelAndView showMessage(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        LOGGER.info("in controller");

        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
}
