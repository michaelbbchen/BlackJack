//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
        public Card(){
            
        }
        public Card(int f, String s){
            face = f;
            suit = s;
        }


	// modifiers
        public void setFace(int f){
            face = f;
        }
        public void setSuit(String s){
            suit = s;
        }
  	//accessors
        public int getFace(){
            return face;
        }
        public String getSuit(){
            return suit;
        }
        
  	public abstract int getValue();

	public boolean equals(Card obj)
	{
                if(obj.getFace() == face && obj.getSuit().equals(suit)){
                    return true;
                }
		return false;
	}

  	//toString
  	public String toString(){
            return FACES[face] + " of " + suit+ " | value = " + getValue();
        }
 }