import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola {
	

	public double x,y;
	public int width, height;
	
	public double dx, dy;
	public double velo = 2.4;
	
	public Bola(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 2;
		this.height = 2;
		
		int angle = new Random().nextInt(120-45)+45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
		
		
				
	}
	
	public void tick() {
		
		if(x+(dx*velo) + width >= Gamee.WIDTH) {
			dx*= -1;
			
		}else if(x+(dx*velo) < 0) {
			dx*= -1;
		}
		if(y> Gamee.HEIGHT) {
			System.out.println("ponto deles");
			new Gamee();
			return;
	}else if (y<0) {
		System.out.println("Tudo nosso");
		new Gamee();
		return;
	}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*velo)),(int)(y+(dy*velo)),width, height);
		Rectangle boundsPlayer = new Rectangle(Gamee.player.x, Gamee.player.y,(int) Gamee.player.width,Gamee.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Gamee.enemy.x,(int) Gamee.enemy.y, (int)Gamee.enemy.width, (int)Gamee.enemy.height);
	
		if(bounds.intersects(boundsPlayer)) {
			
			dy*= -1;
			
		}else if (bounds.intersects(boundsEnemy)) {
			dy*= -1;
		}
		x+=dx*velo;
		y+=dy*velo;
		
	}

	
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int)y, width, height);
	
	}
}
	

