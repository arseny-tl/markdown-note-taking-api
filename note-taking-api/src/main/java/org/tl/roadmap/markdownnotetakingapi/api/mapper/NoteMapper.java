package org.tl.roadmap.markdownnotetakingapi.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.tl.roadmap.markdownnotetakingapi.api.GrammarResultDTO;
import org.tl.roadmap.markdownnotetakingapi.model.GrammarCheckResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface NoteMapper {

    GrammarResultDTO map(GrammarCheckResult grammarCheckResult);
}
