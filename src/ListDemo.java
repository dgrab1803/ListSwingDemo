package academy.learnprogramming;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListDemo implements ListSelectionListener {
    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;

    String names[] = {"Ewa", "Dominik", "Gabi", "Tom", "Waldek", "Milosz", "Seba", "Karol", "Kamil", "Ania", "Ada"};

    ListDemo() {
        JFrame jfrm = new JFrame(" Lista JList");

        jfrm.setLayout(new FlowLayout());

        jfrm.setSize(200, 160);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlst = new JList<String>(names);


        jscrlp = new JScrollPane(jlst);

        jscrlp.setPreferredSize(new Dimension(120, 90));

        jlab = new JLabel("Wybierz imie");

        jlst.addListSelectionListener(this);

        jfrm.add(jscrlp);
        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent le) {


        int[] indices = jlst.getSelectedIndices();

        if (indices.length != 0) {
            String who ="";

            for (int i : indices)
                who += names[i] + " ";
            jlab.setText("Aktualny wybór: " + who);
        } else
            jlab.setText("Wybierz imie ");

    }
}
