from fastapi import FastAPI

from app.api.routes import grammar
from app.core.config import settings
from app.exceptions import add_exception_handlers
from app.api.routes import health


def create_app() -> FastAPI:
    result = FastAPI(
        title=settings.PROJECT_NAME,
        version=settings.VERSION,
        description="HTTP Wrapper of Grammar Correction Model"
    )

    # Include routers
    result.include_router(grammar.router, prefix="/api/v1")
    result.include_router(health.router, prefix="/api/v1")

    add_exception_handlers(result)

    return result


app = create_app()
