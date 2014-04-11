package de.broscode.wsv.services;

import java.util.List;

import de.broscode.wsv.domain.arzt.Arztpraxis;

public interface IArztService {
	boolean saveArztpraxis(Arztpraxis arztpraxis);
	boolean saveAllArztpraxen(List<Arztpraxis> arztpraxen);
}
