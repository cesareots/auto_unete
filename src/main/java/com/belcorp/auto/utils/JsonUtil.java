package com.belcorp.auto.utils;

import com.belcorp.auto.models.COPostulantModel;
import com.belcorp.auto.models.MXPostulantModel;
import com.belcorp.auto.models.PEPostulantModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JsonUtil {

    public static JSONObject jsonToObject(String json, String id) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(json), StandardCharsets.UTF_8);
            Object object = parser.parse(inputStreamReader);
            JSONArray jsonArray = (JSONArray) object;
            jsonObject = (JSONObject) jsonArray.get(Integer.parseInt(id) - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static COPostulantModel getCOPostulant(String json, String id) {
        JSONObject jsonObject = jsonToObject(json, id);

        COPostulantModel coPostulantModel = new COPostulantModel();
        coPostulantModel.setTypeDocument((String) jsonObject.get("TypeDocument"));
        coPostulantModel.setNumDocument((String) jsonObject.get("NumDocument"));
        coPostulantModel.setFirstLastName((String) jsonObject.get("FirstLastName"));
        coPostulantModel.setBirthDate((String) jsonObject.get("BirthDate"));
        coPostulantModel.setGender((String) jsonObject.get("Gender"));
        coPostulantModel.setCelNumber((String) jsonObject.get("CelNumber"));
        coPostulantModel.setEmail((String) jsonObject.get("Email"));
        coPostulantModel.setTaxRegime((String) jsonObject.get("TaxRegime"));
        coPostulantModel.setLinkMTOName((String) jsonObject.get("LinkMTOName"));
        coPostulantModel.setSwitchRecommend((String) jsonObject.get("SwitchYesNo"));

        return coPostulantModel;
    }

    public static PEPostulantModel getPEPostulant(String json, String id) {
        JSONObject jsonObject = jsonToObject(json, id);

        PEPostulantModel pePostulantModel = new PEPostulantModel();
        double numAle = 2343;

        System.out.println("numero : " + numAle);

        String nameMarket = jsonObject.get("LinkMTOName").toString() + String.valueOf(numAle);
        System.out.println("nombre de Market: " + nameMarket);

        pePostulantModel.setTypeDocument((String) jsonObject.get("TypeDocument"));
        pePostulantModel.setNumDocument((String) jsonObject.get("NumDocument"));
        pePostulantModel.setCelNumber((String) jsonObject.get("CelNumber"));
        pePostulantModel.setEmail((String) jsonObject.get("Email"));
        pePostulantModel.setDepartment((String) jsonObject.get("Department"));
        pePostulantModel.setProvince((String) jsonObject.get("Province"));
        pePostulantModel.setDistrict((String) jsonObject.get("District"));
        //pePostulantModel.setLinkMTOName(nameMarket); // jsonObject.get("LinkMTOName")
        pePostulantModel.setLinkMTOName(jsonObject.get("LinkMTOName").toString()); //
        pePostulantModel.setSwitchYesNo((String) jsonObject.get("SwitchYesNo"));
        pePostulantModel.setConsultantCode((String) jsonObject.get("ConsultantCode"));
        pePostulantModel.setTermsConditionCheck((String) jsonObject.get("TermsConditionCheck"));
        pePostulantModel.setPrivacyPolicyCheck((String) jsonObject.get("PrivacyPolicyCheck"));
        pePostulantModel.setPublicityCheck((String) jsonObject.get("PublicityCheck"));

        pePostulantModel.setCompleteNames((String) jsonObject.get("CompleteNames"));
        pePostulantModel.setFirstLastName((String) jsonObject.get("FirstLastName"));
        pePostulantModel.setSecondLastName((String) jsonObject.get("SecondLastName"));
        pePostulantModel.setBirthDate((String) jsonObject.get("BirthDate"));
        pePostulantModel.setGender((String) jsonObject.get("Gender"));
        pePostulantModel.setDistrictReception((String) jsonObject.get("DistrictReception"));
        pePostulantModel.setTypeAddress((String) jsonObject.get("TypeAddress"));
        pePostulantModel.setUrbanization((String) jsonObject.get("Urbanization"));
        pePostulantModel.setApple((String) jsonObject.get("Apple"));
        pePostulantModel.setLot((String) jsonObject.get("Lot"));
        pePostulantModel.setReference((String) jsonObject.get("Reference"));

        return pePostulantModel;
    }

    public static MXPostulantModel getMXPostulant(String json, String id) {
        JSONObject jsonObject = jsonToObject(json, id);

        MXPostulantModel mxPostulantModel = new MXPostulantModel();
        mxPostulantModel.setNames((String) jsonObject.get("Names"));
        mxPostulantModel.setFirstLastName((String) jsonObject.get("FirstLastName"));
        mxPostulantModel.setSecondLastName((String) jsonObject.get("SecondLastName"));
        mxPostulantModel.setBirthDate((String) jsonObject.get("BirthDate"));
        mxPostulantModel.setGender((String) jsonObject.get("Gender"));
        mxPostulantModel.setCelNumber((String) jsonObject.get("CelNumber"));
        mxPostulantModel.setEmail((String) jsonObject.get("Email"));
        mxPostulantModel.setMunicipality((String) jsonObject.get("Municipality"));
        mxPostulantModel.setLinkMTOName((String) jsonObject.get("LinkMTOName"));
        mxPostulantModel.setRFC((String) jsonObject.get("RFC"));

        return mxPostulantModel;
    }
}
