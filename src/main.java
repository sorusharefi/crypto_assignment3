import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class main {

	

	private static Scanner scan;

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		getCommand();
//		
		//Public key of someone else
		
		
		
		
		//There is no p,q,g defined at the moment. If you want to experiḿent. You need to assign them.
//		p = new BigInteger("102865584259843077175583195011997798900482038016705824136288380475734860009055428071534495956844807748416572686838253895244634687898659646424515259679129905513743899853971066468883670407530107234961085482225328667572772611162756643027105617873895021996158552984843708233824989792811721408577351617080369547993");
//		q = new BigInteger("734415599462729831694143846331445277609193755927");
//		g = new BigInteger("63615006880335642768473038477258757436464860136916565207798584167060621564899979263408565137993978149206751054438974059615983337126379668370747907507911540381031959187353048278562320341063050939775344313271013777131358834376209974551749493023310606751625276738876397935042130121966817767949476523717161640453");
		


//		keyPair kp = new keyPair(pt);
		
		
//		BigInteger rs[] = new BigInteger[2];
//		rs[0] = new BigInteger("497727687827108870230917469165124644171957997527");
//		rs[1] = new BigInteger("69924200561536940344114164706214298822631922629");
		
//		String D = "10B4D55F2376DBA00CE4A6AE2B122E9554035EF2";
		
		
//		rsaUser a = new rsaUser(pt, kp);
		
		//Hexadecimal digest for testing purposes
		
        
//		a.verify(pb, D, rs);
        
        
//		a.sign(D);
		

	}
	
	public static void getCommand(){
		BigInteger p = null;
		BigInteger q = null;
		BigInteger g = null;
		
		ParameterTriple pt = new ParameterTriple(p,q,g);
		
		scan = new Scanner(System.in);
		System.out.print("Please enter p: ");
		pt.setP(scan.nextBigInteger());
		
		System.out.print("Please enter q: ");
		pt.setQ(scan.nextBigInteger());
		
		System.out.print("Please enter g: ");
		pt.setG(scan.nextBigInteger());
		keyPair kp = new keyPair(pt);
		rsaUser rUser = new rsaUser(pt, kp);

		
		System.out.print("What do you want to do (Verify, Sign, GenKey)? ");
		String command = scan.next();
		
		if(command.equalsIgnoreCase("VERIFY")) {
			BigInteger rs[] = new BigInteger[2];
			System.out.print("Please enter y:");
			kp.setY(scan.nextBigInteger());
			
			System.out.print("Please enter d:");
			String D = scan.next();
			
			System.out.print("Please enter r:");
			rs[0] = scan.nextBigInteger();
			
			System.out.print("Please enter s:");
			rs[1] = scan.nextBigInteger();
			
			rUser.verify(kp.getY(), D, rs);
			getCommand();
			
		}
		else if(command.equalsIgnoreCase("SIGN")){
			System.out.print("Please enter x: ");
			kp.setX(scan.nextBigInteger());
			
			System.out.print("Please enter y: ");
			kp.setY(scan.nextBigInteger());
			
			System.out.print("Please enter d: ");
			String D = scan.next();

			rsaUser.sign(D);
			getCommand();
			
		}
		else if(command.equalsIgnoreCase("GENKEY")){
			System.out.println("genkey");
		}
		else{
			System.out.println("Command is an invalid command, please enter a valid command");
			getCommand();
		}
	}
}