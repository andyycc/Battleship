package battleship;

public class Board {
	private int[][] board = new int[10][10];
	private int r1;
	private int c1;
	private int r2;
	private int c2;
	private boolean validCarrier=false,validBattleship=false,validCruiser=false,validSubmarine=false,validDestroyer = false;
	private boolean Attack=false;
	public void setBoard() {
		for (int i= 0; i<10 ; i++) {
			for (int j = 0 ; j<10 ; j++) {
				board [i][j] = 0;
			}
		}
	}
	
	public String[][] printBoard(){
		String[][] pb = new String [11][11];
		pb[0][0] = " ";
		for (int i =1 ; i<11 ; i++) {
			int INT = 64 + i;
			pb[i][0] = Character.toString((char)INT);
			int I = 48 + i;
			pb[0][i] = Character.toString((char)I);
			for (int j = 1 ; j<11 ; j++) {
			  if (board[i-1][j-1]==0 || board[i-1][j-1]==3 ) {
				pb[i][j] = "~";  
			  }
			  else if (board[i-1][j-1]==1) {
			    pb[i][j] = "M";
			  }
			  else if (board[i-1][j-1]==2) {
			    pb[i][j] = "X";
			  }
			}
			
		}
		pb[0][10] = "10";
		
		for (int i = 0; i < 11 ; i++) {
			for (int j = 0 ; j < 11 ; j++) {
				System.out.print(pb[i][j]+"    ");
			}
		System.out.println("\n");
		}
		return pb;
	}
	
	
	

	public void setShip(String rc1, String rc2, int size) {
	  validCarrier = true;
	  if (!valid(rc1,rc2)) {
		  validCarrier = false;
		  return;
	  }
	  if (((r1-r2)!=0 && (c1-c2)!=0) || ((r1-r2)==0 && (c1-c2)==0)) {
		  System.out.println("Not Straight");
		  return;
	  }
	  if ((r1-r2)==0) {
		  if ((c1-c2)==size || (c2-c1)==size) {
			  if (c1>c2) {
			    for (int i = c2-1 ; i <c1 ; i++) {
			    	board[r1-1][i]=3;
			    }
			    return;
			  }
			  else {
			    for (int i = c1-1 ; i <c2; i++) {
			    	board[r1-1][i]=3;
			    }
			    return;
			  }
		  }
	  }
	  else if ((c1-c2)==0) {
		  if ((r1-r2)==size || (r2-r1)==size) {
			  if (r1>r2) {
				    for (int i = r2-1 ; i <r1 ; i++) {
				    	board[i][c1-1]=3;
				    }
				    return;
				  }
				  else {
				    for (int i = r1-1 ; i <r2; i++) {
				    	board[i][c1-1]=3;
				    }
				    return;
				  }
		  }
	  }
	  
	  System.out.println("Length is not valid");
	  validCarrier = false;
	  
	}
	
	public boolean getValidShip() {
		return validCarrier;
	}
	
	public void setValidShip(boolean truth) {
		validCarrier = false;
	}
	
	/*public void setBattleship(String rc1, String rc2) {
		validBattleship = true;
		  if (!valid(rc1,rc2)) {
			  validBattleship = false;
			  return;
		  }
		  if (((r1-r2)!=0 && (c1-c2)!=0) || ((r1-r2)==0 && (c1-c2)==0)) {
			  System.out.println("Not Straight");
			  return;
		  }
		  if ((r1-r2)==0) {
			  if ((c1-c2)==3 || (c2-c1)==3) {
				  if (c1>c2) {
					for (int i = c2-1 ; i<c1 ; i++) {
						if (board[r1-1][i]==3) {
							System.out.println("Overlap with another ship. Re-Enter.");
							validBattleship = false; 
							return;
						}
					}
				    for (int i = c2-1 ; i <c1 ; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
				  else {
					  for (int i = c1-1 ; i<c2 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validBattleship = false; 
								return;
							}
						}
				    for (int i = c1-1 ; i <c2; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
			  }
		  }
		  else if ((c1-c2)==0) {
			  if ((r1-r2)==3 || (r2-r1)==3) {
				  if (r1>r2) {
					  for (int i = r2-1 ; i<r1 ; i++) {
							if (board[i][c1-1]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validBattleship = false; 
								return;
							}
						}
					    for (int i = r2-1 ; i <r1 ; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
					  else {
						  for (int i = r1-1 ; i<r2 ; i++) {
								if (board[i][c1-1]==3) {
									System.out.println("Overlap with another ship. Re-Enter.");
									validBattleship = false; 
									return;
								}
							}
					    for (int i = r1-1 ; i <r2; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
			  }
		  }
		  System.out.println("Length is not 4");
		  validBattleship = false;
		}
	
	public boolean getValidBattleship() {
		return validBattleship;
	}
	
	public void setValidBattleship(boolean truth) {
		validBattleship = truth;
	}
	
	public void setCruiser(String rc1, String rc2) {
		validCruiser = true;
		  if (!valid(rc1,rc2)) {
			  validCruiser = false;
			  return;
		  }
		  if (((r1-r2)!=0 && (c1-c2)!=0) || ((r1-r2)==0 && (c1-c2)==0)) {
			  System.out.println("Not Straight");
			  return;
		  }
		  if ((r1-r2)==0) {
			  if ((c1-c2)==2 || (c2-c1)==2) {
				  if (c1>c2) {
					  for (int i = c2-1 ; i<c1 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validCruiser = false; 
								return;
							}
						}
				    for (int i = c2-1 ; i <c1 ; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
				  else {
					  for (int i = c1-1 ; i<c2 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validCruiser = false; 
								return;
							}
						}
				    for (int i = c1-1 ; i <c2; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
			  }
		  }
		  else if ((c1-c2)==0) {
			  if ((r1-r2)==2 || (r2-r1)==2) {
				  if (r1>r2) {
					  for (int i = r2-1 ; i<r1 ; i++) {
							if (board[i][c1-1]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validCruiser = false; 
								return;
							}
						}
					    for (int i = r2-1 ; i <r1 ; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
					  else {
						  for (int i = r1-1 ; i<r2 ; i++) {
								if (board[i][c1-1]==3) {
									System.out.println("Overlap with another ship. Re-Enter.");
									validCruiser = false; 
									return;
								}
							}
					    for (int i = r1-1 ; i <r2; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
			  }
		  }
		  System.out.println("Length is not 3");
		  validCruiser = false;
		}
	
	public boolean getValidCruiser() {
		return validCruiser;
	}
	
	public void setValidCruiser(boolean truth) {
		validCruiser = truth;
	}
	
	public void setSubmarine(String rc1, String rc2) {
		validSubmarine = true;
		  if (!valid(rc1,rc2)) {
			  validSubmarine = false;
			  return;
		  }
		  if (((r1-r2)!=0 && (c1-c2)!=0) || ((r1-r2)==0 && (c1-c2)==0)) {
			  System.out.println("Not Straight");
			  return;
		  }
		  if ((r1-r2)==0) {
			  if ((c1-c2)==2 || (c2-c1)==2) {
				  if (c1>c2) {
					  for (int i = c2-1 ; i<c1 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validSubmarine = false; 
								return;
							}
						}
				    for (int i = c2-1 ; i <c1 ; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
				  else {
					  for (int i = c1-1 ; i<c2 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validSubmarine = false; 
								return;
							}
						}
				    for (int i = c1-1 ; i <c2; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
			  }
		  }
		  else if ((c1-c2)==0) {
			  if ((r1-r2)==2 || (r2-r1)==2) {
				  if (r1>r2) {
					  for (int i = r2-1 ; i<r1 ; i++) {
							if (board[i][c1-1]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validSubmarine = false; 
								return;
							}
						}
					    for (int i = r2-1 ; i <r1 ; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
					  else {
						  for (int i = r1-1 ; i<r2 ; i++) {
								if (board[i][c1-1]==3) {
									System.out.println("Overlap with another ship. Re-Enter.");
									validSubmarine = false; 
									return;
								}
							}
					    for (int i = r1-1 ; i <r2; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
			  }
		  }
		  System.out.println("Length is not 3");
		  validSubmarine = false;
		}
	
	public boolean getValidSubmarine() {
		return validSubmarine;
	}
	
	public void setValidSubmarine (boolean truth) {
		validSubmarine = truth;
	}
	
	public void setDestroyer(String rc1, String rc2) {
		validDestroyer = true;
		  if (!valid(rc1,rc2)) {
			  validDestroyer = false;
			  return;
		  }
		  if (((r1-r2)!=0 && (c1-c2)!=0) || ((r1-r2)==0 && (c1-c2)==0)) {
			  System.out.println("Not Straight");
			  return;
		  }
		  if ((r1-r2)==0) {
			  if ((c1-c2)==1 || (c2-c1)==1) {
				  if (c1>c2) {
					  for (int i = c2-1 ; i<c1 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validDestroyer = false; 
								return;
							}
						}
				    for (int i = c2-1 ; i <c1 ; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
				  else {
					  for (int i = c1-1 ; i<c2 ; i++) {
							if (board[r1-1][i]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validDestroyer = false; 
								return;
							}
						}
				    for (int i = c1-1 ; i <c2; i++) {
				    	board[r1-1][i]=3;
				    }
				    return;
				  }
			  }
		  }
		  else if ((c1-c2)==0) {
			  if ((r1-r2)==1 || (r2-r1)==1) {
				  if (r1>r2) {
					  for (int i = r2-1 ; i<r1 ; i++) {
							if (board[i][c1-1]==3) {
								System.out.println("Overlap with another ship. Re-Enter.");
								validDestroyer = false; 
								return;
							}
						}
					    for (int i = r2-1 ; i <r1 ; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
					  else {
						  for (int i = r1-1 ; i<r2 ; i++) {
								if (board[i][c1-1]==3) {
									System.out.println("Overlap with another ship. Re-Enter.");
									validDestroyer = false; 
									return;
								}
							}
					    for (int i = r1-1; i <r2; i++) {
					    	board[i][c1-1]=3;
					    }
					    return;
					  }
			  }
		  }
		  System.out.println("Length is not 2");
		  validDestroyer = false;
		}
	
	public boolean getValidDestroyer() {
		return validDestroyer;
	}
	
	public void setValidDestroyer(boolean truth) {
		validDestroyer = truth;
	}
	*/
	public boolean valid(String rc1, String rc2) {
	if (rc1.length()>3 || rc2.length()>3 || rc1.length()<2 || rc2.length()<2) {
			System.out.println("Invalid input");
		return false;
		}
	
	String R1 = new String(Character.toString(rc1.charAt(0)).toUpperCase());
	String C1 = new String(Character.toString(rc1.charAt(1)));
	String R2 = new String(Character.toString(rc2.charAt(0)).toUpperCase());
	String C2 = new String(Character.toString(rc2.charAt(1)));
		if (rc1.length()==3 || rc2.length()==3) {
		  if (!rc1.substring(1).equals("10") && !rc2.substring(1).equals("10")) {
			System.out.println("Invalid column Value");
			return false;
		  }
		  if (rc1.substring(1).equals("10")) {
		    C1 = "10";
		  }
		  if (rc2.substring(1).equals("10")) {
		    C2 = "10";
		  }
	    }
		else if (((int)(C1.charAt(0)))<49 || ((int)(C1.charAt(0)))>57 || ((int)(C2.charAt(0)))<49 || ((int)(C2.charAt(0)))>57) {
			System.out.println("Invlaid Column Value");
			return false;
		}

		if ((int)(R1.charAt(0))<65 || ((int)(R1.charAt(0))>74)) {
			System.out.println("Invalid Row Value");
			return false;
		}
		if ((int)(R2.charAt(0))<65 || ((int)(R2.charAt(0))>74)) {
			System.out.println("Invalid Row Value");
			return false;
		}
		r1 = (int)(R1.charAt(0))-64;
		c1 = Integer.parseInt(C1);
		r2 = (int)(R2.charAt(0))-64;
		c2 = Integer.parseInt(C2);
		return true;
	}
	
	public void attack(String coord) {
		Attack = false;
		
		if (coord.length()>3 || coord.length()<2) {
			System.out.println("Invalid input");
			return;
		}
		String row = new String(Character.toString(coord.charAt(0)).toUpperCase());
		String column = new String(Character.toString(coord.charAt(1)));
	    if (coord.length()==3) {
	    	if(!coord.substring(1).equals("10") ) {
	    		System.out.println("Invalid column Value");
	    		return;
	    	}
	    	if (coord.substring(1).equals("10")) {
	    		column = "10";
	    	}
	    	
	    }
	    else if (((int)column.charAt(0))<49 || (((int)column.charAt(0)))>57) {
	    	System.out.println("Invalid Column Value");
	    	return;
	    }
	    
	    if((int)(row.charAt(0))<65 || ((int)row.charAt(0))>74) {
	    	System.out.println("Invalid Row Value");
	    	return;
	    }
	    int r = ((int)row.charAt(0))-64;
	    int c = Integer.parseInt(column);  				
	    if (board[r-1][c-1]==0) {						
	    	board[r-1][c-1]=1;
	    	Attack = true;
	    	System.out.println("You Missed!");
	    	return;
	    }
	    else if (board[r-1][c-1]==3) {
	        board[r-1][c-1]=2;
	        Attack = true;
	        System.out.println("It's a hit!");
	        return;
	    }
	    else {
	    	System.out.println("Already shot here. Choose another coordinate");
	    	return;
	    }
	    
	    
	}
	public boolean isAttack() {
		return Attack;
	}
	public void setAttack(boolean truth) {
		Attack = truth;
	}
	public boolean isGameOver() {
		for (int i = 0; i <10; i++) {
			for (int j = 0; j<10; j++) {
					if (board[i][j]==3) {
						return false;
					}
			}
		}
		return true;
	}
	
	//public boolean isOver() {
	//}
}

		
