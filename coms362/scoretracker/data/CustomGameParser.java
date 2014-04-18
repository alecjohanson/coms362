package coms362.scoretracker.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import coms362.scoretracker.model.GameEvent;

public class CustomGameParser {
	
	public static Object[] parseSport(String file) {
		BufferedReader br;
		Object[] ret = new Object[2];
		try {
			File input = new File(file);
			if (!input.exists())
				return ret;
			else
			{
				br = new BufferedReader(new FileReader(input));
				String sport = br.readLine();
				br.close();
				String[] split = sport.split("=");
				ret[0] = split[0];
				ret[1] = (Long)Long.parseLong(split[1]) * 60000;
				return ret;
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public static List<GameEvent> parseEvents(String file) 
	{
		BufferedReader br;
		List<GameEvent> ret = new ArrayList<GameEvent>();
		try {
			File input = new File(file);
			if (!input.exists())
				return ret;
			else
			{
				String curLine;
				br = new BufferedReader(new FileReader(input));
				String sport = br.readLine();
				while ((curLine = br.readLine()) != null) {
					GameEvent toAdd = parseLine(curLine);
					toAdd.setSport(sport);
					ret.add(toAdd);
				}
				br.close();
				return ret;
			}
		} catch (NumberFormatException nex) {
			throw nex;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	private static GameEvent parseLine(String line) throws NumberFormatException {
		GameEvent ret = new GameEvent();
		String[] args = line.split("=");
		ret.setName(args[0]);
		ret.setPoints(Integer.parseInt(args[1]));
		return ret;
	}
	
}
