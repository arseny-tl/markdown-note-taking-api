package org.tl.roadmap.markdown_note_taking_api.grammar.service.client.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.ApiClient;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.LocalModelClient;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.RestLocalModelClient;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.api.GrammarApi;

import java.util.List;

@AutoConfiguration
@EnableConfigurationProperties(LocalModelClientConfigurationProperties.class)
public class LocalModelClientAutoConfiguration {

    @Bean
    LocalModelClient localModelClient(GrammarApi localModelGrammarApi) {
        return new RestLocalModelClient(localModelGrammarApi);
    }

    @Bean
    RestClient localModelRestClient(
            LocalModelClientConfigurationProperties properties,
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter,
            RestClient.Builder restClientBuilder
    ) {
        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory();
        requestFactory.setReadTimeout(properties.getReadTimeout().plus(properties.getConnectTimeout()));

        return restClientBuilder
                .requestFactory(requestFactory)
                .messageConverters(List.of(mappingJackson2HttpMessageConverter))
                .build();
    }

    @Bean
    ApiClient localModelApiClient(LocalModelClientConfigurationProperties properties, RestClient localModelRestClient) {
        return new ApiClient(localModelRestClient).setBasePath(properties.getUrl());
    }

    @Bean
    GrammarApi localModelGrammarApi(ApiClient apiClient) {
        return new GrammarApi(apiClient);
    }
}
