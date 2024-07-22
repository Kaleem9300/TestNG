package com.test;



import org.testng.TestNG;
import java.util.*;

public class CustomTestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add("C:\\Users\\syed_kaleemuddin\\Desktop\\TrainingProjects\\onboardingprojectsprimary\\oops\\src\\main\\resources\\testng.xml"); 
        testNG.setTestSuites(suites);
        testNG.addListener(new CustomListener());
        testNG.run();
    }
}