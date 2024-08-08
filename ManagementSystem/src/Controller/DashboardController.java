package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;

import Models.customerData;
import Models.getData;
import Models.itemData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Database.DBConnect;
import Database.Database;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
//import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class DashboardController implements Initializable {
	
    @FXML
    private AnchorPane topForm;
	
	
    @FXML
    private TextField adMovies_duration;

    @FXML
    private ImageView adMovies_imageView;

    @FXML
    private TableColumn<itemData, String> addMovie_col_genre;

    @FXML
    private TableColumn<itemData, String> addMovie_col_genre1;

    @FXML
    private Button addMovies_btn;

    @FXML
    private Button addMovies_clearBtn;

    @FXML
    private TableColumn<itemData, String> addMovies_col_date;

    @FXML
    private TableColumn<itemData, String> addMovies_col_duration;

    @FXML
    private TableColumn<itemData, String> addMovies_col_movieTitle;

    @FXML
    private DatePicker addMovies_date;

    @FXML
    private Button addMovies_deleteBtn;

    @FXML
    private AnchorPane addMovies_form;

    @FXML
    private TextField addMovies_genre;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button addMovies_insertBtn;

    @FXML
    private TextField addMovies_movieTitle;

    @FXML
    private TextField addMovies_search;

    @FXML
    private TableView<itemData> addMovies_tableView;

    @FXML
    private Button addMovies_updateBtn;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private Button availableMovies_buyBtn;

    @FXML
    private Button availableMovies_clearBtn;

    @FXML
    private TableColumn<itemData, String> availableMovies_col_genre;

    @FXML
    private TableColumn<itemData, String> availableMovies_col_movieTitle;

    @FXML
    private TableColumn<itemData, String> availableMovies_col_showingDate;

    @FXML
    private Label availableMovies_date;

    @FXML
    private AnchorPane availableMovies_form;

    @FXML
    private Label availableMovies_genre;

    @FXML
    private ImageView availableMovies_imageView;

    @FXML
    private Label availableMovies_movieTitle;

    @FXML
    private Label availableMovies_normalClass_price;

    @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;

    @FXML
    private Button availableMovies_receiptBtn;

    @FXML
    private Button availableMovies_selectMovie;

    @FXML
    private Label availableMovies_specialClass_price;

    @FXML
    private Spinner<Integer> availableMovies_specialClass_quantity;

    @FXML
    private TableView<itemData> availableMovies_tableView;

    @FXML
    private Label availableMovies_title;

    @FXML
    private Label availableMovies_total;

    @FXML
    private Button customers_btn;

    @FXML
    private Button customers_clearBtn;

    @FXML
    private TableColumn<customerData, String> customers_col_dateChecked;

    @FXML
    private TableColumn<customerData, String> customers_col_movieTitle;

    @FXML
    private TableColumn<customerData, String> customers_col_ticketNumber;

    @FXML
    private TableColumn<customerData, String> customers_col_timeChecked;

    @FXML
    private Label customers_dateChecked;

    @FXML
    private Button customers_deleteBtn;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private Label customers_genre;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private TextField customers_search;

    @FXML
    private TableView<customerData> customers_tableView;

    @FXML
    private Label customers_ticketNumber;

    @FXML
    private Label customers_timeChecked;

    @FXML
    private Label dashboard_availableMovies;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_total;

    @FXML
    private Label dashboard_totalEarnToday;

    @FXML
    private Button editScreening_btn;

    @FXML
    private TableColumn<itemData, String> editScreening_col_current;

    @FXML
    private TableColumn<itemData, String> editScreening_col_duration;

    @FXML
    private TableColumn<itemData, String> editScreening_col_genre;

    @FXML
    private TableColumn<itemData, String> editScreening_col_movieTitle;

    @FXML
    private ComboBox<?> editScreening_current;

    @FXML
    private Button editScreening_deleteBtn;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableView<itemData> editScreening_tableView;

    @FXML
    private Label editScreening_title;

    @FXML
    private Button editScreening_updateBtn;

    @FXML
    private Button minimize;

    @FXML
    private Button signout;

    @FXML
    private Label username;
    
	private double x = 0;
	private double y = 0;
	
    // TOols for connection
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;
    
    
    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    
    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    
    
    
    private int qty1 = 0;
    private int qty2 = 0;
    
    private int ticketSold;
    private double revenueToday;
    private int totalAvmovies;
    
    
    public void totalAvMovies() {
    	
    	String sql = "SELECT count(id) FROM iitstore_itemData WHERE current = 'Available'";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			totalAvmovies = result.getInt("COUNT(id)");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	
    }
    
    public void displayTotalAvaMovies() {
    	totalAvMovies();
    	dashboard_availableMovies.setText(String.valueOf(totalAvmovies));
    }
    
    public void totalalRevenue() {
    	Date date = new Date();
    	
    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    	
    	String sql = "SELECT sum(total) FROM iitstore_customer where date = '" + String.valueOf(sqlDate) + "' ";
    	
    	connect = Database.connectDB();
    	
    	try{
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			revenueToday = result.getDouble("SUM(total)");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void displayTodayRevenue() {
    	totalalRevenue();
    	dashboard_totalEarnToday.setText(String.valueOf(revenueToday));
    }
    
    
    
    public void countTicket() {
    	
    	String sql = "SELECT count(id) FROM iitstore_customer";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		if(result.next()) {
    			System.out.println("resultt");
    			getData.ticket = result.getInt("count(id)");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    
    public void displayTotalTickets() {
    	countTicket();
    	dashboard_total.setText(String.valueOf(getData.ticket));
    }
   
    
    
    public void selectCustomerList() {
    	
		customerData CD = customers_tableView.getSelectionModel().getSelectedItem();
		int index = customers_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		customers_ticketNumber.setText(String.valueOf(CD.getId()));
		customers_movieTitle.setText(CD.getTitle());
		customers_dateChecked.setText(String.valueOf(CD.getDate()));
		customers_timeChecked.setText(String.valueOf(CD.getTime()));
    	
    }
    
    public ObservableList<customerData> customerList(){
    	
    	ObservableList<customerData> customerL = FXCollections.observableArrayList();
    	
    	String sql = "SELECT * FROM iitstore_customer";
    	connect = Database.connectDB();
    	
    	try {
    		
    		customerData CD;
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		while(result.next()) {
    			CD = new customerData(result.getInt("id"), result.getString("type"), result.getString("title"), result.getInt("quantity"), result.getDouble("total"),
    					result.getDate("date"), result.getTime("time"));
    			
    			customerL.add(CD);
    		}
    		
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return customerL;
    }
    
    
    private ObservableList<customerData> cList;
    
    public void showCustomerList() {
    	cList = customerList();
    	
    	
    	customers_col_ticketNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
    	customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	customers_col_dateChecked.setCellValueFactory(new PropertyValueFactory<>("date"));
    	customers_col_timeChecked.setCellValueFactory(new PropertyValueFactory<>("time"));
    	
    	customers_tableView.setItems(cList);
    	
    	
    }
    
    public void clearCustomerSelection() {
    	customers_ticketNumber.setText("");
    	customers_movieTitle.setText("");
    	customers_dateChecked.setText("");
    	customers_timeChecked.setText("");
    }
    
    public void refundCustomerTicker() {
    	
    	Alert alert;
    	
    	if(customers_ticketNumber.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select item first");
			alert.showAndWait();
    	}
    	else {
    		String sql = "DELETE FROM iitstore_customer where id = '" + customers_ticketNumber.getText() + "'";
    		
    		connect = Database.connectDB();
    		
    		try {
    			
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message!!");
				
				alert.setHeaderText(null);
				alert.setContentText("Do you really want to refund item for '" + customers_movieTitle.getText() + "' ? ");
    			
    			Optional<ButtonType> option = alert.showAndWait();
    			
    			if(ButtonType.OK.equals(option.get())) {
    				
        			statement = connect.createStatement();
        			statement.executeUpdate(sql);
        			
					alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Item successfully refunded");
	    			
	    			alert.showAndWait();
	    			
	    			showCustomerList();
	    			clearCustomerSelection();
    				
    			} else {
    				return;
    			}
    			
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
    
    
    public void receipt() {
    	
    }
    
    
    
    
    public void buy() {
    	
    	String sql = "INSERT INTO iitstore_customer (type,title,quantity,total,date,time) VALUES (?,?,?,?,?,?)";
    	
    	connect = Database.connectDB();
    	String type = "";
    	if(price1>0 && price2 == 0) {
    		type = "Special Packing";
    	}else if(price1==0 && price2>0) {
    		type="Normal Packing";
    	}else if(price1>0 && price2>0) {
    		type="Special & Normal Packing";
    	}
    	
    	Date date = new Date();
    	java.sql.Date setDate = new java.sql.Date(date.getTime());
    	
    	LocalTime lt = LocalTime.now();
    	
    	Time time = Time.valueOf(lt);
    	
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, type);
    		prepare.setString(2, availableMovies_title.getText());
    		prepare.setString(3,  String.valueOf(qty1 + qty2));
    		prepare.setString(4, String.valueOf(total));
    		prepare.setString(5, String.valueOf(setDate));
    		prepare.setString(6, String.valueOf(time));
    		
    		
    		Alert alert;
    		
    		if(availableMovies_imageView.getImage() == null || availableMovies_title.getText().isEmpty()) {
    			
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please select item first");
    			alert.showAndWait();
    			
    		}
    		else if(price1 == 0 && price2 == 0) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please select quantity of item first");
    			alert.showAndWait();
    		}else {
    			prepare.executeUpdate();
    			
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Your item has been purchased");
    			alert.showAndWait();
    			
    			
    			String sql1 = "SELECT * FROM iitstore_customer";
    			prepare = connect.prepareStatement(sql1);
    			result = prepare.executeQuery();
    			int num = 0;
    			while(result.next()) {
    				num = result.getInt("id");
    			}
    			System.out.println(num + "this isss");
    			String sql2 = "INSERT INTO iitstore_customer_info (customer_id,type,total,itemTitle) VALUES (?,?,?,?)";
    			
    			prepare = connect.prepareStatement(sql2);
    			
    			prepare.setString(1, String.valueOf(num));
    			prepare.setString(2, type);
    			prepare.setString(3,  String.valueOf(total));
    			prepare.setString(4, availableMovies_title.getText());
    			
    			prepare.execute();
    			
    			clearPurchaseInfo();
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void clearPurchaseInfo() {
    
    	spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	
    	
    	availableMovies_specialClass_quantity.setValueFactory(spinner1);
    	availableMovies_normalClass_quantity.setValueFactory(spinner2);
    	
    	availableMovies_specialClass_price.setText("$0.0");
    	availableMovies_normalClass_price.setText("$0.0");
    	
    	availableMovies_imageView.setImage(null);
    	
    	availableMovies_total.setText("$0.0");
    	
    	
    	
    }
    
    
    public void showSpinnerValue() {
    	spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	
    	availableMovies_specialClass_quantity.setValueFactory(spinner1);
    	availableMovies_normalClass_quantity.setValueFactory(spinner2);
    }
    
    public void getSpinnerValue() {
    	qty1 = availableMovies_specialClass_quantity.getValue();
    	qty2 = availableMovies_normalClass_quantity.getValue();
    	
    	
    	price1 = qty1 * 20;
    	price2 = qty2 * 10;
    	
    	total = price1 + price2;
    	
    	availableMovies_specialClass_price.setText("$" + String.valueOf(price1));
    	availableMovies_normalClass_price.setText("$" + String.valueOf(price2));
    	
    	availableMovies_total.setText("$" + String.valueOf(total));
    }
    
    
    
    // Available movies form
    
    public ObservableList<itemData> availableMovieList(){
    	ObservableList<itemData> listAvMovie = FXCollections.observableArrayList();
    	
    	String sql = "SELECT * FROM iitstore_itemData WHERE current = 'Available'";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		itemData movD;
    		
    		while(result.next()) {
    			movD = new itemData(result.getInt("id"), result.getString("itemTitle"), result.getString("category"), result.getString("image"), result.getString("price"), result.getDate("date"), result.getString("current"));
    			listAvMovie.add(movD);
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return listAvMovie;
    }
    
    
    private ObservableList<itemData> availableMovieList;
    
    public void showAvailableMovies() {
    	availableMovieList = availableMovieList();
    	
    	availableMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	availableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("category"));
    	availableMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("price"));
    	
    	availableMovies_tableView.setItems(availableMovieList);
    }
    
    
	public void selectAvailableMovie() {
		itemData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();
		int index = availableMovies_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		
		getData.path = movD.getImage();
		getData.movieId = movD.getId();
		
		availableMovies_movieTitle.setText(movD.getTitle());
		availableMovies_genre.setText(movD.getCategory());
		availableMovies_date.setText(String.valueOf(movD.getPrice()));
		
		getData.path = movD.getImage();
		getData.title = movD.getTitle();
		
	}
	
	
	public void selectMovie() {
		
		Alert alert;
		
		if(availableMovies_movieTitle.getText().isEmpty() || availableMovies_date.getText().isEmpty() || availableMovies_genre.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select item first");
			alert.showAndWait();
		} else {
			String filePath = "file://" + getData.path;
			
			image = new Image(filePath, 150, 168, false, true);
			availableMovies_imageView.setImage(image);			
			availableMovies_title.setText(getData.title);
			
			// after selecting movie clear text
			
			availableMovies_movieTitle.setText("");
			availableMovies_genre.setText("");
			availableMovies_date.setText("");
		}
		
	}
    
    // current list
    
    private String[] currentList = {"Available", "Not Available"};
    
    public void comboBox() {
    	List<String> listCurrent = new ArrayList<>();
    	
    	for(String data:currentList) {
    		listCurrent.add(data);
    	}
    	
    	ObservableList listC = FXCollections.observableArrayList(listCurrent);
    	
    	editScreening_current.setItems(listC);
    }
    
    // screening
    
    public ObservableList<itemData> editScreeningList(){
    	ObservableList<itemData> editSList = FXCollections.observableArrayList();
    	
    	
    	connect = Database.connectDB();
    	String sql = "SELECT * FROM iitstore_itemData";
    	try {
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		
    		itemData movD;
    		while(result.next()) {
    			movD = new itemData(result.getInt("id"), result.getString("itemTitle"), result.getString("category"), result.getString("image"), result.getString("price"), result.getDate("date"), result.getString("current"));
    			
    			editSList.add(movD);
    		}
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return editSList;
    }
    
    
    private ObservableList<itemData> editScreeningL;
    
    public void showEditScreening() {
    	editScreeningL = editScreeningList();
    	
    	editScreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("category"));
    	editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("price"));
    	editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));
    	
    	editScreening_tableView.setItems(editScreeningL);
    }
    
    
    public void updateEditScreening() {
    	
    	String sql = "UPDATE iitstore_itemData SET current ='" + editScreening_current.getSelectionModel().getSelectedItem() + "' WHERE itemTitle = '" + editScreening_title.getText() + "'";
    	
    	connect = Database.connectDB();
    	
    	try {
    		statement = connect.createStatement();
    		
    		
    		Alert alert;
    		if(editScreening_title.getText().isEmpty() || editScreening_imageView.getImage() == null || editScreening_current.getSelectionModel().isEmpty()) {
    			
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill all blank fields/Select item");
    			
    			alert.showAndWait();
    			
    		}else {
    			statement.executeUpdate(sql);
    			
    			
				alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Item Availability updated");
    			
    			alert.showAndWait();
    			showEditScreening();
    			clearEditScreening();
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
    
    
    public void clearEditScreening() {
    	editScreening_imageView.setImage(null);
    	editScreening_title.setText("");
//    	editScreening_current.setSelectionModel(null);
    	
    }
    
    public void selectEditScreening() {
    	itemData movD = editScreening_tableView.getSelectionModel().getSelectedItem();
    	
		int index = editScreening_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		editScreening_title.setText(movD.getTitle());
		
		String filePath = "file://" + movD.getImage();
		
		image = new Image(filePath, 141, 178, false, true);
		editScreening_imageView.setImage(image);		
    }
    
    
	// movie list
	
	public ObservableList<itemData> addMovieList(){
		ObservableList<itemData> listData = FXCollections.observableArrayList();
		
		String sql = "SELECT * FROM iitstore_itemData";
		connect = Database.connectDB();
		
		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			itemData movD;
			while(result.next()) {
				movD = new itemData(result.getInt("id"), result.getString("itemTitle"), result.getString("category"), result.getString("image"), result.getString("price"), result.getDate("date"), result.getString("current"));
				listData.add(movD);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listData;
		
	}
	
	// display movies in DB on table
	public void showAddmoviesList() {
		listAddMovies = addMovieList();
		
		addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		addMovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("category"));
		addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("price"));
		addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));		
		addMovies_tableView.setItems(listAddMovies);
		
	}
    
	
	
	private ObservableList<itemData> listAddMovies;
	
	
	
	// Search movie
	
	public void searchAddMovie() {
		
		FilteredList<itemData> filter = new FilteredList<>(listAddMovies, e->true);
		
		addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {
			filter.setPredicate(predicateMoviesData -> {
				if(newValue.isEmpty() || newValue == null) {
					return true;
				}
								
				String keySearch = newValue.toLowerCase();
				
				System.out.println(keySearch + "wdkmflwfmk");
				
				if(predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCategory().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getPrice().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getDate().toString().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCurrent().toString().contains(keySearch)) {
					return true;
				}
				
				return false;
			});
			
			SortedList<itemData> sortData = new SortedList<>(filter);
			sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());
			System.out.println(sortData);
			addMovies_tableView.setItems(sortData);
		});
		
	}
	
	
	
	// search screening
	public void searchEditScreening() {
		FilteredList<itemData> filter = new FilteredList<>(editScreeningL, e->true);
		
		editScreening_search.textProperty().addListener((observable, oldValue, newValue) -> {
			filter.setPredicate(predicateMoviesData -> {
				if(newValue.isEmpty() || newValue == null) {
					return true;
				}
				
				String keySearch = newValue.toLowerCase();
				
				if(predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCategory().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getPrice().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCurrent().toString().contains(keySearch)) {
					return true;
				}
				
				return false;
			});
			
			SortedList<itemData> sortData = new SortedList<>(filter);
			sortData.comparatorProperty().bind(editScreening_tableView.comparatorProperty());
			
			editScreening_tableView.setItems(sortData);
			
		});
	}
	

	
	public void selectAddMoviesList() {
		itemData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
		int index = addMovies_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		
		getData.path = movD.getImage();
		getData.movieId = movD.getId();
		
		addMovies_movieTitle.setText(movD.getTitle());
		addMovies_genre.setText(movD.getCategory());
		adMovies_duration.setText(movD.getPrice());
		
		String movDate = String.valueOf(movD.getDate());
		
//		addMovies_date.setValue(movD.getDate());
		
		String filePath = "file://" + movD.getImage();
		
		image = new Image(filePath, 141, 178, false, true);
		adMovies_imageView.setImage(image);
		
		addMovies_date.setValue(movD.getDate().toLocalDate());
		
	}
	
	
	public void importImage() {
		
		
		FileChooser open = new FileChooser();
		open.setTitle("Open movie cover image file");
//		open.getExtensionFilters().add(new ExtensionFilter("Image File", "png", "jpg"));
		
		Stage stage = (Stage)addMovies_form.getScene().getWindow();
		
		File file = open.showOpenDialog(stage);
		
		if(file != null) {
			image = new Image(file.toURI().toString(), 141, 178, false, true);
			adMovies_imageView.setImage(image);
			
			getData.path = file.getAbsolutePath();
		}
		
		
	}
	
	
	
	public void movieId() {
		
		String sql = "SELECT count(id) FROM iitstore_itemData";
		
		connect = Database.connectDB();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			if(result.next()) {
				getData.movieId = result.getInt("count(id)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void insertAddMovies() {
		
		
		
		String movieTitle = "SELECT * FROM iitstore_itemData WHERE itemTitle = '" + addMovies_movieTitle.getText() + "'";
		connect = Database.connectDB();
		
		Alert alert;
		
		try {
			
			statement = connect.createStatement();
			result = statement.executeQuery(movieTitle);
			
			if(result.next()) {
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText(addMovies_movieTitle.getText() + " was already in database");
    			
    			alert.showAndWait();
			}else {
				
				if(addMovies_movieTitle.getText().isEmpty() || addMovies_genre.getText().isEmpty() || adMovies_duration.getText().isEmpty()
						|| adMovies_imageView.getImage() == null || addMovies_date.getValue() == null) {
					alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Error");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Please fill in the blank fields...");
	    			
	    			alert.showAndWait();
				}else {
					String sql = "INSERT INTO iitstore_itemData (id,itemTitle,category,price,image,date,current) VALUES (?,?,?,?,?,?,?)";
					
					
					// get image path if all fields are valid
					String imagePath = getData.path;
					
					movieId();
					
					String mId = String.valueOf(getData.movieId + 1);
					
					// prepare sql statement
					prepare = connect.prepareStatement(sql);
					prepare.setString(1, mId);
					prepare.setString(2, addMovies_movieTitle.getText());
					prepare.setString(3, addMovies_genre.getText());
					prepare.setString(4, adMovies_duration.getText());
					prepare.setString(5, imagePath);
					prepare.setString(6, String.valueOf(addMovies_date.getValue()));
					prepare.setString(7,  "Available");
					
					// insert data in table
					
					prepare.execute();
					
					alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Item successfully added in database");
	    			
	    			alert.showAndWait();
	    			
	    			clearAddMoviesList();
	    			showAddmoviesList();
	    			
				}
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	public void updateMovies() {
		String url = getData.path;
		
		String updateSql = "UPDATE iitstore_itemData SET itemTitle = '" + addMovies_movieTitle.getText() + "', category = '" + addMovies_genre.getText() + "', price = '" + adMovies_duration.getText() + "', image = '" + url + "', date = '" + addMovies_date.getValue() + "' WHERE id = '" + String.valueOf(getData.movieId) + "' ";
		
		connect = Database.connectDB();
		
		try {
			
			statement = connect.createStatement();
			
			Alert alert;
			
			if(addMovies_movieTitle.getText().isEmpty() || addMovies_genre.getText().isEmpty() || adMovies_duration.getText().isEmpty()
					|| adMovies_imageView.getImage() == null || addMovies_date.getValue() == null) {
				
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("Please select the item to update");
    			
    			alert.showAndWait();
				
			}else {
				
				statement.executeUpdate(updateSql);
				
				alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Data successfully updated data for '" + addMovies_movieTitle.getText() + "'");
    			
    			alert.showAndWait();
    			showAddmoviesList();
    			clearAddMoviesList();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void deleteMovie() {
		String sql = "DELETE FROM iitstore_itemData WHERE itemTitle = '" + addMovies_movieTitle.getText()  + "'";
		
		connect = Database.connectDB();
		
		try {
			
			Alert alert;
			
			statement = connect.createStatement();
			
			if(addMovies_movieTitle.getText().isEmpty() || addMovies_genre.getText().isEmpty() || adMovies_duration.getText().isEmpty()
					|| adMovies_imageView.getImage() == null || addMovies_date.getValue() == null) {
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill in the blank fields...");
    			
    			alert.showAndWait();
			} else {
				
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message!!");
				
				alert.setHeaderText(null);
				alert.setContentText("Do you really want to delete item '" + addMovies_movieTitle.getText() + "' from database? ");
    			
    			Optional<ButtonType> option = alert.showAndWait();
    			
    			if(ButtonType.OK.equals(option.get())) {
    				
					
    				statement.executeUpdate(sql);
					alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Item successfully DELETED from Database");
	    			
	    			alert.showAndWait();
	    			
	    			showAddmoviesList();
	    			clearAddMoviesList();
    				
    			} else {
    				return;
    			}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clearAddMoviesList() {
		
		addMovies_movieTitle.setText("");
		addMovies_genre.setText("");
		adMovies_duration.setText("");
		adMovies_imageView.setImage(null);
		addMovies_date.setValue(null);
		
	}
    
    
    //log out
    public void logOut() {
    	signout.getScene().getWindow().hide();
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
			
			
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			
	        root.setOnMousePressed((MouseEvent event) -> {
	        	x = event.getSceneX();
	        	y = event.getSceneY();
	        });
	        
	        root.setOnMouseDragged((MouseEvent event) -> {
	        	stage.setX(event.getScreenX() - x);
	        	stage.setY(event.getScreenY() - y);
	        });
			
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.setScene(scene);
			stage.show();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // switch between different forms
    
    public void switchForm(ActionEvent event) {
    	
    
    	// switch to dashboatd
    	if(event.getSource()== dashboard_btn) {
    		dashboard_form.setVisible(true);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		customers_form.setVisible(false);
    		
    		dashboard_btn.setStyle("-fx-background-color:#ae2d3c");
    		addMovies_btn.setStyle("-fx-background-color:transparent");
    		availableMovies_btn.setStyle("-fx-background-color:transparent");
    		editScreening_btn.setStyle("-fx-background-color:transparent");
    		customers_btn.setStyle("-fx-background-color:transparent");
    		
    		displayTotalTickets();
    		displayTotalAvaMovies();
    		displayTodayRevenue();
    		
    	}else if(event.getSource()==addMovies_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(true);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		customers_form.setVisible(false);
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: #ae2d3c");
    		availableMovies_btn.setStyle("-fx-background-color:transparent");
    		editScreening_btn.setStyle("-fx-background-color:transparent");
    		customers_btn.setStyle("-fx-background-color:transparent");
    		
    		showAddmoviesList();
    		
    		
    	}else if(event.getSource()==availableMovies_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(true);
    		editScreening_form.setVisible(false);
    		customers_form.setVisible(false);
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: transparent");
    		availableMovies_btn.setStyle("-fx-background-color: #ae2d3c");
    		editScreening_btn.setStyle("-fx-background-color:transparent");
    		customers_btn.setStyle("-fx-background-color:transparent");
    		
    		showAvailableMovies();
    		
    	}else if(event.getSource()==editScreening_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(true);
    		customers_form.setVisible(false);
    		
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: transparent");
    		availableMovies_btn.setStyle("-fx-background-color: transparent");
    		editScreening_btn.setStyle("-fx-background-color: #ae2d3c");
    		customers_btn.setStyle("-fx-background-color:transparent");
    		
    		showEditScreening();
    		
    		
    	}else if(event.getSource()==customers_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		customers_form.setVisible(true);
    		
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: transparent");
    		availableMovies_btn.setStyle("-fx-background-color: transparent");
    		editScreening_btn.setStyle("-fx-background-color: transparent");
    		customers_btn.setStyle("-fx-background-color: #ae2d3c");
    		
    		showCustomerList();
    	}
    	
    }
 
    
    // Display username in side panel
    public void displayUsername() {
    	username.setText(getData.username);
    }
    
    
    public void close() {
    	System.out.println("closing dadboard");
    	System.exit(0);
    }
    
    
    
    public void minimize() {
    	Stage stage = (Stage)topForm.getScene().getWindow();
    	stage.setIconified(true);
    }

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//display the username on dashboard
		
		displayUsername();
		showAddmoviesList(); // pull data from database
		showEditScreening(); // pull edit screening data from DB
		comboBox(); // add combobox options
		showAvailableMovies(); // show available movies in available movies form
		showSpinnerValue();
		
		showCustomerList(); // show customer data on dashboard
		
		displayTotalTickets();
		displayTotalAvaMovies();
		displayTodayRevenue();
		
		
		
		if(getData.role == 2) {
			addMovies_btn.setDisable(true);
			editScreening_btn.setDisable(true);
			customers_btn.setDisable(true);
		}
		
	}
}
