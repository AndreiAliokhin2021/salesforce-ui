package scripts;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
    private Runner() {
    }

    public static void main(String[] args) {
        XmlSuite regressionSuite = new XmlSuite();
        regressionSuite.setName("salesforce ui suite");

        XmlTest accountManagementTest = new XmlTest(regressionSuite);
        accountManagementTest.setName("Account Management Test");
        XmlClass accountManagementTestClass = new XmlClass("scripts.AccountManagementTest");
        accountManagementTest.setXmlClasses(Collections.singletonList(accountManagementTestClass));

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(regressionSuite);

        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();
    }
}
