package com.example.finalcpn;
public class predictionModel {
    private String imageUrl;
    private String predictionResult;
    private String id;

    public predictionModel() {}

    public predictionModel(String imageUrl, String predictionResult) {
        this.imageUrl = imageUrl;
        this.predictionResult = predictionResult;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPredictionResult() {
        return predictionResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPredictionResult(String predictionResult) {
        this.predictionResult = predictionResult;
    }
}
