from fastapi import APIRouter, Depends, HTTPException

from app.api.models import ErrorResponse
from app.api.models import TextInput
from app.api.models import TextOutput
from app.dependencies import get_grammar_service
from app.services import GrammarService

router = APIRouter()


@router.post(
    "/correct",
    response_model=TextOutput,
    tags=["Grammar"],
    operation_id="CorrectGrammar",
    summary="Correct grammar in a given text",
    description="Correct grammar in a given text using local model",
    responses={
        200: {
            "description": "Grammar correction successful",
            "model": TextOutput
        },
        400: {
            "description": "Bad Request - Invalid input data",
            "model": ErrorResponse
        },
        500: {
            "description": "Internal Server Error",
            "model": ErrorResponse
        }
    }
)
async def correct_text(
        input_data: TextInput,
        grammar_service: GrammarService = Depends(get_grammar_service)
):
    try:
        corrected = await grammar_service.correct_text(input_data.text)
        return TextOutput(
            corrected_text=corrected,
            original_text=input_data.text
        )
    except Exception as e:
        raise HTTPException(
            status_code=500,
            detail={
                "error": "Processing Error",
                "message": f"Failed to correct text: {str(e)}"
            }
        )
