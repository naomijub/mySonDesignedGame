import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class View extends JPanel {
	//Board COnstants
	private final int BOARD_WIDTH = 900,
					BOARD_HEIGHT = 600,
					TILE_SIZE = 60,
					BLOCKS_X = 15,
					BLOCKS_Y = 10;
	
	
	//Images
	private Image attack, pick, blankTree, rock, tree, pickaxe, sword;
	private Image kinkin, kinSword, kinAttack, kinPick, foffonxio;
	private Image snakeUp, snakeUp2, snakeDown, snakeDown2, snakeLeft, snakeLeft2, snakeRight, snakeRight2;
	private Image spiderUp, spiderDown, spiderLeft, spiderRight;

	//player
	private int kinx, kiny, life, foffI;

	//Animals
	//{animal, x, y, dx, dy}
	private int[][] animals = {
			{1, 1, 1, 0, 1, 1},
			{0, 7, 4, 0, 1, 1},
			{0, 6, 7, 1, 0, 1},
			{1, 9, 1, 1, 0, 1}
	};
	
	//Map
	private int[] screenData;
	private final int[] map = {
			1, 1,  1,  1,  1,  1,  1,   1,   1,   1,   1,   1,  1,  1,  1,
			1, 0,  0,  0,  0,  2,  0,   0,  16,   1,   0,   0,  0,  0,  1,
			1, 0,  1,  1,  0,  1,  1,   1,   8,   1,   8,   1,  1,  8,  1,
			1, 0,  0,  1,  0,  0,  0,   1,   1,   1,   0,   1,  1, 64, 64,
			1, 0,  0,  1,  2,  1,  0,   0,   0,   2,   0,   0, 64, 64, 64,
			1, 0,  0,  1,  0,  1,  1,   0,   0,   1,   1,  64, 64, 64, 64,
			1, 0,  0,  1,  0,  8,  1,   0, 128, 128, 128, 128, 64, 64, 64,
			1, 0,  1,  1, 64, 64,  0, 128, 128, 128, 128, 128,  8, 64, 64,
			1, 0, 32, 64, 64, 64, 64, 128, 128, 128, 128,   8,  8,  8, 64,
			1, 1,  1, 64, 64, 64, 64,   1,   1,   1,   1,   1,  1,  1,  1 
	};
	
	//Bool
	private boolean gameOn, dying, win, kill, hasPickaxe, hasSword, gotSword, gotPickaxe,
					up, down, left, right;
	
	//Timer
	private Timer timer, timeAttack;
	
	public View(){
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    	setBackground(new Color(10, 220, 30));
        setFocusable(true);
        setDoubleBuffered(true);

        loadImages();
        initVar();
        initGame();
        timer.start();
	}
	
	//Constructor
	public void loadImages(){
		ImageIcon iiAtt = new ImageIcon("imagens/attack.png");
		attack = iiAtt.getImage();
		
		ImageIcon iiPick = new ImageIcon("imagens/pick.png");
		pick = iiPick.getImage();
		
		ImageIcon iiBT = new ImageIcon("imagens/blanktree.png");
		blankTree = iiBT.getImage();
		
		ImageIcon iiRock = new ImageIcon("imagens/rock.png");
		rock = iiRock.getImage();
		
		ImageIcon iiTree = new ImageIcon("imagens/tree.png");
		tree = iiTree.getImage();
		
		ImageIcon iiPX = new ImageIcon("imagens/pickaxe.png");
		pickaxe = iiPX.getImage();
		
		ImageIcon iiSw = new ImageIcon("imagens/sword.png");
		sword = iiSw.getImage();
		
		ImageIcon iiKin = new ImageIcon("imagens/kinkin.png");
		kinkin = iiKin.getImage();
		
		ImageIcon iiKS = new ImageIcon("imagens/kinsword.png");
		kinSword = iiKS.getImage();
		
		ImageIcon iiKA = new ImageIcon("imagens/kinattack.png");
		kinAttack = iiKA.getImage();
		
		ImageIcon iiKP = new ImageIcon("imagens/kinpickx.png");
		kinPick = iiKP.getImage();
		
		ImageIcon iiF = new ImageIcon("imagens/foffonxio.png");
		foffonxio = iiF.getImage();
		
		ImageIcon iiSU = new ImageIcon("imagens/snakeup.png");
		snakeUp = iiSU.getImage();
		
		ImageIcon iiSU2 = new ImageIcon("imagens/snakeup2.png");
		snakeUp2 = iiSU2.getImage();
		
		ImageIcon iiSD = new ImageIcon("imagens/snakedown.png");
		snakeDown = iiSD.getImage();
		
		ImageIcon iiSD2 = new ImageIcon("imagens/snakedown2.png");
		snakeDown2 = iiSD2.getImage();
		
		ImageIcon iiSR = new ImageIcon("imagens/snakeright.png");
		snakeRight = iiSR.getImage();
		
		ImageIcon iiSR2 = new ImageIcon("imagens/snakeright2.png");
		snakeRight2 = iiSR2.getImage();
		
		ImageIcon iiSL = new ImageIcon("imagens/snakeleft.png");
		snakeLeft = iiSL.getImage();
		
		ImageIcon iiSL2 = new ImageIcon("imagens/snakeleft2.png");
		snakeLeft2 = iiSL2.getImage();
		
		ImageIcon iiSpiderUp = new ImageIcon("imagens/spiderup.png");
		spiderUp = iiSpiderUp.getImage();
		
		ImageIcon iiSpiderDown = new ImageIcon("imagens/spiderdown.png");
		spiderDown = iiSpiderDown.getImage();
		
		ImageIcon iiSpiderRight = new ImageIcon("imagens/spiderright.png");
		spiderRight = iiSpiderRight.getImage();
		
		ImageIcon iiSpiderLeft = new ImageIcon("imagens/spiderleft.png");
		spiderLeft = iiSpiderLeft.getImage();
	}
	
	public void initVar(){

		kinx = 4;
		kiny = 3;
	    up = true;
	    down = false;
	    left = false;
	    right = false;
	    dying = false;
	    win = false;
	    kill = false;
	    hasPickaxe = false;
	    hasSword = false;
	    gotSword = false;
	    gotPickaxe = false;
	    
	    screenData = new int[BLOCKS_X * BLOCKS_Y];
	    
	    timer = new Timer(150, new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 repaint();
			 }
		});
	    
	    timeAttack = new Timer(120, new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 repaint();
			 }
		});
		
	}

	public void initGame(){
		life = 3;
		gameOn = true;
		initLevel();
		
	}
	
	//InitGame Set
	public void initLevel(){
		for(int i = 0;i < (BLOCKS_X * BLOCKS_Y);i++){
			screenData[i] = map[i];
		}
		
		placeFoffonxio();
		
		dying = false;
	}
	
	public void initLevelAux(){
		for(int i = 0;i < (BLOCKS_X * BLOCKS_Y);i++){
			screenData[i] = map[i];
		}
		
		gameOn = true;
		dying = false;
	}
	
	public void placeFoffonxio(){
		int timeSeed = (int) System.currentTimeMillis() / 1000;
		Random rg = new Random(timeSeed);
		int aux = (rg.nextInt(131) % 8) + 1;
		int count = 0;
		
		for(int i = 0;i < screenData.length;i++){
			if((screenData[i] & 8) != 0){
				if(count == aux){
					foffI = i;
					screenData[i] += 4;
				}
				count++;
				
			}
		}
		
	}
	
	
	//Draw/paint block
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
	
	public void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		drawMap(g2d);
		
		if(gameOn){
			playGame(g2d);
		}else{
			if(life <= 0){
				drawGameOver(g2d);
			}
		}
	}
	
	//doDrawing
	public void drawMap(Graphics2D g2d){		
		g2d.setColor(new Color(0, 200, 25));
        g2d.drawRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        g2d.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		
		
		for(int i = 0;i < screenData.length;i++){
			
			if ((screenData[i] & 1) != 0) { 
                drawTree(g2d, i);
            }
			if ((screenData[i] & 2) != 0) { 
                drawBlankTree(g2d, i);
            }
			if ((screenData[i] & 8) == 0 && (screenData[i] & 4) != 0) { 
                drawFoffonxio(g2d, i);
            }
			if ((screenData[i] & 8) != 0) { 
                drawRock(g2d, i);
            }
			if ((screenData[i] & 16) != 0) { 
                drawPickaxe(g2d, i);
            }
			if ((screenData[i] & 32) != 0) { 
                drawSword(g2d, i);
            }
			if ((screenData[i] & 64) != 0) { 
                drawWater(g2d, i);
            }
			if ((screenData[i] & 128) != 0) { 
                drawSand(g2d, i);
            }
			if ((screenData[i] & 256) != 0) {
				drawBlood(g2d, i);
			}			
		}
	}
	
	public void playGame(Graphics2D g2d){
		if(dying){
			die(g2d);
		}else{
			if(win){
				drawWin(g2d);
			}else{
				drawKin(g2d);
				attack(g2d);
				moveAnimal(g2d);
			}
		}
		
	}
	
	public void drawWin(Graphics2D g2d){
		String str = "YOU WIN!!!";
		Font font = new Font("Arial", Font.BOLD, 30);
		
		//background
		g2d.setColor(Color.CYAN);
		g2d.drawRect(324, 249, 250, 100);
		g2d.fillRect(324, 249, 250, 100);
		
		//string
		g2d.setColor(Color.RED);
		g2d.setFont(font);
		g2d.drawString(str, 361, 300);
	}
	
	public void drawGameOver(Graphics2D g2d){
		String str = "Game Over...";
		Font font = new Font("Arial", Font.BOLD, 30);
		
		//background
		g2d.setColor(Color.CYAN);
		g2d.drawRect(299, 249, 300, 100);
		g2d.fillRect(299, 249, 300, 100);
		
		//string
		g2d.setColor(Color.RED);
		g2d.setFont(font);
		g2d.drawString(str, 350, 331);
	}
	
	//drawMap
	public void drawTree(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(tree, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawBlankTree(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(blankTree, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawFoffonxio(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(foffonxio, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawRock(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(rock, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawPickaxe(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(pickaxe, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawSword(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(sword, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawWater(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.setColor(new Color(10, 20, 220));
		g2d.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		g2d.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
	
	public void drawSand(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.setColor(new Color(244, 237, 85));
		g2d.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		g2d.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
	
	public void drawBlood(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.setColor(new Color(255, 21, 21));
		g2d.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		g2d.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
	
	//playgame block
	public void die(Graphics2D g2d){
		life--;
		
		if(life == 0){
			gameOn = false;
			drawGameOver(g2d);
		}else{
			kinx = 4;
			kiny = 3;
			initLevelAux();
		}
	}
	
	public void drawKin(Graphics2D g2d){
		if(!hasPickaxe && !hasSword){
			g2d.drawImage(kinkin, kinx * TILE_SIZE, kiny * TILE_SIZE, this);
		}else{
			if(hasPickaxe){
				g2d.drawImage(kinPick, kinx * TILE_SIZE, kiny * TILE_SIZE, this);
			}
			if(hasSword){
				g2d.drawImage(kinSword, kinx * TILE_SIZE, kiny * TILE_SIZE, this);
			}
		}
	}
	
	public void attack(Graphics2D g2d){
		int i = kinx + (15 * kiny);
		if(kill){
			if(hasSword){
				timeAttack.start();
				if(up){
					drawAttack(g2d, (i - 15));
				}
				if(down){
					drawAttack(g2d, (i + 15));
				}
				if(right){
					drawAttack(g2d, (i + 1));
				}
				if(left){
					drawAttack(g2d, (i - 1));
				}
				timeAttack.restart();
				timeAttack.stop();
			}
			if(hasPickaxe){
				timeAttack.start();
				if(up){
					drawPick(g2d, (i - 15));
				}
				if(down){
					drawPick(g2d, (i + 15));
				}
				if(right){
					drawPick(g2d, (i + 1));
				}
				if(left){
					drawPick(g2d, (i - 1));
				}
				timeAttack.restart();
				timeAttack.stop();
			}
			kill = false;
		}
	}
	
	//this block is here for performance reasons
	public void moveAnimal(Graphics2D g2d){
		for(int i = 0;i < 4;i++){
			if(animals[i][5] == 1){
				boolean xDir = false;
				int dx = animals[i][3];
				int dy = 15 * animals[i][4];
				int pos = animals[i][1] + (15 * animals[i][2]);
				//if animals is snake
				if(animals[i][0] == 0){
					//if animal moves in x direction
					if(animals[i][4] == 0){
						xDir =true;
						//if hits something change direction
						if((screenData[pos + dx] & 1) != 0 || (screenData[pos + dx] & 2) != 0 
							|| (screenData[pos + dx] & 8) != 0 || (screenData[pos + dx] & 16) != 0
							|| (screenData[pos +dx] & 32) != 0 || (screenData[pos +dx] & 64) != 0){
							
							animals[i][3] = dx * (-1);
							animals[i][1] = animals[i][1] + animals[i][3];
						}else{
							animals[i][1] = animals[i][1] + animals[i][3];
						}
					}
					//y direction
					if(animals[i][3] == 0){
						//if hits something change direction
						if((screenData[pos + dy] & 1) != 0 || (screenData[pos + dy] & 2) != 0 
							|| (screenData[pos + dy] & 8) != 0 || (screenData[pos +dy] & 16) != 0
							|| (screenData[pos + dy] & 32) != 0 || (screenData[pos +dx] & 64) != 0){
						
							animals[i][4] = animals[i][4] * (-1);
							animals[i][2] = animals[i][2] +  animals[i][4];
						}else{
							animals[i][2] = animals[i][2] +  animals[i][4];
						}	
					}
					drawSnake(g2d, xDir, i);
				}
				//if animal is spider
				if(animals[i][0] == 1){
					//if animal moves in x direction
					if(animals[i][4] == 0){
						xDir = true;
						//if hits something change direction
						if((screenData[pos + dx] & 1) != 0 || (screenData[pos + dx] & 2) != 0 
							|| (screenData[pos + dx] & 8) != 0 || (screenData[pos + dx] & 16) != 0
							|| (screenData[pos + dx] & 32) != 0 || (screenData[pos +dx] & 64) != 0){
						
							animals[i][3] = dx * (-1);
							animals[i][1] = animals[i][1] + animals[i][3];
						}else{
							animals[i][1] = animals[i][1] + animals[i][3];
						}
					}
					//y direction
					//No spider on Y
					if(animals[i][3] == 0){
						//if hits something change direction
						if((screenData[pos + dy] & 1) != 0 || (screenData[pos + dy] & 2) != 0 
							|| (screenData[pos + dy] & 8) != 0 || (screenData[pos + dy] & 16) != 0
							|| (screenData[pos + dy] & 32) != 0 || (screenData[pos +dx] & 64) != 0){
						
							animals[i][4] = animals[i][4] * (-1);
							animals[i][2] = animals[i][2] + animals[i][4];
						}else{
							animals[i][2] = animals[i][2] + animals[i][4];
						}
					}
					drawSpider(g2d, xDir, i);
				}
				if(kinx == animals[i][1] && kiny == animals[i][2]){
					die(g2d);
				}
			}
		}	
	}
	
	//attack set
	public void drawAttack(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(attack, x * TILE_SIZE, y * TILE_SIZE, this);
	}
	
	public void drawPick(Graphics2D g2d, int i){
		int y = (int) i / 15;
		int x = i % 15;
		
		g2d.drawImage(pick, x * TILE_SIZE, y * TILE_SIZE, this);
	}
		
	//animal set
	public void drawSnake(Graphics2D g2d, boolean xDir, int i){
		int pos = animals[i][1] + (15 * animals[i][2]);
		int whichSnake = pos % 2;
		if(xDir){
			if(animals[i][3] == 1){
				if(whichSnake == 0){
					g2d.drawImage(snakeRight, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}else{
					g2d.drawImage(snakeRight2, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}
			}else{
				if(whichSnake == 0){
					g2d.drawImage(snakeLeft, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}else{
					g2d.drawImage(snakeLeft2, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}
			}
		}else{
			if(animals[i][4] == 1){
				if(whichSnake == 0){
					g2d.drawImage(snakeUp, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}else{
					g2d.drawImage(snakeUp2, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}
			}else{
				if(whichSnake == 0){
					g2d.drawImage(snakeDown, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}else{
					g2d.drawImage(snakeDown2, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
				}
			}
		}
	}
	
	public void drawSpider(Graphics2D g2d, boolean xDir, int i){
		if(xDir){
			if(animals[i][3] == 1){
				g2d.drawImage(spiderRight, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
			}else{
				g2d.drawImage(spiderLeft, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
			}
		}else{
			if(animals[i][4] == 1){
				g2d.drawImage(spiderUp, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
			}else{
				g2d.drawImage(spiderDown, animals[i][1] * TILE_SIZE, animals[i][2] * TILE_SIZE, this);
			}
		}
	}
	
	//Game func
	public void update(){
		repaint();
	}
	
	void addKeyListener(ActionListener e){
		addKeyListener(e);
	}
	
	//Gets e Sets
	public int getKinx() {
		return kinx;
	}

	public void setKinx(int kinx) {
		this.kinx = kinx;
	}

	public int getKiny() {
		return kiny;
	}

	public void setKiny(int kiny) {
		this.kiny = kiny;
	}

	public int getFoffI() {
		return foffI;
	}

	public void setFoffI(int foffI) {
		this.foffI = foffI;
	}

	public int[][] getAnimals() {
		return animals;
	}

	public void setAnimals(int[][] animals) {
		this.animals = animals;
	}

	public int[] getScreenData() {
		return screenData;
	}

	public void setScreenData(int[] screenData) {
		this.screenData = screenData;
	}

	public boolean isDying() {
		return dying;
	}

	public void setDying(boolean dying) {
		this.dying = dying;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isKill() {
		return kill;
	}

	public void setKill(boolean kill) {
		this.kill = kill;
	}

	public boolean isHasPickaxe() {
		return hasPickaxe;
	}

	public void setHasPickaxe(boolean hasPickaxe) {
		this.hasPickaxe = hasPickaxe;
	}

	public boolean isHasSword() {
		return hasSword;
	}

	public void setHasSword(boolean hasSword) {
		this.hasSword = hasSword;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isGotSword() {
		return gotSword;
	}

	public void setGotSword(boolean gotSword) {
		this.gotSword = gotSword;
	}

	public boolean isGotPickaxe() {
		return gotPickaxe;
	}

	public void setGotPickaxe(boolean gotPickaxe) {
		this.gotPickaxe = gotPickaxe;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
}
