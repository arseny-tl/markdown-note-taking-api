package org.tl.roadmap.markdownnotetakingapi.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.LocalModelClient;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.model.TextInput;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.model.TextOutput;
import org.tl.roadmap.markdownnotetakingapi.model.GrammarCheckResult;
import org.tl.roadmap.markdownnotetakingapi.service.exception.GrammarCheckException;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocalModelGrammarService implements GrammarService {

    LocalModelClient localModelClient;

    @Override
    public GrammarCheckResult checkGrammar(String text) {
        TextInput input = new TextInput().text(text);
        GrammarCheckResult result = new GrammarCheckResult();
        TextOutput output = localModelClient.correctText(input);
        result.setCorrectedText(output.getCorrectedText());
        return result;
    }
}
