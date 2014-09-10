package de.plushnikov.lombok;

import com.intellij.codeInspection.ex.LocalInspectionToolWrapper;
import com.intellij.testFramework.InspectionTestCase;
import de.plushnikov.intellij.plugin.inspection.LombokInspection;

/**
 * @author Plushnikov Michail
 */
public class InspectionTest extends InspectionTestCase {

  @Override
  protected String getTestDataPath() {
    return "./lombok-plugin/src/test/data/inspection";
  }

  private void doTest() throws Exception {
    doTest(getTestName(true), new LocalInspectionToolWrapper(new LombokInspection()), "java 1.5");
  }

  public void testIssue37() throws Exception {
    doTest();
  }

  public void testBuilderRightType() throws Exception {
    doTest();
  }

  public void testBuilderInvalidIdentifier() throws Exception {
    doTest();
  }

  public void testDelegateConcreteType() throws Exception {
    doTest();
  }

  public void testDelegateOnMethodWithParameter() throws Exception {
    doTest();
  }

  public void testDelegateOnStaticFieldOrMethod() throws Exception {
    doTest();
  }

  //TODO make this test work
  public void testSneakyThrowsSingle() throws Exception {
    doTest();
  }

  //TODO make this test work
  public void testSneakyThrowsPlain() throws Exception {
    doTest();
  }

  //TODO make this test work
  public void testSneakyThrowsMultiple() throws Exception {
    doTest();
  }

  //TODO make this test work
  public void testSneakyThrowsTryWithResource() throws Exception {
    doTest();
  }
}
