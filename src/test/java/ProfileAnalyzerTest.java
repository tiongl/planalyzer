import com.dremio.planalyzer.ProfileAnalyzer;
import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.Files;

public class ProfileAnalyzerTest extends TestCase {

    String tmpdir;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        tmpdir = Files.createTempDirectory("plan-analyzer").toString();
    }


    public void testProfilterAnalyzer() throws IOException {
        ProfileAnalyzer.main(new String[]{
                "src/main/resources/sample_query1.json", tmpdir + "/sample_query1"
        });
    }
}
