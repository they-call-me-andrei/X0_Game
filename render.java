
public class render implements Runnable {
	primary pm = new primary();
	private boolean gata = true,ok = true;
	private int cont,cont1;
	
	public void run() {
		while(pm.p.getRun() == true) {
			if(pm.p.frame.isActive() == false) {
				pm.p.setRun(false);
			}
			pm.p.repaint();
			for(int i = 0;(i<8)&&ok&&gata;i++) {
				cont = 0;
				cont1 = 0;
				for(int j = 0;(j<9)&&gata;j++) {
					for(int z = 0;(z<3)&&gata;z++) {
						if(pm.p.playerPos[j] == pm.p.winPos[i][z]) {
							cont++;
							if(cont == 3) {
								ok = false;
								System.out.println("WIN PLAYER 1");
								//pm.p.frame.setVisible(false);
								//pm.p.setRun(false);								
							}
						}
						if(pm.p.botPos[j] == pm.p.winPos[i][z]) {
							cont1++;
							if(cont1 == 3) {
								gata = false;
								System.out.println("WIN PLAYER 2");
								//pm.p.frame.setVisible(false);
								//pm.p.setRun(false);

							}
						}
						
					}
				}
			}
			
		}
		
		
	}
}
