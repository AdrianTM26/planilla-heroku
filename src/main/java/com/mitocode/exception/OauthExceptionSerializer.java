package com.mitocode.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.gson.Gson;

public class OauthExceptionSerializer extends StdSerializer<OauthException> {
	
	private static final Logger LOG = LoggerFactory.getLogger(OauthException.class);
	
	public OauthExceptionSerializer() {
        super(OauthException.class);
    }

    @Override
    public void serialize(OauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("Error_especifico", value.getOAuth2ErrorCode());
        gen.writeStringField("Descripcion_del_error", value.getMessage());
        gen.writeStringField("Error", value.getStackTrace()[0].getClassName());
        if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        Map<String, Object> obj = new HashMap<>();
        obj.put("Error_especifico",  value.getOAuth2ErrorCode());
        obj.put("Descripcion_del_error", value.getMessage());
        obj.put("Error", value.getStackTrace()[0].getClassName());
        Gson gson = new Gson();
		String json = gson.toJson(obj);
        LOG.error(json,new RuntimeException(value),value.getSummary());
        gen.writeEndObject();
    }
}
