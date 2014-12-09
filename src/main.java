import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;


public class main {

	

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger p = null;
		BigInteger q = null;
		BigInteger g = null;
		String pValue = null;
		String qValue = null;
		String gValue = null;
		
		//There is no p,q,g defined at the moment. If you want to experiḿent. You need to assign them.
		
		ParameterTriple pt = new ParameterTriple(p,q,g);
		
		keyPair kp = new keyPair(pt);
		
		//Public key of someone else
		BigInteger pb = new BigInteger("1099906791313925528746008054081768734007884349815325963667520491768596235922636596649198172987598573083011790017146356061273962023338014420645127092468263770753970716461208880423045761205934804880887634821616587683235765408867072852094816664326084550730344050243082288308837441908172297994552279650972016922");
		
		BigInteger rs[] = new BigInteger[2];
		rs[0] = new BigInteger("497727687827108870230917469165124644171957997527");
		rs[1] = new BigInteger("69924200561536940344114164706214298822631922629");
		
		String D = "10B4D55F2376DBA00CE4A6AE2B122E9554035EF2";
		
		
		rsaUser a = new rsaUser(pt, kp);
		
		//Hexadecimal digest for testing purposes
		
        
		a.verify(pb, D, rs);
        
        
		//a.sign(D);
		

	}

}