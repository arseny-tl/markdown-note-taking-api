from fastapi import HTTPException


class ModelNotLoadedException(HTTPException):
    def __init__(self):
        super().__init__(
            status_code=503,
            detail="Model is not loaded or unavailable"
        )


class TextTooLongException(HTTPException):
    def __init__(self):
        super().__init__(
            status_code=400,
            detail="Text is too long to process"
        )


class ProcessingException(HTTPException):
    def __init__(self, message: str):
        super().__init__(
            status_code=500,
            detail=f"Processing error: {message}"
        )
