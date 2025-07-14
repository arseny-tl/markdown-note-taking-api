from functools import lru_cache

from app.services.grammar_service import GrammarService


@lru_cache()
def get_grammar_service() -> GrammarService:
    return GrammarService()
