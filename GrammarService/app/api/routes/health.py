from fastapi import APIRouter, Depends

from app.api.models import HealthResponse
from app.core.config import settings
from app.dependencies import get_grammar_service
from app.services import GrammarService

router = APIRouter()


@router.get("/", response_model=HealthResponse, responses={
    200: {
        "description": "Health check successful",
        "model": HealthResponse
    },
    404: {
        "description": "Service is down"
    },
    500: {
        "description": "Service is unavailable"
    }
})
async def health_check(service: GrammarService = Depends(get_grammar_service)):
    return HealthResponse(
        status="healthy",
        version=settings.VERSION,
        model_loaded=service.is_model_loaded()
    )
