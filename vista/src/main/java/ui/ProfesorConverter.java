package ui;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.integration.ServiceLocator;

@FacesConverter("profesorConverter")
public class ProfesorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        try {
            Integer id = Integer.parseInt(value);
            return ServiceLocator.getInstanceProfesorDAO().find(id).orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        if (value instanceof Profesor) {
            return String.valueOf(((Profesor) value).getId());
        }
        return "";
    }
}