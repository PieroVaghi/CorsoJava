package com.generation.common.model.entities;

import java.util.Map;

public interface Factory 
{
	//ricostruisce una entity a partire dal suo status
	IEntity make(Map<String,String> status) throws FactoryException;
	
	
}