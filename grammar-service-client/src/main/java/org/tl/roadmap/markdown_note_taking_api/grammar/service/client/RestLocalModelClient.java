package org.tl.roadmap.markdown_note_taking_api.grammar.service.client;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.api.GrammarApi;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.model.TextInput;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.model.TextOutput;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestLocalModelClient implements LocalModelClient {

    GrammarApi grammarApi;

    @Override
    public TextOutput correctText(TextInput text) {
        return grammarApi.correctGrammar(text);
    }
}
