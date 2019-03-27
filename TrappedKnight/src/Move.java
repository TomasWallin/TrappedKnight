
public class Move {
	
	public int x_move;
	public int y_move;
	public int value;
	public boolean visited;
	
	public Move(int x_move, int y_move,  int value, boolean visited) {
		this.x_move = x_move;
		this.y_move = y_move;
		this.value = value;
		this.visited = visited;
	}
	
	public String toString() {
		return String.valueOf(x_move) + " " + String.valueOf(y_move) + " " + String.valueOf(value) + " " + String.valueOf(visited);
	}
}
