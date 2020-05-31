package io.holunda.command.project.generator.model.template;

import io.holunda.command.project.generator.model.FqnUtil;
import java.util.Map;

public interface Template {
  String FILE_SUFFIX = ".tpl";

  String getPackageName();

  String getTypeSimpleName();

  Map<String,Object> getModel();

  default String getFqn() {
    return getPackageName().concat(".").concat(getTypeSimpleName());
  }

  default String getTemplateResourcePath() {
    return String.format("%s/%s%s", FqnUtil.resourcePath(getPackageName()), this.getClass().getSimpleName(), FILE_SUFFIX);
  }

}
