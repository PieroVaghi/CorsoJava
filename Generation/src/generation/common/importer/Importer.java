package generation.common.importer;

import generation.common.entities.Entity;

public interface Importer<E extends Entity> 
{
	ImportResult<E> absorb();
	
}