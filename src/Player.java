import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right,left;
	public int width,height;
	
	public int x,y;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
		
	}
	
	
	
	public void tick() {
		if(right) {
			x++;
		}else if(left) {
			x--;
			/*
		}if (up) {
			y--;
			}else if (down) {
				y++;
			}
			*/
		
		if (x+ width > Gamee.WIDTH) {
			 x = Gamee.WIDTH-width;
		}else if(x < 0) {
			x = 0;
		}
		/*
		if (y+10 > Gamee.HEIGHT) {
			y = Gamee.HEIGHT - 10;
		}else if (y < 0)
			y = 0;
			*/
		
	}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
	}

}
