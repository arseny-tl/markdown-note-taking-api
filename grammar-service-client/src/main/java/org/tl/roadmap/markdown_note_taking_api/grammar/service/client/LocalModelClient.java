package org.tl.roadmap.markdown_note_taking_api.grammar.service.client;

import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.model.TextInput;
import org.tl.roadmap.markdown_note_taking_api.grammar.service.client.model.TextOutput;

import java.io.InputStream;

public interface LocalModelClient {

    TextOutput correctText(TextInput text);
}
