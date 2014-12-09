import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.security.SecureRandom;


public class rsaUser {
	private static ParameterTriple t;
	private static keyPair p;
	
	public rsaUser(ParameterTriple t, keyPair p){
		this.t = t;
		this.p = p;
	}

	public ParameterTriple getTriple() {
		return t;
	}

	public void setTriple(ParameterTriple t) {
		this.t = t;
	}

	public keyPair getPair() {
		return p;
	}

	public void setPair(keyPair p) {
		this.p = p;
	}
	
	public static BigInteger[] sign(String d){
		
		int bitLength = 160;
		SecureRandom rnd = new SecureRandom();
		int certainty = 90;
		BigInteger k = new BigInteger(bitLength, certainty, rnd);
	    
		System.out.println("This is perhaps a lousy k " + k);
		
		
		//In case k is not smaller than Q we need to generate a new one
		while(k.compareTo(t.getQ()) == 1){
			k = new BigInteger(bitLength, certainty, rnd);
		}
		
		System.out.println("New k " + k);
		
		//K inverse right here
		BigInteger kInv = k.modInverse(t.getQ());
		System.out.println("k inverse "+ kInv);
		
		//Getting z in decimal
		
		BigInteger z = new BigInteger(d, 16);
		System.out.println("This is our z "+z);
		
		//Getting r in decimal
		BigInteger r = t.getG().modPow(k, t.getP()).mod(t.getQ());
		System.out.println("r= "+r);
		
		BigInteger xr = p.getX().multiply(r);
		xr = xr.add(z);
		xr = xr.multiply(kInv);
		//Getting s
		BigInteger s = xr.mod(t.getQ());
		System.out.println("This is s " + s);
		
		BigInteger rs[] = new BigInteger[2];
		rs[0] = r;
		rs[1] = s;
		for(int i = 0; i<=1; i++){
			System.out.println("r,s:"+ rs[i]);
		}
		
		return rs;
		
	}
	
	public static boolean verify(BigInteger pubKey, String d, BigInteger[] rs){
		
		BigInteger rPrime = rs[0];
		BigInteger sPrime = rs[1];
		
		if(rPrime.compareTo(t.getQ()) == -1 && rPrime.compareTo(BigInteger.ZERO) == 1
				&& sPrime.compareTo(t.getQ()) == -1 && sPrime.compareTo(BigInteger.ZERO) == 1){
			
			BigInteger w = (sPrime.modInverse(t.getQ()));
			BigInteger z = new BigInteger(d, 16);
			
			BigInteger u1 = (z.multiply(w)).mod(t.getQ());
			BigInteger u2 = (rPrime.multiply(w)).mod(t.getQ());
			
			BigInteger gp = t.getG().modPow(u1, t.getP());
			gp = (gp.multiply(pubKey.modPow(u2, t.getP()))).mod(t.getP());
			
			BigInteger v = gp.mod(t.getQ());
			
			System.out.println("v is " + v);
			System.out.println("r is " + rPrime);
			
			if(v.equals(rPrime)){
				System.out.println("Signature valid");
				return true;
			}else{
				System.out.println("Signature invalid");
				return false;
			}
			
		}else{
			System.out.println("Signature invalid");
			return false;
	}
}
	
}