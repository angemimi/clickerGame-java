package com.angemimi.datas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.angemimi.classes.Game;
import com.angemimi.classes.Player;

public class Data {
	public static Map<UUID,Player> players = new HashMap<UUID, Player>();
	public static Map<UUID,Game> allGames = new HashMap<UUID,Game>();
}
