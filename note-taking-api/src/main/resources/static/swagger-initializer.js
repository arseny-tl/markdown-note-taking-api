window.onload = function() {

    window.ui = SwaggerUIBundle({
        urls: [{url:"./schema.yaml", name: "Grammar Service API"}],
        dom_id: '#swagger-ui',
        deepLinking: true,
        presets: [
            SwaggerUIBundle.presets.apis,
            SwaggerUIStandalonePreset
        ],
        plugins: [
            SwaggerUIBundle.plugins.DownloadUrl
        ],
        layout: "StandaloneLayout"
    });
};