import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller {

	private View board;
	private ModelPlayer player;
	private ModelViewDialog dialog;
	
	public Controller(View board, ModelPlayer player, ModelViewDialog dialog){
		this.board = board;
		this.player = player;
		this.dialog = dialog;
		
		insertValues();
		
		this.board.addKeyListener(new TAdapter());
	}
	
	public void insertValues(){
		player.setX(board.getKinx());
		player.setY(board.getKiny());
		player.setFoffi(board.getFoffI());
		player.setLife(board.getLife());
		player.setScreenData(board.getScreenData());
		player.setAnimals(board.getAnimals());
		
		player.setDown(board.isDown());
		player.setUp(board.isUp());
		player.setRight(board.isRight());
		player.setLeft(board.isLeft());
		
		player.setDying(board.isDying());
		player.setWin(board.isWin());
		player.setKill(board.isKill());
		player.setHasPickaxe(board.isHasPickaxe());
		player.setHasSword(board.isHasSword());
		player.setGotPickaxe(board.isGotPickaxe());
		player.setGotSword(board.isGotSword());
		
		dialog.setLife(board.getLife());
		dialog.setStr1(player.getStr1());
		dialog.setStr2(player.getStr2());
		dialog.update();
		
	}
	
	public void updateValues(){
		board.setKinx(player.getX());
		board.setKiny(player.getY());
		board.setFoffI(player.getFoffi());
		board.setLife(player.getLife());
		board.setScreenData(player.getScreenData());
		board.setAnimals(player.getAnimals());
		
		board.setUp(player.isUp());
		board.setDown(player.isDown());
		board.setRight(player.isRight());
		board.setLeft(player.isLeft());
		
		board.setDying(player.isDying());
		board.setWin(player.isWin());
		board.setKill(player.isKill());
		board.setHasPickaxe(player.isHasPickaxe());
		board.setHasSword(player.isHasSword());
		board.setGotPickaxe(player.isGotPickaxe());
		board.setGotSword(player.isGotSword());
		
		dialog.setLife(board.getLife());
		dialog.setStr1(player.getStr1());
		dialog.setStr2(player.getStr2());
		dialog.update();
	}
	
	class TAdapter implements KeyListener{

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if ((key == KeyEvent.VK_UP)) {
				insertValues();
	            player.moveUp();
	            player.checkFoffonxius();
	            updateValues();
	            board.update();
	        }
			
			if ((key == KeyEvent.VK_DOWN)) {
				insertValues();
				player.moveDown();
				player.checkFoffonxius();
            	updateValues();
            	board.update();
	        }
			
			if ((key == KeyEvent.VK_LEFT)) {
				insertValues();
				player.moveLeft();
				player.checkFoffonxius();
            	updateValues();
            	board.update();
	        }
			
			if ((key == KeyEvent.VK_RIGHT)) {
				insertValues();
				player.moveRight();
				player.checkFoffonxius();
            	updateValues();
            	board.update();
	        }
			
			if(key == KeyEvent.VK_I){
				insertValues();
				player.lookUp();
				updateValues();
				board.update();
			}
			
			if(key == KeyEvent.VK_K){
				insertValues();
				player.lookDown();
				updateValues();
				board.update();
			}
			
			if(key == KeyEvent.VK_L){
				insertValues();
				player.lookRight();
				updateValues();
				board.update();
			}
			
			if(key == KeyEvent.VK_J){
				insertValues();
				player.lookLeft();
				updateValues();
				board.update();
			}
			
			if(key == KeyEvent.VK_SPACE){
				insertValues();
				player.attack();
				updateValues();
				//board.update();
			}
			
			if(key == KeyEvent.VK_A){
				insertValues();
				player.noWeapon();
				updateValues();
				board.update();
			}
			if(key == KeyEvent.VK_S){
				insertValues();
				player.sword();
				updateValues();
				board.update();
			}
			if(key == KeyEvent.VK_D){
				insertValues();
				player.pickaxe();
				updateValues();
				board.update();
			}
			
			
		}

		public void keyReleased(KeyEvent e) {
			
		}

		public void keyTyped(KeyEvent e) {
			
		}

	
		
	}
}
