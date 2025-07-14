from pydantic import BaseModel, Field


class TextInput(BaseModel):
    text: str = Field(..., min_length=1, max_length=5000,
                      description="Text to correct. Should contain 256 tokens at max.")
