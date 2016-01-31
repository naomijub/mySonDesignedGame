import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ModelViewDialog extends JPanel{
	
	private int life, str1, str2;
	private String lifeStr = "You have " + life + " lives";
	private String dialogs[][] = {
			{"Break that rock!", "Kill that Spider!", "Kill that snake!", "Cut that old tree!"},
			{lifeStr, "Great Job!", "You found him!", "Beaware..."}
	};
	
	private Image digon, jujubs, dialog;
	
	private Timer timer;
	
	public ModelViewDialog(){
		//sets to life str
		str1 = 1; str2 = 0;
		life = 3;
		
		loadImages();
		
		setPreferredSize(new Dimension(900, 100));
    	setBackground(Color.BLACK);
        setFocusable(false);
        setDoubleBuffered(true);
		
		timer = new Timer(150, new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 repaint();
			 }
		});
	}
	
	public void loadImages(){
		ImageIcon iiDig = new ImageIcon("imagens/digon.png");
		digon = iiDig.getImage();
		
		ImageIcon iiJubs = new ImageIcon("imagens/jujubs.png");
		jujubs = iiJubs.getImage();
		
		ImageIcon iiAtt = new ImageIcon("imagens/dialog.png");
		dialog = iiAtt.getImage();
	}

	//paint set
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
	
	public void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		drawDialogs(g2d);
	}
	
	public void drawDialogs(Graphics2D g2d){
		
		g2d.setColor(Color.BLACK);
		g2d.drawRect(0, 0, 900, 81);
		g2d.fillRect(0, 0, 900, 81);
		
		if(str1 == 0){
			drawJujubs(g2d);
		}else{
			drawDigon(g2d);
		}
	}
	
	public void drawJujubs(Graphics2D g2d){
		Font font = new Font("Arial", Font.BOLD, 20);
		g2d.drawImage(jujubs, 0, 10, this);
		g2d.drawImage(dialog, 65, 0, this);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(font);
		g2d.drawString(dialogs[str1][str2], 110, 50);
	}
	
    public void drawDigon(Graphics2D g2d){
    	Font font = new Font("Arial", Font.BOLD, 20);
		g2d.drawImage(digon, 0, 10, this);
		g2d.drawImage(dialog, 65, 0, this);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(font);
		g2d.drawString(dialogs[str1][str2], 110, 50);
	}
	
    public void update(){
    	repaint();
    }
    
	//gets and sets
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getStr1() {
		return str1;
	}

	public void setStr1(int str1) {
		this.str1 = str1;
	}

	public int getStr2() {
		return str2;
	}

	public void setStr2(int str2) {
		this.str2 = str2;
	}
	
	

}
