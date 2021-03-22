package three.table;

import three.ComboBoxPanel;
import three.table.dao.ShowDao;
import three.table.dao.connection.ConnectionPool;
import three.table.entity.Show;
import three.table.gui.ShowPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class TableExecutor {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(TableExecutor::createGUI);
    }

    static void createGUI(){
        try {
            System.out.println(Thread.currentThread().getName());
            JFrame frame = new JFrame("Table overview");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);
            ShowPanel showPanel = new ShowPanel(showDao);
            frame.setContentPane(showPanel);
            frame.pack();
            //frame.setSize(400, 400);
            frame.setVisible(true);
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}
