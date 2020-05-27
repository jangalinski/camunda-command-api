package io.holunda.command.maven.plugin.util;

import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class TemplateLoader {


  public String loadTemplate(String resource) throws IOException {
    return IOUtils.toString(TemplateLoader.class.getResourceAsStream("/CamundaValueMapper.tpl"));
  }

}
