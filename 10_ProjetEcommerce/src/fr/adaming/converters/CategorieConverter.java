package fr.adaming.converters;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import fr.adaming.model.Agent;
import fr.adaming.service.ICategorieService;


@FacesConverter("catConverter")
public class CategorieConverter implements Converter{

	@EJB
	ICategorieService catService;
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		  if(value != null && value.trim().length() > 0) {
	            try {
	             
	            	Agent ag=(Agent) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agentSession");
	                return catService.getAllCategorie(ag).get(Integer.parseInt(value));
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
	            }
	        }
	        else { 
	            return null;
	        }
	            
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
