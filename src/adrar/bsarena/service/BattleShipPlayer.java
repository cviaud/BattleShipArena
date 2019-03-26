package adrar.bsarena.service;

import adrar.bsarena.entity.ShotResponse;

import java.util.List;

import adrar.bsarena.entity.Coordinates;

public interface BattleShipPlayer {
	
	public void startNewGame();
	
	public String getName();
	
	public Coordinates getNewShotCoordinates();
	public void setLastShotResponse(ShotResponse shotResponse);
	
	public ShotResponse receiveShot(Coordinates shotCoordinates);
	
	public List<Coordinates> getAllShipCoordinates();
}
