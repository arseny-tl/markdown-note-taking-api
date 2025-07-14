import logging

from app.core import settings
from app.services.model_service import ModelService

logger = logging.getLogger(__name__)


class GrammarService:
    def __init__(self):
        self.model_service = ModelService(settings.MODEL_NAME)

    async def correct_text(self, text: str) -> str:
        try:
            if not text.strip():
                return text

            corrected = await self.model_service.generate_correction(text)
            return corrected
        except Exception as e:
            logger.error(f"Error correcting text: {str(e)}")
            raise

    def is_model_loaded(self) -> bool:
        return self.model_service.is_loaded()
