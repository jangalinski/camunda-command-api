package io.holunda.command.project.generator.model;

import io.toolisticon.annotationprocessortoolkit.tools.ElementUtils.AccessEnclosingElements;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;

public final class FqnUtil {

  public static final String PROJECT_BASE_PACKAGE = "io.holunda.command";

  public static String resourcePath(final String packageName) {
    return "/" + packageRemainder(packageName).replaceAll("\\.", "/");
  }

  public static String packageRemainder(final String packageName) {
    if (!packageName.startsWith(PROJECT_BASE_PACKAGE) || PROJECT_BASE_PACKAGE.equals(packageName)) {
      throw new IllegalArgumentException(
        "basepackage mismatch: must start with '" + PROJECT_BASE_PACKAGE + ".*' but was '" + packageName + "'");
    }
    return packageName.replace(PROJECT_BASE_PACKAGE.concat("."), "");
  }

  public static String packageFromElement(Element element) {
    return ((PackageElement) AccessEnclosingElements
      .getFirstEnclosingElementOfKind(element, ElementKind.PACKAGE)).getQualifiedName()
      .toString();
  }

  private FqnUtil() {
  }
}
