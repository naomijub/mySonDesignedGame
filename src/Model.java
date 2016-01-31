
public abstract class Model {
	int x, y, foffi, life, str1, str2;
	int[] screenData;
	int [][] animals;
	boolean dying, win, kill, hasPickaxe, hasSword, gotPickaxe, gotSword,
		up, down, right, left;
	
	public Model(){
		x = y = foffi = 0;
		life = 3;
		str1 = 1;
		str2 = 0;
		dying = win = kill = hasPickaxe = hasSword = down = right = left = false;
		up = true;
		screenData = new int [150];
		animals = new int[4][6];
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFoffi() {
		return foffi;
	}

	public void setFoffi(int foffi) {
		this.foffi = foffi;
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

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public int[][] getAnimals() {
		return animals;
	}

	public void setAnimals(int[][] animals) {
		this.animals = animals;
	}

	public boolean isGotPickaxe() {
		return gotPickaxe;
	}

	public void setGotPickaxe(boolean gotPickaxe) {
		this.gotPickaxe = gotPickaxe;
	}

	public boolean isGotSword() {
		return gotSword;
	}

	public void setGotSword(boolean gotSword) {
		this.gotSword = gotSword;
	}

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
