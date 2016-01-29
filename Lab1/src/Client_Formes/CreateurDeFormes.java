package Client_Formes;

public class CreateurDeFormes {
	
	public static Forme obtenirForme(String[] laForme){
		Forme forme = null;
		String nomDeForme = laForme[1];
		
		int numeroIDLogger	= Integer.parseInt(laForme[0]);
		int coord1 	= Integer.parseInt(laForme[2]);	//x1 ou centreX
		int coord2 	= Integer.parseInt(laForme[3]);	//y1 ou centreY
		int coord3 	= Integer.parseInt(laForme[4]);	//x2 ou rayonH ou rayon
		int coord4 	= 0;
		
		if (!nomDeForme.equals("CERCLE"))
			coord4 = Integer.parseInt(laForme[5]);	//y2 ou rayonV
				
		switch(nomDeForme){
		case "CARRE"		: forme = new Carré(numeroIDLogger,coord1,coord2,coord3,coord4)		; break;
		case "RECTANGLE"	: forme = new Rectangle(numeroIDLogger,coord1,coord2,coord3,coord4)	; break;
		case "LIGNE"		: forme = new Ligne(numeroIDLogger,coord1,coord2,coord3,coord4)		; break;
		case "OVALE"		: forme = new Ovale(numeroIDLogger,coord1,coord2,coord3,coord4)		; break;
		case "CERCLE"		: forme = new Cercle(numeroIDLogger,coord1,coord2,coord3)			; break;
		}
		
		return forme;
	}
}
