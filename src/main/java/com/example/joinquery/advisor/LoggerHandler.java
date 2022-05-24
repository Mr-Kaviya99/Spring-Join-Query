package com.example.joinquery.advisor;



import com.example.joinquery.util.StandardLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author Gayash Thasmika <gayasthasmika.w@gmail.com>
 * @since 11/2/2021
 */
@RestControllerAdvice
public class LoggerHandler {
    private static Logger logger = LoggerFactory.getLogger(LoggerHandler.class);

    public static LoggerHandler handleLogger(StandardLogger standardLogger){
        switch (standardLogger.getType()){
            case "error" :
                logger.error(standardLogger.getMessage());
                break;
            case "warn" :
                logger.warn(standardLogger.getMessage());
                break;
            case "info" :
                logger.info(standardLogger.getMessage());
                break;
            case "debug" :
                logger.debug(standardLogger.getMessage());
                break;
            case "trace" :
                logger.trace(standardLogger.getMessage());
                break;
        }
        return null;
    }
}
