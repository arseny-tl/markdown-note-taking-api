package org.tl.roadmap.markdownnotetakingapi.api;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tl.roadmap.markdownnotetakingapi.api.mapper.NoteMapper;
import org.tl.roadmap.markdownnotetakingapi.service.GrammarService;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NoteController {

    GrammarService grammarService;
    NoteMapper noteMapper;

    @PostMapping(value = "/grammar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GrammarResultDTO grammar(@RequestBody TextDTO textDTO) {
        return noteMapper.map(grammarService.checkGrammar(textDTO.getText()));
    }
}
