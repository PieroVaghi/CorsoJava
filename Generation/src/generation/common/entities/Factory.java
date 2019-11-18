package generation.common.entities;

import java.util.Map;

public interface Factory 
{
	//ricostruisce una entity a partire dal suo status
	Entity make(Map<String,String> status) throws FactoryException;
	
	
}