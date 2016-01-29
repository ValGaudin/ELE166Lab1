package Client_Formes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class AffichageIF extends JFrame{
	/*
	 * Il vaut mieux déclarer les variables constantes (static final) pour les
	 * chaînes de caractère ou les valeurs importantes. Le code est plus lisible
	 * puisqu'on comprend le sens de l'information. Le code est plus facile à 
	 * maintenir : pour effectuer un changement, l'information est centralisée.
	 * 
	 * Voir les fichiers prefs.properties et app_xx.properties (où xx définit les
	 * chaînes pour chaque langue)
	 */
	private static final JPanel STATUS_AREA = new JPanel();
	private static final JLabel STATUS = new JLabel();

	private static final String TITRE_CLIENT = "Client de Formes";

	private static final int DELAI_MS = 1000;
	private static final int NOMBRE_FORMES = 30;
	private static final int LARGEUR_CANEVAS = 500;
	private static final int HAUTEUR_CANEVAS = 500;
	private static final int MARGE_H = 50;
	private static final int MARGE_V = 60;
	private static final int FORME_MAX_LARGEUR = 200;
	private static final int FORME_MAX_HAUTEUR = 200;
	/*
	 * Attribut qui représente une seule forme
	 */
	static Queue<Shape> dessin  = new LinkedList<Shape>();
	static Queue<Color> couleur = new LinkedList<Color>();


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
			CustomCanvas.this.setBackground(Color.white);
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
			if (dessin != null)
			{
				// faire un cast (transtypage) en Graphics2D depour avoir plus de fonctionnalité
				Graphics2D g2d = (Graphics2D) g;

				g2d.setRenderingHint(
						RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				// theColor = une variable de la classe principale

				Iterator<Color> it1 = couleur.iterator();
				Iterator<Shape> it2 = dessin.iterator();
				Shape dessin = null;
				Color couleur = null;

				while (it1.hasNext() && it2.hasNext()) {
					couleur = it1.next();
					dessin = it2.next();

					g2d.setPaint(couleur);
					g2d.fill(dessin);
					g2d.setPaint(Color.black);
					g2d.draw(dessin);
				}

				//				for (Iterator iterator; iterator.hasNext()) {
				//					couleur.iterator();
				//					
				//					g2d.setPaint(couleur.);
				//					g2d.fill(dessin.get(i));
				//					g2d.setPaint(Color.black);
				//					g2d.draw(dessin.get(i));
				//				}

			}
		}
	}

	/**
	 * Constructeur de la classe <code>SqueletteSwingApplication</code>.
	 * Cette methode cree une nouvelle instance (nouvel objet) de la
	 * classe.
	 */
	public AffichageIF()
	{
		/*
		 * Creer un objet CustomCanvas (JPanel) et mettre un scrollpane autour,
		 * puis placer le tout dans le contenu du JFrame (SqueletteSwingApplication)
		 */
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}

	public void launch(final JFrame jFrame, String title, final int xBounds, final int yBounds,
			final int width, final int height) {
		jFrame.setTitle(title);
		jFrame.setBounds(xBounds,yBounds,width,height);
		jFrame.setVisible(true);
		jFrame.setResizable(true);

		STATUS.setHorizontalAlignment(JLabel.LEFT);

		STATUS_AREA.setBorder(BorderFactory.createEtchedBorder());
		STATUS_AREA.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		STATUS_AREA.add(STATUS);

		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {
				System.exit(0);
			}
		});
	}

	/**
	 * Describe <code>main</code> method here.
	 *
	 * @param args a <code>String[]</code> value
	 */
	@SuppressWarnings("null")
	public static void main(String[] args)
	{
		Forme forme = null;
		AffichageIF frame = new AffichageIF();
		Client client = new Client();

		frame.launch(frame, TITRE_CLIENT, 0, 0, LARGEUR_CANEVAS + MARGE_H, HAUTEUR_CANEVAS + MARGE_V);

		// pour centrer la fenêtre ?
		frame.setLocationRelativeTo(null);

		for(int i=0;i<NOMBRE_FORMES;i++){
			client.ecritureServeur("GET");
			forme = CreateurDeFormes.obtenirForme(client.decoupageInstructionForme(client.lectureServeur()));

			if(i<10){
				dessin.add(forme.dessinerForme());
				couleur.add(forme.obtenirCouleur());
			}else
			{	
				dessin.remove();
				dessin.add(forme.dessinerForme());
				couleur.remove();
				couleur.add(forme.obtenirCouleur());
			}

				frame.repaint();
			try
			{
				// pause de N millisecondes
				Thread.sleep(DELAI_MS);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		client.fermerConnection();
	}
}