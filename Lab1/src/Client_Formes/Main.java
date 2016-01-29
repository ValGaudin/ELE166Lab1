package Client_Formes;

import ca.etsmtl.log.util.IDLogger;


public class Main {
	public static void main(String[] args) {
		IDLogger logger = IDLogger.getInstance();
		
		/*splitResult = logger.toString().split("[<&>]");
		
		for (int i = 0; i < splitResult.length; i++) {
			System.out.println(splitResult[i].toString());			
		}
		
		System.out.println(splitResult.length);	*/
		
		System.out.println(logger.toString());
		//logger.logID(0);
		
	}
}
