package adrar.bsarena.service;

import java.util.List;
import java.util.Random;

import adrar.bsarena.entity.Coordinates;
import adrar.bsarena.entity.CoordinatesMock;
import adrar.bsarena.entity.ShotResponse;

public class BattleShipPlayerMock implements BattleShipPlayer {

	private final String name;

	private final Random randomGenerator;

	private final static int NB_OF_POSSIBLE_SHOT_RESPONSES = ShotResponse.values().length;

	public BattleShipPlayerMock(String name) {
		this.name = name;
		this.randomGenerator = new Random();
	}

	@Override
	public void startNewGame() {
		// perfectly OK if empty
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Coordinates getNewShotCoordinates() {
		return new CoordinatesMock();
	}

	@Override
	public void setLastShotResponse(ShotResponse shotResponse) {
		// perfectly OK if empty
	}

	@Override
	public ShotResponse receiveShot(Coordinates shotCoordinates) {
		final int randomResponseIndex = this.randomGenerator.nextInt(NB_OF_POSSIBLE_SHOT_RESPONSES);
		return ShotResponse.values()[randomResponseIndex];
	}

	@Override
	public List<Coordinates> getAllShipCoordinates() {
		throw new UnsupportedOperationException("A coder, afin que l'arene puisse arbitrer (en vérifiant les coups)");
	}

}
