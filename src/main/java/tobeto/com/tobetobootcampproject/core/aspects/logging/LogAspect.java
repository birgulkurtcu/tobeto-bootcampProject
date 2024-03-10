package tobeto.com.tobetobootcampproject.core.aspects.logging;

import tobeto.com.tobetobootcampproject.core.crosscuttingconcerns.logging.LogParameter;
import tobeto.com.tobetobootcampproject.core.crosscuttingconcerns.logging.LoggerServiceBase;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class LogAspect {
    private LoggerServiceBase loggerServiceBase;
    private HttpServletRequest request;

    @Autowired
    public LogAspect(
            LoggerServiceBase loggerServiceBase,
            HttpServletRequest httpServletRequest
    ) {
        this.loggerServiceBase = loggerServiceBase;
        this.request = httpServletRequest;
    }

    @Around("springBeanPointcut() && @annotation(tobeto.com.tobetobootcampproject.core.aspects.logging.Loggable)")
    public Object logAround(
            ProceedingJoinPoint joinPoint
    ) throws Throwable {

        Object result = joinPoint.proceed();

        String methodName = joinPoint.getSignature()
                .getDeclaringTypeName()
                + "." + joinPoint.getSignature()
                .getName();


        List<LogParameter> logParameters = new ArrayList<>();
        logParameters.add(new LogParameter(result));

        String userName = getUserName();

        loggerServiceBase.log(methodName,logParameters,userName);

        return result;
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)"
            + " || within(@org.springframework.stereotype.Service *)"
            + " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {

    }
    private String getUserName(){
        if (request.getUserPrincipal() != null) {
            return request.getUserPrincipal().getName();
        } else {
            return "?";
        }
    }




}
