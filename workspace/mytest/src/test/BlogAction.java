package test; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogAction{
     //定义一个全局的记录器，通过LoggerFactory获取
     private final static Logger logger = LoggerFactory.getLogger(BlogAction.class); 
     /**
     * @param args
     */
    public static void main(String[] args) {
        logger.info("logback ");
        logger.error("logback");
    }
}
