package adrar.bsarena.service;

import adrar.bsarena.entity.Coordinates;
import adrar.bsarena.entity.ShotResponse;

public class Arena {

	private static final int NB_SHIPS_ON_START = 5;

	private BattleShipPlayer castorPlayer;
	private BattleShipPlayer polluxPlayer;

	private int castorScore;
	private int castorFloatingShips;

	private int polluxScore;
	private int polluxFloatingShips;

	public int getPlayer1Score() {
		return castorScore;
	}

	public int getPlayer2Score() {
		return polluxScore;
	}

	public Arena(BattleShipPlayer castor, BattleShipPlayer pollux) {
		super();
		castorPlayer = castor;
		polluxPlayer = pollux;
	}

	public void playOneGame() {
		castorFloatingShips = NB_SHIPS_ON_START;
		polluxFloatingShips = NB_SHIPS_ON_START;

		castorPlayer.startNewGame();
		polluxPlayer.startNewGame();

		while (bothPlayersStillHaveShips()) {
			// Attaque de CASTOR
			Coordinates castorShotCoordinates = castorPlayer.getNewShotCoordinates();
			ShotResponse polluxShotResponse = polluxPlayer.receiveShot(castorShotCoordinates);
			castorPlayer.setLastShotResponse(polluxShotResponse);
			if (polluxShotResponse == ShotResponse.SUNK) {
				polluxFloatingShips--;
			}

			// Attaque de POLLUX
			Coordinates polluxShotCoordinates = polluxPlayer.getNewShotCoordinates();
			ShotResponse castorShotResponse = castorPlayer.receiveShot(polluxShotCoordinates);
			polluxPlayer.setLastShotResponse(castorShotResponse);
			if (castorShotResponse == ShotResponse.SUNK) {
				castorFloatingShips--;
			}
		}

		calculateNewScores();

	}

	private void calculateNewScores() {
		if (castorFloatingShips == 0)
			polluxScore++;
		if (polluxFloatingShips == 0)
			castorScore++;
	}

	private boolean bothPlayersStillHaveShips() {
		return (castorFloatingShips > 0 && polluxFloatingShips > 0);
	}

}
