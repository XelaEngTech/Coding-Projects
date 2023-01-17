import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Lab5P1 {
    public static void main(String[] args) {
        CobaltConverter cc = new CobaltConverter();
    }
}
class CobaltConverter extends JFrame {
    CobaltConverter() {
        super("Cobalt Converter");
        buildGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void buildGUI() {
		JLabel aoc = new JLabel("Amount of Cobalt");
        JTextField cobalt = new JTextField(7);
		JLabel noy = new JLabel("Number of Years");
		JTextField years = new JTextField(5);
        JButton compute = new JButton("Compute");
		JButton quit = new JButton("Quit");
        JLabel amount = new JLabel("Amount remaining: ");

        Container ct = getContentPane();
        ct.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(7, 7, 7, 7);

        c.gridx = 0; c.gridy = 0; c.gridwidth = 1; c.gridheight = 1;
        ct.add(aoc, c);
		
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1; c.gridheight = 1;
        ct.add(cobalt, c);
		
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1; c.gridheight = 1;
        ct.add(noy, c);
		
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1; c.gridheight = 1;
        ct.add(years, c);

        c.gridx = 0; c.gridy = 2; c.gridwidth = 1; c.gridheight = 1;
        ct.add(compute, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1; c.gridheight = 1;
        ct.add(quit, c);
		
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; c.gridheight = 1;
        ct.add(amount, c);

        QuitListener quitl = new QuitListener();
        quit.addActionListener(quitl);

        AddListener addl = new AddListener(cobalt, years, amount);
        compute.addActionListener(addl);
        cobalt.addActionListener(addl);
		years.addActionListener(addl);
    }

    class AddListener implements ActionListener {
        private JTextField in;
		private JTextField in2;
        private JLabel out;

        AddListener(JTextField in, JTextField in2, JLabel out) {
            this.in = in;
			this.in2 = in2;
            this.out = out;
        }

        public void actionPerformed(ActionEvent e) {
            double cobalt = (double) Double.parseDouble(in.getText());
			double years = (double) Double.parseDouble(in2.getText());
			
			for(int i = 1; i <= years; i++) {
				cobalt = cobalt - (0.12*cobalt);
			}
            DecimalFormat df = new DecimalFormat("#0.00");
            out.setText("Amount remaining: " + df.format(cobalt));
        }
    }

    class QuitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
