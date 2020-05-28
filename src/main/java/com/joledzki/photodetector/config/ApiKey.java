package com.joledzki.photodetector.config;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiKey {

    final ClarifaiClient client = new ClarifaiBuilder("9bbf40972e3946b2b25c3f76a29cead2").buildSync();

    public  List<ClarifaiOutput<Concept>> getInfo(String url){
        Model<Concept> generalModel = client.getDefaultModels().generalModel();

        PredictRequest<Concept> request = generalModel.predict().withInputs(
                ClarifaiInput.forImage(url)
        );
        List<ClarifaiOutput<Concept>> result = request.executeSync().get();
        return result;
    }

}
