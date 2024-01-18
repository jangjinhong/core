package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
<<<<<<< HEAD
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String reqeustURL = request.getRequestURI().toString();

        System.out.println("myLogger.getClass() = " + myLogger.getClass());
        myLogger.setRequestURL(reqeustURL);
=======
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        MyLogger myLogger = myLoggerProvider.getObject();
        String reqeustURL = request.getRequestURI().toString();
        myLogger.setRequestURL(reqeustURL);

>>>>>>> origin/master
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
