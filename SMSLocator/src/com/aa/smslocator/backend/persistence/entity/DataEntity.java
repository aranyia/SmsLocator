package com.aa.smslocator.backend.persistence.entity;

import com.googlecode.objectify.annotation.Id;

public class DataEntity {
	@Id	Long id;
	
	protected DataEntity() {
	}
	public DataEntity(long id) {
		if(id > 0) this.id = id;
	}
}
