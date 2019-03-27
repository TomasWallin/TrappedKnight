
public class Square {

	boolean visited = false;
	int x_axis;
	int y_axis;
	int seq_number;
	static int total_squares;
	
	public Square(int x_axis, int y_axis) {
		this.x_axis = x_axis;
		this.y_axis = y_axis;
		total_squares++;
		seq_number = total_squares;
		System.out.println("X="+x_axis+" Y="+y_axis+" n:"+seq_number);
	}
	
	public void setVisited() {
		visited = true;
	}
	
	public boolean getVisited() {
		return visited;
	}
}
