package com.generation.firefighter.model.fireBL;

import java.util.List;

import com.generation.firefighter.model.entities.Fireman;

public interface FireBL 
{
	List<Fireman> firemans();
	Fireman load(int id);
	// Em salva qualunque cosa.
	Object save(Object obj);
	
}