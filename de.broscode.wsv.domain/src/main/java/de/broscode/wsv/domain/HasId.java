package de.broscode.wsv.domain;

import java.io.Serializable;

public interface HasId extends Serializable {
	void setId(Long id);
	Long getId();
}
