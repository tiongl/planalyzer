import com.dremio.planalyzer.PlanAnalyzer;
import com.dremio.planalyzer.PlanLine;
import com.dremio.planalyzer.PlanUtils;
import junit.framework.TestCase;

import java.io.InputStream;

public class PlanAnalyzerTest extends TestCase {


    // test method to add two values
    public void testPlan1() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("plan1.txt");
        PlanLine root = PlanUtils.parsePlan(inputStream);
        PlanAnalyzer analyzer = new PlanAnalyzer();
        analyzer.process(root);
    }

    // test method to add two values
    public void testPlan2() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("plan2.txt");
        PlanLine root = PlanUtils.parsePlan(inputStream);
        PlanAnalyzer analyzer = new PlanAnalyzer();
        analyzer.process(root);
    }
}