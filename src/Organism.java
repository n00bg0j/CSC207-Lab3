import java.util.ArrayList;

public abstract class Organism {

	private final double INITIAL_ENERGY = 10;
	protected int xpos, ypos;
	protected double energy;
	protected World world;
	protected String type;

	protected Organism(int xpos, int ypos, World world, String type) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.energy = INITIAL_ENERGY;
		this.world = world;
		this.type = type;
	}

	protected ArrayList<int[]> getNeighbors() {
		ArrayList<int[]> result = new ArrayList<int[]>();
		int[] coord;
		int x, y;
		x = xpos - 1;
		y = ypos - 1;
		if (x >= 0 && y >= 0) {
			coord = new int[2];
			coord[0] = x;
			coord[1] = y;
			result.add(coord);
		}
		if (x >= 0) {
			coord = new int[2];
			coord[0] = x;
			coord[1] = ypos;
			result.add(coord);
		}
		y = ypos + 1;
		if (y < this.world.width && x >= 0) {
			coord = new int[2];
			coord[0] = x;
			coord[1] = y;
			result.add(coord);
		}
		y = ypos - 1;
		if (y >= 0) {
			coord = new int[2];
			coord[0] = xpos;
			coord[1] = y;
			result.add(coord);
		}
		y = ypos + 1;
		if (y < this.world.width) {
			coord = new int[2];
			coord[0] = xpos;
			coord[1] = y;
			result.add(coord);
		}
        y = ypos - 1;
        x = xpos + 1;
		if (x < this.world.height && y >=0 ) {
			coord = new int[2];
			coord[0] = x;
			coord[1] = y;
			result.add(coord);
		}
		if (x < this.world.height) {
			coord = new int[2];
			coord[0] = x;
			coord[1] = ypos;
			result.add(coord);
		}
		y = ypos + 1;
		if (y <this.world.width && x < this.world.height) {
			coord = new int[2];
			coord[0] = x;
			coord[1] = y;
			result.add(coord);
		}
		return result;
	}

	protected abstract void eat();

	protected abstract void move();

}
