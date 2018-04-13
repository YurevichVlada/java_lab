
/**
 * this program translate a complex number 
 * from an algebraic form to exponential form
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Work1 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("калькулятор");
		frame.setSize(500, 250);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		JButton button = new JButton("Посчитать");

		JTextField TextFieldReal = new JTextField(10);
		JTextField TextFieldMnim = new JTextField(10);
		JLabel TextFieldArg = new JLabel();
		JLabel TextFieldPhaza = new JLabel();

		JLabel LabelReal = new JLabel("Действительная часть");
		JLabel LabelMnim = new JLabel("Мнимая часть");
		JLabel LabelArg = new JLabel("Модуль: ");
		JLabel LabelPhaza = new JLabel("Аргумент: ");
		// JLabel LabelBSUIR = new JLabel("БГУИР- знания и стиль жизни");

		/**
		 * class that handles a button click
		 */

		class buttonActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String SReal, SMnim; // строки, в которые считываюется введенные значения
				boolean BReal, BMnim;
				double DbReal = 0, DbMnim = 0, DbArg, DbPhaza;
				SReal = TextFieldReal.getText();
				SMnim = TextFieldMnim.getText();
				BReal = test(SReal);
				BMnim = test(SMnim);
				if (BReal && BMnim) {
					DbReal = Double.parseDouble(SReal);
					DbMnim = Double.parseDouble(SMnim);
					DbArg = Math.sqrt(Math.pow(DbReal, 2) + Math.pow(DbMnim, 2));
					DbArg = (double) Math.round(DbArg * 1000d) / 1000d;
					DbPhaza = (Math.atan(DbMnim / DbReal) * 180) / 3.14;
					TextFieldArg.setText(String.valueOf(DbArg));
					DbPhaza = (double) Math.round(DbPhaza * 1000d) / 1000d;
					TextFieldPhaza.setText(String.valueOf(DbPhaza));
				} else {
					TextFieldArg.setText("error");
					TextFieldPhaza.setText("error");
				}
			}
		}

		button.addActionListener(new buttonActionListener());

		frame.add(LabelReal, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение надписи
																					// "действительная
																								// часть"
				GridBagConstraints.HORIZONTAL, new Insets(20, 10, 0, 1), 0, 0));

		frame.add(TextFieldReal, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение поля
																									// ввода
																									// действительной
																									// части
				GridBagConstraints.HORIZONTAL, new Insets(20, 1, 0, 10), 0, 0));

		frame.add(LabelArg, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение надписи
																								// "аргумент"
				GridBagConstraints.HORIZONTAL, new Insets(20, 1, 0, 10), 0, 0));

		frame.add(TextFieldArg, new GridBagConstraints(3, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение поле
																									// выводы
																									// действительной
																									// части
				GridBagConstraints.HORIZONTAL, new Insets(20, 1, 0, 10), 0, 0));

		frame.add(LabelMnim, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение надписи
																								// "мнимая часть"
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 1), 0, 0));

		frame.add(TextFieldMnim, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение поля
																									// ввода мнимой
																									// части
				GridBagConstraints.HORIZONTAL, new Insets(10, 1, 10, 10), 0, 0));

		frame.add(LabelPhaza, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение надписи
																									// "фаза"
				GridBagConstraints.HORIZONTAL, new Insets(10, 1, 10, 10), 0, 0));

		frame.add(TextFieldPhaza, new GridBagConstraints(3, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение
																										// поля вывода
																										// модуля
				GridBagConstraints.HORIZONTAL, new Insets(10, 1, 10, 10), 0, 0));

		frame.add(button, new GridBagConstraints(3, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, // расположение поля вывода
																								// фазы
				GridBagConstraints.HORIZONTAL, new Insets(10, 1, 10, 10), 0, 0));

		// frame.add(LabelBSUIR, new GridBagConstraints(0,3,1,1,1,1,
		// GridBagConstraints.NORTH, //расположение поля вывода фазы
		// GridBagConstraints.HORIZONTAL, new Insets(10,1,10,10),0,0));

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Function check a string for the content of a number
	 * 
	 * @param testString
	 *            string for checking
	 * @return true if the string is a real or an integer number, else false
	 */
	public static boolean test(String testString) {
		Pattern p = Pattern.compile("^(\\d+(.)\\d+)|(\\d+)");
		Matcher m = p.matcher(testString);
		return m.matches();
	}
}
