package infrastructure;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static infrastructure.TestCasePriority.P0;

/**
 * Created by Boris on 9/29/2018.
 */
public class ReportingUtilities {

    private static boolean hasTableBeenCerated = false;

    //Pass Rate map
    private static HashMap<TestCasePriority, PassRatesDto<Integer, Integer>> passRateMap;



    public static void assertTrueWithMessage(TestCasePriority priority, boolean passOrFail, String messageIfPassed, String messageIfFailed, String tcId) {
        setUpReporting();
        calculatePassRates(priority, passOrFail);
        if (passOrFail)
            Reporter.log("<tr><td>" + priority + "</td><td><b><font color=\"green\">PASSED</font></b></td><td>tcId: " + messageIfPassed + "</td></tr>");
        else
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"red\">FAILED</font></b></td><td>tcId: " + messageIfFailed + "</td></tr>");

        Assert.assertTrue(passOrFail);
    }

    public static void assertFalseWithMessage(TestCasePriority priority, boolean passOrFail, String messageIfPassed, String messageIfFailed, String tcId) {
        setUpReporting();
        calculatePassRates(priority, !passOrFail);
        if (!passOrFail)
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"red\">FAILED</font></b></td><td>tcId: " + messageIfPassed + "</td></tr>");
        else
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"green\">PASSED</font></b></td><td>tcId: " + messageIfFailed + "</td></tr>");

        Assert.assertFalse(passOrFail);
    }


    public static void softAssertTrueWithMessage(SoftAssert sAssert, TestCasePriority priority, boolean passOrFail, String messageIfPassed, String messageIfFailed, String tcId) {
        setUpReporting();
        calculatePassRates(priority, passOrFail);
        if (passOrFail)
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"green\">PASSED</font></b></td><td>tcId: " + messageIfFailed + "</td></tr>");
        else
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"red\">FAILED</font></b></td><td>tcId: " + messageIfPassed + "</td></tr>");

        sAssert.assertTrue(passOrFail);
    }

    public static void softAssertFalseWithMessage(SoftAssert sAssert, TestCasePriority priority,  boolean passOrFail, String messageIfPassed, String messageIfFailed, String tcId) {
        setUpReporting();
        calculatePassRates(priority, passOrFail);
        if (passOrFail)
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"green\">PASSED</font></b></td><td>tcId: " + messageIfFailed + "</td></tr>");
        else
            Reporter.log("<tr><td>" + priority + "<td><b><font color=\"red\">FAILED</font></b></td><td>tcId: " + messageIfPassed + "</td></tr>");

        sAssert.assertTrue(passOrFail);
    }

    /*public static void assertAllWithMessage(SoftAssert sAssert, TestCasePriority priority, String messageIfPassed, String messageIfFailed) {
        if (passOrFail)
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>" + messageIfFailed);
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>" + messageIfPassed);

        sAssert.assertAll();
    }*/

    private static void setUpReporting() {
        if (hasTableBeenCerated == false) {
            Reporter.log("<table border = 1>");
            hasTableBeenCerated = true;
            passRateMap = new HashMap<TestCasePriority, PassRatesDto<Integer, Integer>>();
            for (TestCasePriority priority2:TestCasePriority.values())
                passRateMap.put(priority2, new PassRatesDto<Integer, Integer>(0, 0));
        }
    }

    private static void calculatePassRates(TestCasePriority priority, boolean passOrFail) {




        switch (priority) {
            case P0: {
                passRateMap.get(TestCasePriority.P0).setOverall(passRateMap.get(TestCasePriority.P0).getOverall()+1);
                if (passOrFail)
                    passRateMap.get(TestCasePriority.P0).setPassed(passRateMap.get(TestCasePriority.P0).getPassed()+1);
                break;
            }
            case P1: {
                passRateMap.get(TestCasePriority.P1).setOverall(passRateMap.get(TestCasePriority.P1).getOverall()+1);
                if (passOrFail)
                    passRateMap.get(TestCasePriority.P1).setPassed(passRateMap.get(TestCasePriority.P1).getPassed()+1);
                break;
            }
            case P2: {
                passRateMap.get(TestCasePriority.P2).setOverall(passRateMap.get(TestCasePriority.P2).getOverall()+1);
                if (passOrFail)
                    passRateMap.get(TestCasePriority.P2).setPassed(passRateMap.get(TestCasePriority.P2).getPassed()+1);
                break;
            }
            case P3: {
                passRateMap.get(TestCasePriority.P3).setOverall(passRateMap.get(TestCasePriority.P3).getOverall()+1);
                if (passOrFail)
                    passRateMap.get(TestCasePriority.P3).setPassed(passRateMap.get(TestCasePriority.P3).getPassed()+1);
                break;
            }
            case P4: {
                passRateMap.get(TestCasePriority.P4).setOverall(passRateMap.get(TestCasePriority.P4).getOverall()+1);
                if (passOrFail)
                    passRateMap.get(TestCasePriority.P4).setPassed(passRateMap.get(TestCasePriority.P4).getPassed()+1);
                break;
            }
        }



        /*switch (priority) {
            case P0: {
                ++overallP0;
                if (passOrFail)
                    ++passedP0;
                break;
            }
            case P1: {
                ++overallP1;
                if (passOrFail)
                    ++passedP1;
                break;
            }
            case P2: {
                ++overallP2;
                if (passOrFail)
                    ++passedP2;
                break;
            }
            case P3: {
                ++overallP3;
                if (passOrFail)
                    ++passedP3;
                break;
            }
            case P4: {
                ++overallP4;
                if (passOrFail)
                    ++passedP4;
                break;
            }
        }*/
    }

    public static void geenerateResultsTable () {
        Reporter.log(
                "<hr><table border=1>"
                        + "<tr>"
                            + "<th>Priority</th><th>Overall</th><th>Passed</th><th>Percentage passed</th>"
                        + "</tr>"
                        + "<tr>"
                            + "<td>P0</td><td>" + passRateMap.get(TestCasePriority.P0).getOverall() + "</td><td>" + passRateMap.get(TestCasePriority.P0).getPassed() + "</td><td>" + (passRateMap.get(TestCasePriority.P0).getOverall()>0?passRateMap.get(TestCasePriority.P0).getPassed()/ passRateMap.get(TestCasePriority.P0).getOverall()*100:"0") + "%</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>P1</td><td>" + passRateMap.get(TestCasePriority.P1).getOverall() + "</td><td>" + passRateMap.get(TestCasePriority.P1).getPassed() + "</td><td>" +  (passRateMap.get(TestCasePriority.P1).getOverall()>0?passRateMap.get(TestCasePriority.P1).getPassed()/ passRateMap.get(TestCasePriority.P1).getOverall()*100:"0") + "%</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>P2</td><td>" + passRateMap.get(TestCasePriority.P2).getOverall() + "</td><td>" + passRateMap.get(TestCasePriority.P2).getPassed() + "</td><td>" +  (passRateMap.get(TestCasePriority.P2).getOverall()>0?passRateMap.get(TestCasePriority.P2).getPassed()/ passRateMap.get(TestCasePriority.P2).getOverall()*100:"0") + "%</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>P3</td><td>" + passRateMap.get(TestCasePriority.P3).getOverall() + "</td><td>" + passRateMap.get(TestCasePriority.P3).getPassed() + "</td><td>" +  (passRateMap.get(TestCasePriority.P3).getOverall()>0?passRateMap.get(TestCasePriority.P3).getPassed()/ passRateMap.get(TestCasePriority.P3).getOverall()*100:"0") + "%</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>P4</td><td>" + passRateMap.get(TestCasePriority.P4).getOverall() + "</td><td>" + passRateMap.get(TestCasePriority.P4).getPassed() + "</td><td>" +  (passRateMap.get(TestCasePriority.P4).getOverall()>0?passRateMap.get(TestCasePriority.P4).getPassed()/ passRateMap.get(TestCasePriority.P4).getOverall()*100:"0") + "%</td>"
                        + "</tr>"
                + "</table>"
        );
    }

    public static class PassRatesDto <A,B> {
        public A overAll;
        public B passed;

        public PassRatesDto(A a, B b) {
            overAll = a;
            passed = b;
        }

        public A getOverall () {
            return overAll;
        }

        public B getPassed () {
            return passed;
        }

        public void setOverall(A overall) {
            this.overAll = overall;
        }

        public void setPassed(B passed) {
            this.passed = passed;
        }

    }

}
