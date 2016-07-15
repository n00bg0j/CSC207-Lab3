package lab3;

import java.util.ArrayList;
import java.util.Random;

public class World {

	protected int width, height;
	protected Organism[][] map;
	protected ArrayList<Organism> living;

	protected World(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Organism[height][width];
		living = new ArrayList<Organism>();
		int choice;
		double empty;
		Random rand = new Random();
		Organism org;

		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++) {
				empty = rand.nextDouble();
				if (empty < 0.10) {
					choice = rand.nextInt(2);
					if (choice == 0)
						org = new Plant(i, j, this);
					else
						org = new Critter(i, j, this);
					map[i][j] = org;
					living.add(org);
				}
			}
	}

	public void turn() {
		// Your implementiation goes here
		
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				if (map[i][j] == null)
					result += ".";
				else
					result += map[i][j].type;
			result += "\n";
		}
		return result;
	}
}
