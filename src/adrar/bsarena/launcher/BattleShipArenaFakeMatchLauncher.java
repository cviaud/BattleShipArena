package adrar.bsarena.launcher;

import adrar.bsarena.service.Arena;
import adrar.bsarena.service.BattleShipPlayer;
import adrar.bsarena.service.BattleShipPlayerMock;

public class BattleShipArenaFakeMatchLauncher {

	private static final int NB_MATCHS = 1000;

	private static final String CASTOR = "Castor";
	private static final String POLLUX = "Pollux";

	public static void main(String[] args) {

		BattleShipPlayer castorPlayer = new BattleShipPlayerMock(CASTOR);
		BattleShipPlayer polluxPlayer = new BattleShipPlayerMock(POLLUX);

		Arena arena = new Arena(castorPlayer, polluxPlayer);

		for (int i = 0; i < NB_MATCHS; i++) {
			arena.playOneGame();
		}

		System.out.println(castorPlayer.getName() +" => : " + arena.getPlayer1Score());
		System.out.println(polluxPlayer.getName() +" => : " + arena.getPlayer2Score());
	}

}
