from fastapi.testclient import TestClient
import pytest
from app.main import app

client = TestClient(app)


def test_correct_text():
    response = client.post(
        "/api/v1/correct",
        json={"text": "This are a test."}
    )
    assert response.status_code == 200
    assert "This is a test." in response.json().get("corrected_text")
