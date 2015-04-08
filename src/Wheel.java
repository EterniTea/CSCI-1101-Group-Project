public class Wheel {
	//one method "spin" that returns a prize 
	private String[] prize = new String[24];
	public Wheel(int r){
		prize[0] = "1000";
		prize[1] = "1000";
		prize[2] = "900";
		prize[3] = "900";
		prize[4] = "900";
		prize[5] = "800";
		prize[6] = "800";
		prize[7] = "800";
		prize[8] = "700";
		prize[9] = "700";
		prize[10] = "700";
		prize[11] = "600";
		prize[12] = "600";
		prize[13] = "600";
		prize[14] = "500";
		prize[15] = "500";
		prize[16] = "500";
		prize[17] = "100";
		prize[18] = "100";
		prize[19] = ""+(r*1000 + 1000);
		prize[20] = "Bankrupt";
		prize[21] = "Bankrupt";
		prize[22] = "Lose a turn";
		prize[23] = "Bankrupt/1000000/Lose a turn";
	}

	public String spin(){
		int prizeIndex = (int)(Math.random()*24);
		if (prizeIndex==23){
			int random = (int)(Math.random()*3);
			if (random==0)
				return "Bankrupt";
			else if (random==1)
				return "1000000";
			else 
				return "Lose a turn";
					
		}
		else
			return prize[prizeIndex];
	}
	
	
	
}