import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Moviemanager implements ActionListener {
	JFrame movie;
	JLayeredPane layeredpane;
	JPanel crud;
	JButton add;
	JButton show;
	JButton update;
	JButton delete;
	JButton exit;
	JPanel addpanel;
	JPanel subaddpanel;
	JLabel name;
	JTextField name_field;
	JLabel Director;
	JTextField Director_field;
	JRadioButton Movie;
	JRadioButton Series;
	JRadioButton Anime;
	JButton Save;
	JButton Reset;
	String type;
	JTable table;
	JScrollPane pane;
	JPanel crud2;
	JLabel search;
	JTextField search_field;
	JLabel Catalog;
	JPanel whitepanel;
	JLabel manage;
	ButtonGroup group;
	
	Moviemanager(){
		//creates a frame
		movie =new JFrame();
		//creates a layered pane
		layeredpane=new JLayeredPane();
		layeredpane.setBounds(0, 0, 800, 550);
	
		//creates a table
		crud=new JPanel();
		crud.setLayout(new BorderLayout());
		crud.setBounds(160, 330, 500,100);

		//creates a  panel
		addpanel=new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(0, 0, 800, 550);
		addpanel.setBackground(new Color(51,153,255));
		
		//creates a subpanel
		subaddpanel=new JPanel();
		subaddpanel.setLayout(null);
		subaddpanel.setBounds(110, 20, 650, 250);
		subaddpanel.setBackground(Color.WHITE);
		addpanel.add(subaddpanel);
		
		//creates a search label
		search= new JLabel("Search");
		search.setBounds(325, 68, 80, 30);
		search.setForeground(new Color(51,153,255));
		search.setFont(new Font("Cambria", Font.BOLD, 18));
		subaddpanel.add(search);
		
		//creates a search field
		search_field=new JTextField();
		search_field.setBounds(400, 70, 200, 25);
		subaddpanel.add(search_field);
		search_field.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field.getText();
            	search(searchString);
            }
        });
		
		
		//creates a add button
		add=new JButton("Add");
		add.setBounds(150,180, 80, 30);
		add.setFocusable(false);
		add.setBackground(new Color(51,153,255));
		add.setForeground(new Color(255,255,255));
		add.addActionListener(this);
		subaddpanel.add(add); 
		
		//creates a refresh button
		show=new JButton("Refresh");
		show.setBounds(250,180, 80, 30);
		show.setBackground(new Color(51,153,255));
		show.setForeground(new Color(255,255,255));
		show.setFocusable(false);
		show.addActionListener(this);
		subaddpanel.add(show); 
		
		//creates a update button
		update=new JButton("Update");
		update.setBounds(350,180, 80, 30);
		update.setBackground(new Color(51,153,255));
		update.setForeground(new Color(255,255,255));
		update.setFocusable(false);
		update.addActionListener(this);
		subaddpanel.add(update); 
		
		//creates a delete button
		delete=new JButton("Delete");
		delete.setBounds(450,180, 80, 30);
		delete.setBackground(new Color(51,153,255));
		delete.setForeground(new Color(255,255,255));
		delete.setFocusable(false);
		delete.addActionListener(this);
		subaddpanel.add(delete); 
		
		//creates the exit button
		exit=new JButton("Exit");
		exit.setBounds(700,450, 70, 20);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(0,0,0));
		exit.setFocusable(false);
		exit.addActionListener(this);
		addpanel.add(exit); 
		
		
		//creates the name label
		name=new JLabel("Name :");
		name.setBounds(15, 65, 80, 30);
		name.setForeground(new Color(51,153,255));
		name.setFont(new Font("Cambria", Font.BOLD, 18));
		subaddpanel.add(name);
		
		//creates the name text field
		name_field=new JTextField();
		name_field.setBounds(80, 70, 200, 25);
		subaddpanel.add(name_field);
		
		//creates the director label
		Director=new JLabel("Director:");
		Director.setBounds(12, 115, 80, 25);
		Director.setForeground(new Color(51,153,255));
		Director.setFont(new Font("Cambria", Font.BOLD, 16));
		subaddpanel.add(Director);
		
		//creates the director text field
		Director_field=new JTextField();
		Director_field.setBounds(80, 120, 200, 25);
		subaddpanel.add(Director_field);
		
		//creates the show lsit label
		Catalog=new JLabel("Show list");
		Catalog.setBounds(350, 280, 300, 30);
		Catalog.setForeground(new Color(255,255,255));
		Catalog.setFont(new Font("Callibri", Font.BOLD, 26));
		addpanel.add(Catalog);
		
		//creates the title
		manage=new JLabel("My Shows Manager");
		manage.setBounds(200, 10, 400, 30);
		manage.setForeground(new Color(51,153,255));
		manage.setFont(new Font("Times new roman", Font.BOLD, 30));
		subaddpanel.add(manage);
		
		
		
		//creates a movie radio button
		Movie=new JRadioButton("Movie");
		Movie.setBounds(390,110,80,30);
		Movie.setBackground(Color.WHITE);
		Movie.setFocusable(false);
		subaddpanel.add(Movie);
		
		//creates a series radio button
		Series=new JRadioButton("Series");
		Series.setBounds(470,110,80,30);
		Series.setBackground(Color.WHITE);
		Series.setFocusable(false);
		subaddpanel.add(Series);
		
		//creates a anime radio button
		Anime=new JRadioButton("Anime");
		Anime.setBounds(550,110,80,30);
		Anime.setBackground(Color.WHITE);
		Anime.setFocusable(false);
		subaddpanel.add(Anime);
		
		//creates a group of radio button
		group=new ButtonGroup();
		group.add(Movie);
		group.add(Series);
		group.add(Anime);
		
		layeredpane.add(crud, Integer.valueOf(1));
		layeredpane.add(addpanel, Integer.valueOf(0));
		
		//displays the table
		show_user();
		//sets the size title and lay out of the main frame
		movie.setSize(800,550);
		movie.setTitle("Movie manager");
		movie.add(layeredpane);
		movie.getContentPane().setBackground(Color.WHITE);
		movie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		movie.setResizable(false);
		movie.setLayout(null);
		movie.setVisible(true);
	
		

		
	}
	//retrieves data from data base and stores it in an arraylist
	public ArrayList<User> userlist(){
		ArrayList<User> userlist=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/softwarica","root","123456abc");
			String query="Select * from movie";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			User user;
			while(rs.next()) {
				user=new User(rs.getInt("sn"),rs.getString("movie_name"),rs.getString("director_name"),rs.getString("type"));
				//using the user object to store into the user list
				userlist.add(user);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return userlist;
	}
	//retrieves the data from arraylist then shows it into the JTABLE
	public void show_user() {
		ArrayList<User>list=userlist();
		table=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[4];
		columnNames[0]="Sn";
		columnNames[1]="Name";
		columnNames[2]="Director";
		columnNames[3]="Type";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getMovie_name();
			row[2]=list.get(i).getDirector_name();
			row[3]=list.get(i).getType();
			model.addRow(row);
			}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setLayout(null);
		table.setBounds(20, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int i = table.getSelectedRow();
		        TableModel model=table.getModel();
		        name_field.setText(model.getValueAt(i, 1).toString());
		        Director_field.setText(model.getValueAt(i, 2).toString());
		        String genre =model.getValueAt(i, 3).toString();
		        if (genre.equals("Movie")) {
		        	Movie.setSelected(true);
		        }
		        else if(genre.equals("Series")) {
		        	Series.setSelected(true);
		        }
		        else {
		        	Anime.setSelected(true);
		        }
		    }
		});
		//Jtable added to the scrollpane
		pane=new JScrollPane(table);
		crud.add(pane);
		
	}
	//makes the buttons functionable
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//inserts data into the jtable
		 if(e.getSource()==add) {
			try {
				
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/softwarica","root","123456abc");
				PreparedStatement myState= myConn.prepareStatement("insert into movie"+"(movie_name,director_name,type)"+"values(?,?,?)");
				Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update movie set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table movie Auto_increment=1");
				
				myState.setString(1, name_field.getText() );
				myState.setString(2, Director_field.getText());
				if(Movie.isSelected()) {
					type="Movie";
				}
				else if(Series.isSelected()) {
					type="Series";
				}
				else {
					type="Anime";
				}
				myState.setString(3,type);
				myState.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted successfully");  
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset();
				//refreshes the jtable
				update();
				
				
				

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		 //updates jtable 
		 else if(e.getSource()==update) {
			 try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/softwarica","root","123456abc");
					int row = table.getSelectedRow();
					String value=(table.getModel().getValueAt(row, 0).toString());
					String query="UPDATE movie SET movie_name=?,director_name=?,type=? where sn="+value;
					PreparedStatement myState= myConn.prepareStatement(query);
					//3.Execute sql query
					myState.setString(1, name_field.getText() );
					myState.setString(2, Director_field.getText());
					if(Movie.isSelected()) {
						type="Movie";
					}
					else if(Series.isSelected()) {
						type="Series";
					}
					else {
						type="Anime";
					}
					myState.setString(3,type);
					myState.executeUpdate();
					JOptionPane.showMessageDialog(null,"Updated successfully");  
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//resets the row to 0
					model.setRowCount(0);
					//empties the jtex feild and unselects the radio buttons
					reset();
					//refreshes the jtable
					update();
			 }
			 catch (java.lang.ArrayIndexOutOfBoundsException exc) {
				 JOptionPane.showMessageDialog(null,"Select a row first"); 
			 }
			 catch (Exception exc) {
					exc.printStackTrace();
				}
		 }
		 //deletes a row of data
		 else if(e.getSource()==delete) {
			 try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/softwarica","root","123456abc");
					int row = table.getSelectedRow();
					String value=(table.getModel().getValueAt(row, 0).toString());
					Statement stmt = myConn.createStatement();
					stmt.execute("DELETE FROM movie WHERE sn="+value);
					JOptionPane.showMessageDialog(null,"Deleted successfully");  
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//resets the row to 0
					model.setRowCount(0);
					//empties the jtex feild and unselects the radio buttons
					reset();
					//refreshes the jtable
					update();
			 
			 }
			 catch (java.lang.ArrayIndexOutOfBoundsException exc) {
				 JOptionPane.showMessageDialog(null,"Select a row first"); 
			 }
			 catch (Exception exc) {
					exc.printStackTrace();
			 }
		 }
		 //exits the management system
		 else if (e.getSource()==exit) {
			 movie.dispose();
		 }
		 //refreshes the table
		 else {
			 try {
				 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/softwarica","root","123456abc");
				 Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update movie set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table movie Auto_increment=1");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset();
				//refreshes the jtable
				update();
				
			 }
		catch (Exception exc) {
			exc.printStackTrace();
			 }
		 }
	}
	//refreshes the jtable
	public void update() {
		// TODO Auto-generated method stub
		ArrayList<User>list=userlist();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getMovie_name();
			row[2]=list.get(i).getDirector_name();
			row[3]=list.get(i).getType();
			model.addRow(row);
			}
	}
	//empties the jtext feild and unselects the radio buttons
	public void reset() {
			name_field.setText(" ");
			Director_field.setText(" ");
			group.clearSelection();
	}
	//search bar for searching
	public void search(String str) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}

		



		

	}
