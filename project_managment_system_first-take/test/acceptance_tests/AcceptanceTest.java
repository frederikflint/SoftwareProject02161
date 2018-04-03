package acceptance_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "use_cases",
        plugin = { "html:target/cucumber/wikipedia.html"},
        monochrome=true,
        snippets = SnippetType.CAMELCASE,
        glue = { "acceptance_tests"})
public class AcceptanceTest {

}
