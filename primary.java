import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class primary extends JPanel implements MouseListener{
	static JFrame frame = new JFrame();
	private static int x =-100,y =100 ;
	static JTextField field;
	static JLabel label = new JLabel();
	
	private static boolean running = true;
	
	public void createFrame() {
		frame.setSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		label.setBounds(200,420,100,50);
		this.addMouseListener(this);
		this.setLayout(null);
		this.add(label);
		
		frame.add(this);
		frame.setVisible(true);
	}
												public static primary p = new primary();
												
	
	protected int[][] winPos = {
			{1,2,3},	
			{4,5,6},	
			{7,8,9},	
			{1,4,7},	
			{2,5,8},	
			{3,6,9},	
			{1,5,9},	
			{3,5,7}	
	
	};
	
	private int[] rand = {1,5,3,4,2};
	public void sorting(int[] x) {
		Arrays.sort(x);
	}
	
	
	
											
	public static void main(String[] args) {
		p.createFrame();
		Thread t = new Thread(new render());
		t.start();
		
	}
	
	
	private int copyx,copyy;
	
	private int count=0;
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX() - 25;
		y = e.getY() -25;
		if(count % 2 == 0) {
			//label.setText("Player 2's turn");
			turn = 1;
			checkPos(x,y,1);
			count++;
		}
		else {
			turn = 2;
			//label.setText("Player 1's turn");
			checkPos(x,y,2);
			count++;
			copyx = x;
			copyy = y;
		}
		
		
	}
	
	public void setRun(boolean k) {
		running = k;
	}
	
	Random r = new Random();
	
	
	private int turn = 1;
	
	public void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		if(turn == 1) {
			g.fillRect(150, 50, 5, 300);
			g.fillRect(300, 50, 5, 300);
			g.fillRect(80, 130, 300, 5);
			g.fillRect(80, 250, 300, 5);
			g.setColor(Color.RED);
			g.fillRect(x, y, 50, 50);

			turn = 3;
		}
		else if (turn == 2) {
			gg.setColor(Color.BLUE);
			Ellipse2D ell = new Ellipse2D.Double(x,y,50,50);
			gg.fill(ell);
			turn = 3;
			x = copyx;
			y = copyy;
		}
		
		
		
		
		
		
	}
	
	public boolean getRun() {
		return running;
	}
	
	private int i1 = 0;
	private int i2 = 0;
	protected int[] playerPos = new int[15];
	protected int[] botPos = new int[9];
	
	
																								//1 = player 
																								//2 = bot
	
	
	public void checkPos(int x,int y,int player) {
		if(x<130) {
			if(y <150) {
				this.x = 85;
				this.y = 65;
				if(player == 1) {
					playerPos[i1] = 1;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 1;
					i2++;
				}
			}else if(y < 250 ) {
				this.x = 85;
				this.y = 170;
				if(player == 1) {
					playerPos[i1] = 4;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 4;
					i2++;
				}
			}else{
				this.x = 85;
				this.y = 280;
				if(player == 1) {
					playerPos[i1] = 7;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 7;
					i2++;
				}
				
			}
		}else if(x < 300) {
			if(y <150) {
				this.x = 200;
				this.y = 65;
				if(player == 1) {
					playerPos[i1] = 2;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 2;
					i2++;
				}
			}else if(y < 250 ) {
				this.x = 200;
				this.y = 170;
				if(player == 1) {
					playerPos[i1] = 5;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 5;
					i2++;
				}
			}else{
				this.x = 200;
				this.y = 280;
				if(player == 1) {
					playerPos[i1] = 8;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 8;
					i2++;
				}
			}
		}else {
			if(y <150) {
				this.x = 330;
				this.y = 65;
				if(player == 1) {
					playerPos[i1] = 3;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 3;
					i2++;
				}
			}else if(y < 250 ) {
				this.x = 330;
				this.y = 170;
				if(player == 1) {
					playerPos[i1] = 6;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 6;
					i2++;
				}
			}else{
				this.x = 330;
				this.y = 280;
				if(player == 1) {
					playerPos[i1] = 9;
					i1++;
				}
				else if(player == 2) {
					botPos[i2] = 9;
					i2++;
				}
				playerPos[i1] = 9;
				i1++;
			}
		}
		
		
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}
