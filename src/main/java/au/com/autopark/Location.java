package au.com.autopark;

public class Location {

	
	private Direction direction = Direction.N;
	private int v_axis = 0;
	private int h_axis = 0;

	public Location(int v_axis, int h_axis) {
		this.v_axis = v_axis;
		this.h_axis = h_axis;
	}

	public Location(Location parent) {
		this.v_axis = parent.getVAxis();
		this.h_axis = parent.getHAxis();
		this.direction = parent.getDirection();
	}

	public int getVAxis() {
		return v_axis;
	}

	public int getHAxis() {
		return h_axis;
	}

	public Direction getDirection() {
		return direction;
	}
        
	void forward() {
		if (direction == Direction.S) {
			v_axis--;
		} else if (direction == Direction.N) {
			v_axis++;
		} else if (direction == Direction.W) {
			h_axis--;
		} else if (direction == Direction.E) {
			h_axis++;
		}
	}

	
	void left() {
		direction = Direction.values()[direction.ordinal() == 0 ? 3 : direction.ordinal() - 1];
	}

	
	void right() {
		direction = Direction.values()[direction.ordinal() == 3 ? 0 : direction.ordinal() + 1];
	}

}
