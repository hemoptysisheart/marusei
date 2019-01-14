package com.github.smdj.marusei.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

@Converter(autoApply = true)
public class InstantAttributeConverter implements AttributeConverter<Instant, Long> {
    @Override
    public Long convertToDatabaseColumn(Instant attribute) {
        return attribute == null ? null : attribute.toEpochMilli();
    }

    @Override
    public Instant convertToEntityAttribute(Long dbData) {
        return dbData == null ? null : Instant.ofEpochMilli(dbData);
    }
}
