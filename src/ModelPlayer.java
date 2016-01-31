
public class ModelPlayer extends Model{
	
	public ModelPlayer(){
		super();
		
	}
	
	public void moveUp(){
		int i = x + (15 * y);
		i -= 15;
		up = true;
		down = false;
		left = false;
		right = false;
		
		if((screenData[i] & 1) == 0 && (screenData[i] & 2) == 0 && (screenData[i] & 8) == 0){
			y = y - 1;
			if((screenData[i] & 4) != 0){ win = true; }
			if((screenData[i] & 16) != 0){ 
				gotPickaxe = true;
				screenData[i] -= 16; 
			}
			if((screenData[i] & 32) != 0){
				gotSword = true;
				screenData[i] -= 32;
						
			}
			if((screenData[i] & 64) != 0){
				dying = true;
			}
			
		}
	}
	
	public void moveDown(){
		int i = x + (15 * y);
		i += 15;
		up = false;
		down = true;
		left = false;
		right = false;
		
		if((screenData[i] & 1) == 0 && (screenData[i] & 2) == 0 && (screenData[i] & 8) == 0){
			y = y + 1;
			if((screenData[i] & 4) != 0){ 
				str1 = 1;
				str2 = 2;
				win = true; }
			if((screenData[i] & 16) != 0){ 
				gotPickaxe = true;
				screenData[i] -= 16;
				str1 = 1;
				str2 = 1;
			}
			if((screenData[i] & 32) != 0){
				gotSword = true;
				screenData[i] -= 32;
				str1 = 1;
				str2 = 1;
						
			}
			if((screenData[i] & 64) != 0){
				dying = true;
				str1 = 1;
				str2 = 3;
			}
			
		}
	}

	public void moveLeft(){
		int i = x + (15 * y);
		i -= 1;
		up = false;
		down = false;
		left = true;
		right = false;
		
		if((screenData[i] & 1) == 0 && (screenData[i] & 2) == 0 && (screenData[i] & 8) == 0){
			x = x - 1;
			if((screenData[i] & 4) != 0){ 
				win = true;
				str1 = 1;
				str2 = 2;	
			}
			if((screenData[i] & 16) != 0){ 
				gotPickaxe = true;
				screenData[i] -= 16; 
				str1 = 1;
				str2 = 1;
			}
			if((screenData[i] & 32) != 0){
				gotSword = true;
				screenData[i] -= 32;
				str1 = 1;
				str2 = 1;
						
			}
			if((screenData[i] & 64) != 0){
				dying = true;
				str1 = 1;
				str2 = 3;
			}
			
		}
	}
	
	public void moveRight(){
		int i = x + (15 * y);
		i += 1;
		up = false;
		down = false;
		left = false;
		right = true;
		
		if((screenData[i] & 1) == 0 && (screenData[i] & 2) == 0 && (screenData[i] & 8) == 0){
			x = x + 1;
			if((screenData[i] & 4) != 0){ 
				win = true;
				str1 = 1;
				str2 = 2;
			}
			if((screenData[i] & 16) != 0){ 
				gotPickaxe = true;
				screenData[i] -= 16; 
				str1 = 1;
				str2 = 1;
			}
			if((screenData[i] & 32) != 0){
				gotSword = true;
				screenData[i] -= 32;
				str1 = 1;
				str2 = 1;
						
			}
			if((screenData[i] & 64) != 0){
				dying = true;
				str1 = 1;
				str2 = 3;
			}
			
		}
	}
	
	public void lookUp(){
		up = true;
		down = false;
		left = false;
		right = false;
		int i = x + (15 * y);
		if((screenData[i - 15] & 4) != 0){ 
			str1 = 1;
			str2 = 2;
		}
	}
	
	public void lookDown(){
		up = false;
		down = true;
		left = false;
		right = false;
		int i = x + (15 * y);
		if((screenData[i + 15] & 4) != 0){ 
			str1 = 1;
			str2 = 2;
		}
	}
	
	public void lookRight(){
		up = false;
		down = false;
		left = false;
		right = true;
		int i = x + (15 * y);
		if((screenData[i + 1] & 4) != 0){ 
			str1 = 1;
			str2 = 2;
		}
	}
	
	public void lookLeft(){
		up = false;
		down = false;
		left = true;
		right = false;
		int i = x + (15 * y);
		if((screenData[i - 1] & 4) != 0){ 
			str1 = 1;
			str2 = 2;
		}
	}
	
	public void attack(){
		if(hasPickaxe || hasSword){
			kill = true;
			
			checkKill();
			checkTreeRock();
		}
	}

	public void noWeapon(){
		hasPickaxe = false;
		hasSword = false;
	}
	
	public void pickaxe(){
		if(gotPickaxe){
			hasPickaxe = true;
			hasSword = false;
		}
	}
	
	public void sword(){
		if(gotSword){
			hasPickaxe = false;
			hasSword = true;
		}	
	}
	
	public void checkKill(){
		if(hasSword){
			if(up){
				for(int i = 0; i < 4;i++){
					if(animals[i][1] == x && animals[i][2] == (y - 1)){
						animals[i][5] = 0;
						if(animals[i][0] == 1){
							str1 = 0;
							str2 = 1;
						}else{
							str1 = 0;
							str2 = 2;
						}
					}
				}
			}
		
			if(down){
				for(int i = 0; i < 4;i++){
					if(animals[i][1] == x && animals[i][2] == (y + 1)){
						animals[i][5] = 0;
						if(animals[i][0] == 1){
							str1 = 0;
							str2 = 1;
						}else{
							str1 = 0;
							str2 = 2;
						}
					}
				}
			}
		
			if(right){
				for(int i = 0; i < 4;i++){
					if(animals[i][1] == (x + 1) && animals[i][2] == y){
						animals[i][5] = 0;
						if(animals[i][0] == 1){
							str1 = 0;
							str2 = 1;
						}else{
							str1 = 0;
							str2 = 2;
						}
					}
				}
			}
		
			if(left){
				for(int i = 0; i < 4;i++){
					if(animals[i][1] == (x - 1) && animals[i][2] == y){
						animals[i][5] = 0;
						if(animals[i][0] == 1){
							str1 = 0;
							str2 = 1;
						}else{
							str1 = 0;
							str2 = 2;
						}
					}
				}
			}
		}
	}
	
	public void checkTreeRock(){
		int i = x + (15 * y);
		
		if(up){
			if(hasPickaxe){
				if((screenData[i - 15] & 8) != 0){
					screenData[i - 15] -= 8;
					str1 = 0;
					str2 = 0;
				}
			}
			if(hasSword){
				if((screenData[i - 15] & 2) != 0){
					screenData[i - 15] -= 2;
					str1 = 0;
					str2 = 3;
				}
			}
		}
		
		if(down){
			if(hasPickaxe){
				if((screenData[i + 15] & 8) != 0){
					screenData[i + 15] -= 8;
					str1 = 0;
					str2 = 0;
				}
			}
			if(hasSword){
				if((screenData[i + 15] & 2) != 0){
					screenData[i + 15] -= 2;
					str1 = 0;
					str2 = 3;
				}
			}
		}

		if(right){
			if(hasPickaxe){
				if((screenData[i + 1] & 8) != 0){
					screenData[i + 1] -= 8;
					str1 = 0;
					str2 = 0;
				}
			}
			if(hasSword){
				if((screenData[i + 1] & 2) != 0){
					screenData[i + 1] -= 2;
					str1 = 0;
					str2 = 3;
				}
			}
		}

		if(left){
			if(hasPickaxe){
				if((screenData[i - 1] & 8) != 0){
					screenData[i - 1] -= 8;
					str1 = 0;
					str2 = 0;
				}
			}
			if(hasSword){
				if((screenData[i - 1] & 2) != 0){
					screenData[i - 1] -= 2;
					str1 = 0;
					str2 = 3;
				}
			}
		}
	}
	
	public void checkFoffonxius(){
		int iFoff = x + (15 * y);
		if(iFoff == foffi){ win = true; }
	}
	
	
}
