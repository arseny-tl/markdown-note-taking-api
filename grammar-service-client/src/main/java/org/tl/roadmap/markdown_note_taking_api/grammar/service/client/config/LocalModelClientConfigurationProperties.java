package org.tl.roadmap.markdown_note_taking_api.grammar.service.client.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Data
@Validated
@ConfigurationProperties(prefix = "tl.local-model")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocalModelClientConfigurationProperties {

    @NotBlank
    String url;
    @NotNull
    Duration readTimeout = Duration.ofSeconds(10);
    @NotNull
    Duration connectTimeout = Duration.ofSeconds(1);
}
