import com.dremio.planalyzer.PlanLine;
import com.dremio.planalyzer.PlanPrinter;
import com.dremio.planalyzer.PlanUtils;
import junit.framework.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class PlanPrinterTest extends TestCase {

    // test method to add two values
    public void testPlan1() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("plan1.txt");
        PlanLine root = PlanUtils.parsePlan(inputStream);
        PlanPrinter printer = new PlanPrinter();
        printer.process(root);
        System.out.println(printer.getString());
    }

    // test method to add two values
    public void testPlan2() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("plan2.txt");
        PlanLine root = PlanUtils.parsePlan(inputStream);
        PlanPrinter printer = new PlanPrinter();
        printer.process(root);
        System.out.println(printer.getString());
    }
}