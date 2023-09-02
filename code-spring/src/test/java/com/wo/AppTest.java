package com.wo;

import com.wo.pojo.SimpleValueType;
import com.wo.pojo.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest extends TestCase {
    private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
    public void testDate(){
        Date date = new Date();
        log.info("{}",date);
    }
    public void testSimpleType(){
        User userBean = applicationContext.getBean("userBean", User.class);
        log.info("{}",userBean);
    }
    public void testSimpleValueType(){
        SimpleValueType simpleValueType = applicationContext.getBean("simpleValueType", SimpleValueType.class);
        log.info("简单数据类型 {}",simpleValueType);
    }
}
