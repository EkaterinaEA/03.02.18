/**
 * Created by Екатерина on 24.01.2019.
 */

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SubjKindConverter implements AttributeConverter<SubjKind, String> {
    @Override
    public String convertToDatabaseColumn(SubjKind attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("SubjKind = null");
        }
        return attribute.getDbValue();
    }

    @Override
    public SubjKind convertToEntityAttribute(String dbData) {
        for (SubjKind kind : SubjKind.values()) {
            if (kind.getDbValue().equals(dbData)) return kind;
        }

        throw new IllegalArgumentException("Unable to map value " + dbData + " to SubjKind");
    }
}