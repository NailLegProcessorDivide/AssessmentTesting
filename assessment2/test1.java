

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LoanCompanyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LoanCompanyTest
{
    private StudentLoan studentL1;
    private StudentLoan studentL2;
    private StudentLoan studentL3;

    /**
     * Default constructor for test class LoanCompanyTest
     */
    public LoanCompanyTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        studentL1 = new StudentLoan("ABC123", 5000);
        studentL2 = new StudentLoan("Z9Z88Z", 0);
        studentL3 = new StudentLoan("XYZ123", 200);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        studentL1 = null;
        studentL2 = null;
        studentL3 = null;
    }
    
    @Test
    public void testAddLoan1()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        assertEquals(1, lc.getNumberOfLoans());
    }
    
    @Test
    public void testEmpty()
    {
        LoanCompany lc = new LoanCompany();
        assertEquals(0, lc.getNumberOfLoans());
    }
    
    @Test
    public void testFind1()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL2);
        lc.addLoan(studentL3);
        assertEquals(studentL2, lc.find("Z9Z88Z"));
    }
    
    @Test
    public void testFind2()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL2);
        lc.addLoan(studentL3);
        assertEquals(null, lc.find("DEADBEEF"));
    }
    
    @Test
    public void testFind3()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL2);
        lc.addLoan(studentL3);
        assertEquals(null, lc.find("Z"));
    }
    
    @Test
    public void testEmptySuccess()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        assertEquals(true, lc.repay(0, 100));
        assertEquals(4900, studentL1.getAmount());
    }
    
    @Test
    public void testEmptyFail1()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        assertEquals(false, lc.repay(-1, 100));
        assertEquals(5000, studentL1.getAmount());
    }
    
    @Test
    public void testEmptyFail2()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        assertEquals(false, lc.repay(1, 100));
        assertEquals(5000, studentL1.getAmount());
    }
    
    @Test
    public void testRemoveSuccess1()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL2);
        assertEquals(studentL1, lc.remove(0));
    }
    
    @Test
    public void testRemoveSuccess2()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL2);
        assertEquals(studentL2, lc.remove(1));
    }
    
    @Test
    public void testRemoveFail1()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        assertEquals(null, lc.remove(-1));
    }
    
    @Test
    public void testRemoveFail2()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        assertEquals(null, lc.remove(1));
    }
    
    @Test
    public void tesRCL()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL2);
        lc.addLoan(studentL3);
        assertEquals(studentL2, lc.removeClearedLoans().get(0));
    }
    
    @Test
    public void tesRCL2()
    {
        LoanCompany lc = new LoanCompany();
        lc.addLoan(studentL1);
        lc.addLoan(studentL3);
        assertNotEquals(null, lc.removeClearedLoans());
    }
}
