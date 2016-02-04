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
import java.io.IOException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class Affichage extends JFrame{
	/*
	 * Il vaut mieux d�clarer les variables constantes (static final) pour les
	 * cha�nes de caract�re ou les valeurs importantes. Le code est plus lisible
	 * puisqu'on comprend le sens de l'information. Le code est plus facile � 
	 * maintenir : pour effectuer un changement, l'information est centralis�e.
	 * 
	 * Voir les fichiers prefs.properties et app_xx.properties (o� xx d�finit les
	 * cha�nes pour chaque langue)
	 */
	private static final JPanel STATUS_AREA = new JPanel();
	private static final JLabel STATUS = new JLabel();

	private static final String TITRE_CLIENT = "Client de Formes";

	private static final int DELAI_MS = 10;
	private static final int NOMBRE_FORME_AFFICHE = 100;
	private static final int LARGEUR_CANEVAS = 500;
	private static final int HAUTEUR_CANEVAS = 500;
	private static final int MARGE_H = 50;
	private static final int MARGE_V = 60;
	private static final int FORME_MAX_LARGEUR = 200;
	private static final int FORME_MAX_HAUTEUR = 200;
	/*
	 * Attribut qui repr�sente la queue de formes
	 */
	QueueForme queueForme = new QueueForme(NOMBRE_FORME_AFFICHE);
	Iterator<Forme> iterator;

	/**
	 * <code>CustomCanvas</code> est une "inner" classe qui permet de dessiner
	 * des objets dans l'interface Swing. 
	 *
	 * On utilise une inner classe pour faciliter la visibilites des
	 * variables dans la classe exterieure.
	 *
	 * Voir 
	 * <a href="http://java.sun.com/docs/books/tutorial/uiswing/painting/overview.html">Overview of Custom Painting</a>, 
	 * une partie du tutoriel Java de Sun.
	 *
	 */
	class CustomCanvas extends JPanel
	{

		public CustomCanvas()
		{
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.setBackground(Color.BLACK);
		}

		/**
		 * <code>getPreferredSize</code> retourne la dimension du JPanel
		 *
		 * @return a <code>Dimension</code> value
		 */
		public Dimension getPreferredSize()
		{
			return new Dimension(LARGEUR_CANEVAS, HAUTEUR_CANEVAS);
		}

		/**
		 * <code>paintComponent</code> contient le code pour le dessin
		 * "fait sur commande"
		 *
		 * @param g a <code>Graphics</code> value
		 */
		public void paint(Graphics g)
		{
			/* dessiner le fonds (background) -- obligatoire */
			super.paintComponent(g);


			/*
			 * Si la forme (attribut de la classe principale ici) n'est pas 
			 * nulle, on la dessine
			 */
			if (queueForme != null)
			{
				// faire un cast (transtypage) en Graphics2D depour avoir plus de fonctionnalit�
				Graphics2D g2d = (Graphics2D) g;

				g2d.setRenderingHint(
						RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);

				Forme forme = null;
				Shape dessin = null;
				iterator = queueForme.obtenirListe().iterator();

				while (iterator.hasNext()) {
					forme = iterator.next();
					dessin = forme.obtenirDessin();

					g2d.setPaint(forme.obtenirCouleur());
					g2d.fill(dessin);
					g2d.setPaint(Color.GREEN);
					g2d.draw(dessin);
				}
			}
		}
	}

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
	 * Constructeur de la classe <code>SqueletteSwingApplication</code>.
	 * Cette methode cree une nouvelle instance (nouvel objet) de la
	 * classe.
	 */
	public Affichage()
	{
		/*
		 * Creer un objet CustomCanvas (JPanel) et mettre un scrollpane autour,
		 * puis placer le tout dans le contenu du JFrame (SqueletteSwingApplication)
		 */
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}

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

				try {
					if (Connexion.obtenirSocket() != null){
						Connexion.obtenirPrinterWriter().println("END");
						Connexion.obtenirSocket().close();
						System.out.println("Connection ferm�e.");
					}else
						throw new Exception("D�j� ferm� !");

				} catch (Exception e) {
					e.printStackTrace();
				}

				System.exit(0);
			}
		});
	}
}