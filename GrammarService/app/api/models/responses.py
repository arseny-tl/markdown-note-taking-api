from typing import Any

from pydantic import BaseModel


class TextOutput(BaseModel):
    corrected_text: str
    original_text: str


class ErrorResponse(BaseModel):
    error: str
    message: str
    details: Any = None


class HealthResponse(BaseModel):
    status: str
    version: str
    model_loaded: bool
