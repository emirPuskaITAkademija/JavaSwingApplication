package three;

import three.table.dao.ShowDao;
import three.table.dao.connection.ConnectionPool;
import three.table.entity.Show;

import javax.swing.*;
import java.sql.SQLException;

public class Executor {
    public static void main(String[] args) throws SQLException {
        ConnectionPool connectionPool = new ConnectionPool();
        ShowDao showDao = new ShowDao(connectionPool);
        Show show = showDao.retrieve(2);
        System.out.println(show);
        //SwingUtilities.invokeLater(Executor::createGUI);
    }
    static void createGUI(){
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame("Combo box usage demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ComboBoxPanel comboBoxPanel = new ComboBoxPanel();
        frame.setContentPane(comboBoxPanel);
        frame.pack();
        //frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
