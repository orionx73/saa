package br.unifor.pin.saa.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unifor.pin.saa.entity.Instituicoes;

@FacesConverter(value="instituicoesConverter")
public class InstituicoesConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null && !"".equals(value) && !value.isEmpty()) {  
            return this.getAttributesFrom(component).get(value);  
        }  
        return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		 if (value != null  
	                && !"".equals(value)) {  
	  
	            Instituicoes entity = (Instituicoes) value;  
	  
	            
	            this.addAttribute(component, entity);  
	  
	            Long codigo = entity.getId();  
	            if (codigo != null) {  
	                return String.valueOf(codigo);  
	            }  
	        }  
	  
	        return (String) value; 
	}

	protected void addAttribute(UIComponent component, Instituicoes o) {
		String key = o.getId().toString(); 
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}