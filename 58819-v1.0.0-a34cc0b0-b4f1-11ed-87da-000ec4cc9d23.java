/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__fromFile_68a.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * BadSink: exec dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE78_OS_Command_Injection__fromFile_68a extends AbstractTestCase
{

    public static String data;

    public void bad() throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        File f = new File("C:\\data.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            fread = new FileReader(f);
            buffread = new BufferedReader(fread);

            data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( fread != null )
                    {
                        fread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing fread");
                }
            }
        }

        (new CWE78_OS_Command_Injection__fromFile_68b()).bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE78_OS_Command_Injection__fromFile_68b()).goodG2B_sink();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
