import java.math.BigInteger;




public class ParameterTriple {
		private BigInteger p;
		private BigInteger q;
		private BigInteger g;
		
		
		public ParameterTriple(){
			
		}
		
		
		public ParameterTriple(BigInteger p, BigInteger q, BigInteger g){
			this.p = p;
			this.q = q;
			this.g = g;
		}


		public BigInteger getP() {
			return p;
		}


		public void setP(BigInteger p) {
			this.p = p;
		}


		public BigInteger getQ() {
			return q;
		}


		public void setQ(BigInteger q) {
			this.q = q;
		}


		public BigInteger getG() {
			return g;
		}


		public void setG(BigInteger g) {
			this.g = g;
		}
		
		//Check if the triple has valid numbers
		public boolean checkValues(){
			if(getP().isProbablePrime(1) && getP().bitLength() == 1024){
				System.out.println("P is prime \n");
				System.out.println("P have the right size \n");
				
				if(getQ().isProbablePrime(1) && getQ().bitLength() == 160){
					System.out.println("Q is prime \n");
					BigInteger checkDiv = getP().subtract(new BigInteger("1"));
					BigInteger qs = getQ();
					
					//gq mod p = 1 and g > 1.
					
					if(checkDiv.mod(qs).equals(BigInteger.ZERO)){
						System.out.println("P-1 is divisor of g");
						if(getG().modPow(getQ(), getP()) == BigInteger.ONE
								&& getG().compareTo(BigInteger.ONE) == 1){
							
							System.out.println("g is larger than 1");
							return true;
						}else
							return false;
					}else
						return false;
				}else{
					System.out.println("Q is not prime\n");
					return false;
				}
			}else{
				System.out.println("P is not prime\n");
				return false;
			}
		}
}
