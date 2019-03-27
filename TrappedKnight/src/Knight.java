
public class Knight {
	
	private int x_axis;
	private int y_axis;
	private int n;
	Map map;
	
	public Knight(Map map) {
		x_axis = 0;
		y_axis = 0;
		n = 0;
		this.map = map;
	}
	
	public void traverse() {
		int cursorHorisontal;
		int cursorVertical;
		if(map.horisontalSize % 2 == 0) {
			cursorHorisontal = (map.horisontalSize/2)-1;
			cursorVertical = (map.verticalSize/2)-1;
		} else {
			cursorHorisontal = map.horisontalSize/2;
			cursorVertical = map.verticalSize/2;
		}
		Move moves[];
		Move next_move;
		for(;;) {
			map.map[cursorHorisontal][cursorVertical].setVisited();
			moves = possibleMoves(cursorHorisontal, cursorVertical);
			next_move = correctMove(moves);
			if(next_move == null) {
				System.out.println("The knight has stopped at X:"+x_axis+" Y:"+y_axis+" after "+n+"moves");
				break;
			} else {
				x_axis += next_move.x_move;
				y_axis += next_move.y_move;
				cursorHorisontal += next_move.x_move;
				cursorVertical += next_move.y_move;
				n++;
				System.out.println("Knight moved to X:"+x_axis+" Y:"+y_axis+" value:"+next_move.value+" n:"+n);
			}
		}
	}
	
	public void traverseN(int input) {
		int cursorHorisontal;
		int cursorVertical;
		int iterations = 0;
		if(map.horisontalSize % 2 == 0) {
			cursorHorisontal = (map.horisontalSize/2)-1;
			cursorVertical = (map.verticalSize/2)-1;
		} else {
			cursorHorisontal = map.horisontalSize/2;
			cursorVertical = map.verticalSize/2;
		}
		Move moves[];
		Move next_move;
		Move future_moves[];
		Move  future_next_move;
		for(;iterations < input;) {
			map.map[cursorHorisontal][cursorVertical].setVisited();
			moves = possibleMoves(cursorHorisontal, cursorVertical);
			next_move = correctMove(moves);
			if(next_move == null) {
				System.out.println("next_move == null. cursorH:"+cursorHorisontal+" cursorV:"+cursorVertical);
				break;
			}
			future_moves = possibleMoves(cursorHorisontal+next_move.x_move, cursorVertical+next_move.y_move);
			future_next_move = correctMove(future_moves);
			if(future_next_move == null) {
				System.out.println("You will reach a termination point at x:"
						+ ""+x_axis+next_move.x_move+" y:"
						+y_axis+x_axis+next_move.x_move+" n:"
						+(n+1));
				map.map[cursorHorisontal+next_move.x_move][cursorVertical+next_move.y_move].setVisited();
				iterations++;
				continue;
			}
			x_axis += next_move.x_move;
			y_axis += next_move.y_move;
			cursorHorisontal += next_move.x_move;
			cursorVertical += next_move.y_move;
			n++;
		}
	}
	
	private Move[] possibleMoves(int cursorHorisontal, int cursorVertical) throws ArrayIndexOutOfBoundsException {
		Move moves[] = new Move[8];
		try {
			moves[0] = new Move(1, -2, map.map[cursorHorisontal+1][cursorVertical-2].seq_number, map.map[cursorHorisontal+1][cursorVertical-2].getVisited());
			moves[1] = new Move(2, -1, map.map[cursorHorisontal+2][cursorVertical-1].seq_number, map.map[cursorHorisontal+2][cursorVertical-1].getVisited());
			moves[2] = new Move(2, 1, map.map[cursorHorisontal+2][cursorVertical+1].seq_number, map.map[cursorHorisontal+2][cursorVertical+1].getVisited());
			moves[3] = new Move(1, 2, map.map[cursorHorisontal+1][cursorVertical+2].seq_number, map.map[cursorHorisontal+1][cursorVertical+2].getVisited());
			moves[4] = new Move(-1, 2, map.map[cursorHorisontal-1][cursorVertical+2].seq_number, map.map[cursorHorisontal-1][cursorVertical+2].getVisited());
			moves[5] = new Move(-2, 1, map.map[cursorHorisontal-2][cursorVertical+1].seq_number, map.map[cursorHorisontal-2][cursorVertical+1].getVisited());
			moves[6] = new Move(-2, -1, map.map[cursorHorisontal-2][cursorVertical-1].seq_number, map.map[cursorHorisontal-2][cursorVertical-1].getVisited());
			moves[7] = new Move(-1, -2, map.map[cursorHorisontal-1][cursorVertical-2].seq_number, map.map[cursorHorisontal-1][cursorVertical-2].getVisited());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The Knight is at the edge of the map");
		}
		return moves;
	}
	
	private Move correctMove(Move[] moves) {
		Move return_move = null;
		for(int i = 0; i < moves.length; i++) {
			if(!moves[i].visited) {
				if(return_move != null) {
					if(moves[i].value < return_move.value)
						return_move = moves[i];
				} else return_move = moves[i];
			}
		}
		return return_move;
	}
	
}
