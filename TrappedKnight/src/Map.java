
public class Map {
	
	int horisontalSize = 250;
	int verticalSize = 250;
	Square[][] map = new Square[verticalSize][horisontalSize];
	int mapSize = horisontalSize * verticalSize;
	
	public Map() {
		enumerateMap();
	}
	
	public void enumerateMap() {
		
		int cursorHorisontal;
		int cursorVertical;
		if(horisontalSize % 2 == 0) {
		cursorHorisontal = (horisontalSize/2)-1;
		cursorVertical = (verticalSize/2)-1;
		} else {
		cursorHorisontal = (horisontalSize/2);
		cursorVertical = (verticalSize/2);
		}
		String currentDirection = "right";
		
		for(int i = 0; Square.total_squares < mapSize; i++) {
			switch (currentDirection) {
			case "right":
				for(int n = 0; n < i/2+1; n++) {
					map[cursorVertical][cursorHorisontal] = new Square(cursorVertical,cursorHorisontal);
					cursorVertical++;
					}
				currentDirection = nextDirection(currentDirection);
				break;
			case "left":
				for(int n = 0; n < i/2+1; n++) {
					map[cursorVertical][cursorHorisontal] = new Square(cursorVertical,cursorHorisontal);
					cursorVertical--;
					}
				currentDirection = nextDirection(currentDirection);
				break;
			case "up":
				for(int n = 0; n < i/2+1; n++) {
					map[cursorVertical][cursorHorisontal] = new Square(cursorVertical,cursorHorisontal);
					cursorHorisontal++;
					}
				currentDirection = nextDirection(currentDirection);
				break;
			case "down":
				for(int n = 0; n < i/2+1; n++) {
					map[cursorVertical][cursorHorisontal] = new Square(cursorVertical,cursorHorisontal);
					cursorHorisontal--;
					}
				currentDirection = nextDirection(currentDirection);
				break;
			}
			
		}
		
	}
	
	private String nextDirection(String currentDirection) {
		switch (currentDirection) {
		case "right":
			return "up";
		case "up":
			return "left";
		case "left":
			return "down";
		case "down":
			return "right";
			default:
				throw new RuntimeException("Input is not a correctly defined direction");
		}		
	}
	
	public int getMapSize() {
		return this.mapSize;
	}

}
