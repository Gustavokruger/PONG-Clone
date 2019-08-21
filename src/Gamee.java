import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Gamee extends Canvas implements Runnable, KeyListener {
	
	public static int WIDTH = 160;
    public static int HEIGHT = 120;
    public static int SCALE = 3;
    
    public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static Player player;
    public static Enemy enemy;
    public static Bola bola;
    
    public Gamee() {
    	this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
    	this.addKeyListener(this);
    	
    	
    	player = new Player(80, HEIGHT-5);
    	enemy = new Enemy(80,0);
    	bola = new Bola(50,60);
    	
    }
	
	public static void  main(String[] args) {
		Gamee game = new Gamee();
		JFrame frame = new JFrame("Pong"); 	
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();	
		
		
	}
	
	public void tick() {
		player.tick();
		enemy.tick();
		bola.tick();
		
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(g);
		enemy.render(g);
		bola.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null );
		
		bs.show();
	}
	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
 
}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		/*
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
			*/
				
		}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		/*
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
		*/
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
