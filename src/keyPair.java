import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;


public class keyPair {
	private BigInteger x;
	private BigInteger y;
	
	public keyPair(ParameterTriple t){
		if(t.checkValues() == false){
			System.out.println("Unaccepted values");
		}
		
		int bitLength = 160;
		SecureRandom rnd = new SecureRandom();
		int certainty = 90;
		x = new BigInteger(bitLength, certainty, rnd);
	    
//		System.out.println("This is perhaps a lousy x " + x);
		
		
		//In case x is not smaller than Q we need to generate a new one
		while(x.compareTo(t.getQ()) == 1){
			x = new BigInteger(bitLength, certainty, rnd);
		}
		
//	    System.out.println("This is our improved x " + x);
		
	    //Now we create y
	    
	    y = t.getG().modPow(x, t.getP());
	    
//	    System.out.println("This is our y " + y);
		
	}

	public BigInteger getX() {
		return x;
	}

	public void setX(BigInteger x) {
		this.x = x;
	}

	public BigInteger getY() {
		return y;
	}

	public void setY(BigInteger y) {
		this.y = y;
	}
}
