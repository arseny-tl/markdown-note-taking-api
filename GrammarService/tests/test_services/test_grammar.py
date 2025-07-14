import pytest

from app.services import GrammarService

@pytest.mark.asyncio
async def test_correct_text():
    grammar_model = GrammarService()

    test_cases = [
        ("This are a test.", "This is a test."),
        ("I has a problem.", "I have a problem."),
        ("She don't like it.", "She does not like it."),
        ("He go to school everyday.", "He goes to school every day."),
        ("There is many people here.", "There are many people here."),
    ]

    for input_text, expected in test_cases:
        result = await grammar_model.correct_text(input_text)
        print(f"Input: '{input_text}' -> Output: '{result}'")

        assert result is not None
        assert len(result) > 0
        assert result == expected

