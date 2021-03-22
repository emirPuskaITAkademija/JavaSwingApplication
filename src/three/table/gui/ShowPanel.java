package three.table.gui;

import three.table.dao.ShowDao;
import three.table.entity.Show;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * shows -> Show  -> ShowDao
 *
 * <li> List<Show> ...ADAPTIRANJA .... JTable</Show></li>
 */
public class ShowPanel extends JPanel {

    private final ShowDao showDao;
    private JTable table;
    // List<Show>  <---- adaptirati model OurTableModel  --> JTable

    public ShowPanel(ShowDao showDao){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.showDao = showDao;
        Vector<String> columnNames = showDao.getColumnNames();
        Vector<Vector<Object>> data = getAllData();
        OurTableModel tableModel = new OurTableModel(columnNames, data);
        table = new JTable();
        table.setModel(tableModel);
        add(new JScrollPane(table));
    }

    private Vector<Vector<Object>> getAllData(){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        try{
            List<Show> showList = showDao.retrieveAll();
            for(Show show: showList){
                Vector<Object> rowData = new Vector<>();
                rowData.addElement(show.getShowId());
                rowData.addElement(show.getShowTitle());
                rowData.addElement(show.getNumberOfSeasons());
                rowData.addElement(show.getInitialYear());
                data.addElement(rowData);
            }
        }catch(SQLException exc){
            System.err.println(exc.getMessage());
        }
        return data;
    }

    private class OurTableModel extends AbstractTableModel{
        private Vector<String> columnNames;
        private Vector<Vector<Object>> data;

        public OurTableModel(Vector<String> columnNames, Vector<Vector<Object>> data){
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            Object object = rowVector.get(columnIndex);
            System.out.print(object);
            return object;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex==1;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);//red
            int showId =(int) rowVector.get(0);
            try{
                Show show = showDao.retrieve(showId);
                String title = (String)aValue;
                System.out.println("Title: " + title);
                show.setShowTitle(title);
                showDao.update(show);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
            rowVector.add(columnIndex, aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
