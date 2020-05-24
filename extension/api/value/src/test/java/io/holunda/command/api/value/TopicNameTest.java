package io.holunda.command.api.value;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TopicNameTest {

  @Test
  public void create() {
    TopicName topic = CamundaValues.topicName("topic");

    assertThat(topic.getValue()).isEqualTo("topic");
  }
}
