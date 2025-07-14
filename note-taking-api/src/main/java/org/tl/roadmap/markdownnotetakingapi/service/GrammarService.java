package org.tl.roadmap.markdownnotetakingapi.service;

import org.tl.roadmap.markdownnotetakingapi.model.GrammarCheckResult;

public interface GrammarService {

    GrammarCheckResult checkGrammar(String text);
}
