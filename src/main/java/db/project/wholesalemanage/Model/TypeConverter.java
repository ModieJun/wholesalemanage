package db.project.wholesalemanage.Model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type,String> {
    @Override
    public String convertToDatabaseColumn(Type attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public Type convertToEntityAttribute(String code) {
        if (code==null) {
            return null;
        }

        return Stream.of(Type.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .get();
    }
}
