package com.luis.crud.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.core.io.ClassPathResource;

public class JsonValidatorService {
	
	static void validateBookDTO(String dtoJson) throws IOException, ParseBookDTOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
		InputStream file = new ClassPathResource("bookdto.json").getInputStream();
		JsonNode json = objectMapper.readTree(dtoJson);
		JsonSchema schema = schemaFactory.getSchema(file);
		Set<ValidationMessage> errors = schema.validate(json);
		
		if(!errors.isEmpty()) {
			List<String> values = new ArrayList<>();
			errors.forEach(validationMessage -> values.add(validationMessage.getMessage()));
            throw new ParseBookDTOException(values.toString());
		}
	}

}
