package com.generation.shampoo.model.statistics;

import java.util.Map;

public interface Statistics 
{

	Map<String,Double> avgPriceByProducer();
	
	Map<String,Double> deltaBio();
	
}