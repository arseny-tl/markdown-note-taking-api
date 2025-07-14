import logging

from transformers import AutoTokenizer, AutoModelForSeq2SeqLM

from app.core.config import settings

logger = logging.getLogger(__name__)


class ModelService:
    def __init__(self, model_name: str):
        self.model_name = model_name
        self.tokenizer = None
        self.model = None
        self._load_model()

    def _load_model(self):
        try:
            logger.info(f"Loading model: {self.model_name}")
            self.tokenizer = AutoTokenizer.from_pretrained(self.model_name)
            self.model = AutoModelForSeq2SeqLM.from_pretrained(self.model_name)
            logger.info("Model loaded successfully")
        except Exception as e:
            logger.error(f"Failed to load model: {str(e)}")
            raise

    async def generate_correction(self, text: str) -> str:
        if not self.is_loaded():
            raise RuntimeError("Model not loaded")

        try:
            inputs = self.tokenizer("correct:" + text, return_tensors="pt", max_length=512, truncation=True)
            outputs = self.model.generate(
                inputs["input_ids"],
                max_length=settings.MAX_TOKENS,
                num_beams=4,
                early_stopping=True
            )

            corrected = self.tokenizer.decode(outputs[0], skip_special_tokens=True)
            return corrected
        except Exception as e:
            logger.error(f"Error generating correction: {str(e)}")
            raise

    def is_loaded(self) -> bool:
        return self.model is not None and self.tokenizer is not None
