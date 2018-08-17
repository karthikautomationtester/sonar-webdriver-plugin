package it.ding.sonar.check;

import it.ding.sonar.check.locator.LocatorCssValueCheck;
import it.ding.sonar.check.locator.LocatorStrategyByLinkTextAndTagNameCheck;
import it.ding.sonar.check.locator.LocatorStrategyByXpathCheck;
import it.ding.sonar.check.locator.LocatorXpathValueCheck;
import it.ding.sonar.check.wait.ExplicitWaitInTestCheck;
import it.ding.sonar.check.wait.HardCodedSleepCheck;
import it.ding.sonar.check.wait.ImplicitWaitCheck;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class WebDriverChecksTest {

  @Test
  public void shouldAvoidWebDriverCommandsInTest() {
    JavaCheckVerifier.verifyNoIssue("src/test/file/AvoidWebDriverCommandWithoutTestAnnotation.java", new WebDriverCommandInTestCheck());
    JavaCheckVerifier.verify("src/test/file/AvoidWebDriverCommand.java", new WebDriverCommandInTestCheck());
  }

  @Test
  public void shouldAvoidLocatorByXpath() {
    JavaCheckVerifier.verify("src/test/file/LocatorStrategyByXpath.java", new LocatorStrategyByXpathCheck());
  }

  @Test
  public void shouldAvoidXpathLocatorTiedToPageLayout() {
    JavaCheckVerifier.verify("src/test/file/LocatorXpathValue.java", new LocatorXpathValueCheck());
  }

  @Test
  public void shouldAvoidCssLocatorTiedToPageLayout() {
    JavaCheckVerifier.verify("src/test/file/LocatorCssValue.java", new LocatorCssValueCheck());
  }

  @Test
  public void shouldAvoidLocatorsByLinkTextAndTagName() {
    JavaCheckVerifier.verify("src/test/file/LocatorStrategyByLinkTextAndTagName.java", new LocatorStrategyByLinkTextAndTagNameCheck());
  }

  @Test
  public void shouldAvoidExplicitWaitsInTest() {
    JavaCheckVerifier.verify("src/test/file/ExplicitWait.java", new ExplicitWaitInTestCheck());
  }

  @Test
  public void shouldAvoidImplicitWaits() {
    JavaCheckVerifier.verify("src/test/file/ImplicitWait.java", new ImplicitWaitCheck());
  }

  @Test
  public void shouldAvoidHardCodedSleeps() {
    JavaCheckVerifier.verify("src/test/file/HardCodedSleep.java", new HardCodedSleepCheck());
  }

}
