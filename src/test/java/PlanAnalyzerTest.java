import com.dremio.planalyzer.AnalysisOption;
import com.dremio.planalyzer.PlanAnalyzer;
import com.dremio.planalyzer.PlanLine;
import com.dremio.planalyzer.PlanUtils;
import junit.framework.TestCase;

import java.io.InputStream;

public class PlanAnalyzerTest extends TestCase {


    // test method to add two values
    public void testPlan1() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("plan1.txt");
        PlanLine root = PlanUtils.parsePlan(inputStream, true);
        PlanAnalyzer analyzer = new PlanAnalyzer();
        analyzer.process(null, 0, root, new AnalysisOption());
    }

    // test method to add two values
    public void testPlan2() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("plan2.txt");
        PlanLine root = PlanUtils.parsePlan(inputStream, true);
        PlanAnalyzer analyzer = new PlanAnalyzer();
        analyzer.process(null, 0, root, new AnalysisOption());
    }
}