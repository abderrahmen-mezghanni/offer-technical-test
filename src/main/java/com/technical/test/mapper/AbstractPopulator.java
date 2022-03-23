package com.technical.test.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.technical.test.dto.AbstractModel;
import com.technical.test.entity.AbstractEntity;


public abstract class AbstractPopulator <E extends AbstractEntity, M extends AbstractModel>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPopulator.class);
	
	private final String DATE_FORMAT = "dd/MM/yyyy";
	
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);	
	
	/**
	 * this abstract method is used to create new model based on entity
	 * 
	 * @param entity
	 * @return model
	 */
	public abstract M toModel(E entity);
	
	/**
	 * this abstract method create new entity based on model
	 * 
	 * @param model
	 * @return entity
	 */
	public abstract E toEntity(M model);
	
	/**
	 * this abstract method is used to update entity based on informations from model
	 * 
	 * @param model
	 * @param entity
	 * @return updated entity
	 */
	public abstract E updateToEntity(M model, E entity);
		
	public List<M> populateList(List<E> entityList) {
		List<M> modelList = new ArrayList<>();
		for (E entity : entityList) {
			modelList.add(toModel(entity));
		}
		return modelList;
	}
	
	public Set<M> populateSet(Set<E> entitySet) {
		Set<M> modelSet = new HashSet<>();
		for (E entity : entitySet) {
			modelSet.add(toModel(entity));
		}
		return modelSet;
	}
	
	public <K> Map<K, M> populateMap(Map<K, E> entityMap) {
		Map<K, M> modelMap = new HashMap<>();
		for (Map.Entry<K, E> entry : entityMap.entrySet()) {
			modelMap.put(entry.getKey(), toModel(entry.getValue()));
		}
		return modelMap;
	}
	
	public List<E> populateFrommodelList(List<M> modelList) {
		List<E> entityList = new ArrayList<>();
		for (M model : modelList) {
			entityList.add(toEntity(model));
		}
		return entityList;
	}
	
	public Set<E> populateFrommodelSet(Set<M> modelSet) {
		Set<E> entitySet = new HashSet<>();
		for (M model : modelSet) {
			entitySet.add(toEntity(model));
		}
		return entitySet;
	}
	
	public <K> Map<K, E> populateFrommodelMap(Map<K, M> modelMap) {
		Map<K, E> entityMap = new HashMap<>();
		for (Map.Entry<K, M> model : modelMap.entrySet()) {
			entityMap.put(model.getKey(), toEntity(model.getValue()));
		}
		return entityMap;
	}
	
	/**
	 * Parse date based on String from model
	 * @param date
	 * @return
	 */
	public Calendar populateDateFrommodel(String date){
		Calendar calendar = Calendar.getInstance();
		if (date!=null){
			try {			
				calendar.setTime(dateFormatter.parse(date));
				return calendar;
			} catch (ParseException e) {
				LOGGER.warn(e.getMessage());
				return null;
			}
		} else {
			return null;
		}		
	}
	
	/**
	 * populate date to be send in model
	 * @param date
	 * @return
	 */
	public String populateDate(Calendar date) {
		String formattedDate = null;
		if (date != null) {
			formattedDate = dateFormatter.format(date.getTime());
		}
		return formattedDate;
	}
	
	/**
	 * populate date based on Java 8 Api 
	 * @param date
	 * @return
	 */
	public LocalDate populateDate(String date) {
		return  LocalDate.parse(date);
	}
	
}
