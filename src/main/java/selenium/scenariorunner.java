package selenium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class scenariorunner {

    @RunWith(Cucumber.class)
    @CucumberOptions(format = {"pretty"}, tags = { "~@Pending" },
            glue = "classpath:com.sprinklr.tests", features = "classpath:features"
    )

    public class RunParallelSpace {

    }


    @RunWith(Cucumber.class)
    @CucumberOptions(format = {"pretty"}, dryRun = true, features = "src/test/resources/features/"
    )
    public class DryRunSpace {


    }

}
