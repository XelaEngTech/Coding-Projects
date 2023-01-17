import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab5P2 {
    public static void main(String[] args) {
        Javapad j = new Javapad();
    }
}
class Javapad extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem n;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem exit;

    public Javapad() {
        super("Javapad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 480));
        buildGUI();
        pack();
        setVisible(true);
    }

    class MenuListener implements ActionListener {
        private JFileChooser fc;
        private JTextArea area;

        public MenuListener(JTextArea area) {
            fc = new JFileChooser();
            this.area = area;
			String path = System.getProperty("user.home");
			File f = new File(path);
			fc.setCurrentDirectory(f);	
       }
       public void actionPerformed(ActionEvent e) {
		   String intake = "";
            if(e.getSource() == n) {
				area.setText("");
                
            } 
			else if(e.getSource() == open) {
				int result = fc.showOpenDialog(null);
			
				if(result == JFileChooser.APPROVE_OPTION) {
					String filename = fc.getSelectedFile().getPath();
					JOptionPane.showMessageDialog(null, "You selected " + filename);
					File f = new File(fc.getSelectedFile().getAbsolutePath());
					try {
						FileReader read = new FileReader(f);
						Scanner scan = new Scanner(read);
						while(scan.hasNextLine()) {
							String line = scan.nextLine() + "\n";
							intake = intake + line;
						}
						area.setText(intake);
						}
						catch ( FileNotFoundException ex) {
							ex.printStackTrace();
						}
				}
				else if(result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "You selected nothing.");
				}
				else if(result == JFileChooser.ERROR_OPTION) {
					JOptionPane.showMessageDialog(null, "An error occured.");
				}
            } 
			else if(e.getSource() == save) {
          	   	int result = fc.showSaveDialog(null);
                try {
                	File fi = new File(fc.getSelectedFile().getAbsolutePath());
           		 	FileWriter out = new FileWriter(fi);
					out.write(area.getText());
					out.close();
				}
				catch(FileNotFoundException ex) {
					Component f = null;
					JOptionPane.showMessageDialog(f, "File not found. ");
				}
				catch(IOException ex) {
					Component f = null;
					JOptionPane.showMessageDialog(f, "Error");
				}
			
     	   } 
  	  }
}
    private void buildGUI() {
        Container container = this.getContentPane();

        menuBar = new JMenuBar();
        container.add(menuBar, BorderLayout.NORTH);   

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        n = new JMenuItem("New");
        fileMenu.add(n);
        fileMenu.addSeparator();

        open = new JMenuItem("Open");
        fileMenu.add(open);
        fileMenu.addSeparator();

        save = new JMenuItem("Save");
        fileMenu.add(save);
        fileMenu.addSeparator();

        exit = new JMenuItem("Exit");
        fileMenu.add(exit);

        JTextArea edit = new JTextArea(30,20);
        edit.setFont(new Font("Menlo", Font.PLAIN, 14));

        JScrollPane sp = new JScrollPane(edit);
        sp.setPreferredSize(new Dimension(450, 100));
        container.add(sp, BorderLayout.CENTER);
		
        QuitListener exitJP = new QuitListener();
        exit.addActionListener(exitJP);

        MenuListener ml = new MenuListener(edit);
        n.addActionListener(ml);
        open.addActionListener(ml);
        save.addActionListener(ml);
        exit.addActionListener(ml);
    }
    class QuitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
