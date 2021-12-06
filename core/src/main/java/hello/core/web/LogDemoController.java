package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLoggerObjectProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURI = request.getRequestURI().toString();

        System.out.println("myLoggerObjectProvider = " + myLoggerObjectProvider);
        myLoggerObjectProvider.setRequestURL(requestURI);

        myLoggerObjectProvider.log("controller test");
        Thread.sleep(100);
        logDemoService.logic("testId");
        return "OK";
    }
}
