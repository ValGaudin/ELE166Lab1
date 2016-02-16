package Client_Formes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Classe <b><i>Affichage</i></b> <br><br>
 * 
 * Affichage est une classe qui permet de dessiner
 * des objets dans une fenêtre. 
 */
@SuppressWarnings("serial")
public class Affichage extends JFrame{

	private static final JPanel STATUS_AREA = new JPanel();
	private static final JLabel STATUS = new JLabel();

	private static final String TITRE_CLIENT = "Client de Formes";

	private static final int DELAI_MS = 25;
	private static final int NOMBRE_FORME_AFFICHE = 10;
	private static final int LARGEUR_CANEVAS = 500;
	private static final int HAUTEUR_CANEVAS = 500;
	private static final int MARGE_H = 50;
	private static final int MARGE_V = 60;
	private static final int FORME_MAX_LARGEUR = 200;
	private static final int FORME_MAX_HAUTEUR = 200;

	/*
	 * Attribut qui représente la queue de formes
	 */
	QueueForme queueForme = new QueueForme(NOMBRE_FORME_AFFICHE);
	Iterator<Forme> iterator;
	
	/**
	 * Classe <b><i>CustomCanvas</i></b> <br><br>
	 * 
	 * CustomCanvas est une "inner" classe qui permet de dessiner
	 * des objets dans l'interface Swing. 
	 */
	class CustomCanvas extends JPanel
	{
		/**
		 * Constructeur de la classe <b><i>CustomCanvas</i></b> <br>
		 * &nbsp; public CustomCanvas() <br><br>
		 * 
		 * Cette methode cree une nouvelle instance de la
		 * classe.
		 */
		public CustomCanvas()
		{
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.setBackground(Color.BLACK);
		}

		/**
		 * <b><i>getPreferredSize</i></b> 
		 * permet de retourner les dimensions désirées
		 *
		 * @return les Dimension définies comme constantes 
		 */
		public Dimension getPreferredSize()
		{
			return new Dimension(LARGEUR_CANEVAS, HAUTEUR_CANEVAS);
		}

		/**
		 * <b><i>paintComponent</i></b> 
		 * permet de peindre les composants désirés sur le graphique reçu 
		 * (ici, des formes contenues dans la queue de formes)
		 *  
		 * @param g Graphics dans lequel on va peindre des composants
		 */
		public void paintComponent(Graphics g)
		{
			/* dessiner le fonds (background) -- obligatoire */
			super.paintComponent(g);


			/*
			 * Si la queue de formes n'est pas nulle, on la dessine.
			 */
			if (queueForme != null)
			{
				// faire un cast (transtypage) en Graphics2D depour avoir plus de fonctionnalité
				Graphics2D g2d = (Graphics2D) g;

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				Forme forme = null;
				Shape dessin = null;
				iterator = queueForme.obtenirListe().iterator();

				while (iterator.hasNext()) {
					forme = iterator.next();
					dessin = forme.dessinerForme();

					g2d.setPaint(forme.obtenirCouleur());
					g2d.fill(dessin);
					g2d.setPaint(Color.WHITE);
					g2d.draw(dessin);
				}
			}
		}
	}

	/**
	 * <b><i>attendre</i></b> 
	 * permet de mettre un délai dans l'execution du code
	 * (ici, elle permet de temporiser l'affichage des figures).
	 */
	public void attendre(){
		try
		{
			// pause de N millisecondes
			Thread.sleep(DELAI_MS);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Constructeur de la classe <b><i>Affichage</i></b> <br>
	 * 
	 * Cette methode crée une nouvelle instance de la classe.
	 */
	public Affichage()
	{
		/*
		 * Creer un objet CustomCanvas (JPanel) puis placer le contenu du JFrame
		 */
		getContentPane().add(new CustomCanvas());
	}

	/**
	 * <b><i>launch</i></b>  
	 * permet d'initialiser et lancer le frame à l'aide des 
	 * variables constantes de cette classe.
	 * 
	 * @param jFrame le jFrame à initialiser et à +lancer
	 */
	public void launch(final JFrame jFrame) {
		jFrame.setTitle(TITRE_CLIENT);
		jFrame.setBounds(0, 0, LARGEUR_CANEVAS + MARGE_H, HAUTEUR_CANEVAS + MARGE_V);
		jFrame.setVisible(true);
		jFrame.setResizable(true);

		STATUS.setHorizontalAlignment(JLabel.LEFT);

		STATUS_AREA.setBorder(BorderFactory.createEtchedBorder());
		STATUS_AREA.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		STATUS_AREA.add(STATUS);

		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {

				/*
				 * Permet de fermer la connection dans le cas où on fermerait la fenêtre 
				 * sans avoir fini de récupérer toutes les formes voulues.
				 */
				try {
					Connexion.obtenirPrinterWriter().println("END");
					Connexion.obtenirSocket().close();
					System.out.println("Connection fermée.");

				} catch (Exception e) {
					e.printStackTrace();
				}

				System.exit(0);
			}
		});
	}
}