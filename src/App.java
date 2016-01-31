import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class App extends JFrame {

	public App(){
		initUI();
		
		//Exit Listener
  		addWindowListener(new WindowAdapter() {
  			public void windowClosed(WindowEvent e) {
  				System.exit(0);
  			}
  		});
	}
	
	public void initUI(){
		View board = new View();
		ModelPlayer player = new ModelPlayer();
		ModelViewDialog dialog = new ModelViewDialog();
		Controller controller = new Controller(board, player, dialog);
		
		setSize(905, 720);
		setResizable(false);
		setTitle("Foffonxius Game @StudioGodi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout(1,1));
        add(board, BorderLayout.CENTER);
        add(dialog, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {		 
            public void run() {
                App ex = new App();
                ex.setVisible(true);
            }
        });

	}

}
