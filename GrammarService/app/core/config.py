from pydantic_settings import BaseSettings, SettingsConfigDict


class Settings(BaseSettings):
    PROJECT_NAME: str = "Grammar Service"
    VERSION: str = "1.0.0"
    MODEL_NAME: str = "grammarly/coedit-large"
    MAX_TOKENS: int = 256

    model_config = SettingsConfigDict(env_file=".env")

settings = Settings()