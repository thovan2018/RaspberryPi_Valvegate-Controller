package valvegate;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ValvegateController implements Initializable {

    @FXML
    private Tab tabLogo;
    @FXML
    private Tab Tab01;
    @FXML
    private TabPane subTab01;
    @FXML
    private TabPane subTab02;
    @FXML
    private Tab Tab02;
    @FXML
    private Tab Tab03;
    
    
    
    @FXML
    private RadioButton rbT12;
    @FXML
    private RadioButton rbT14;
    @FXML
    private RadioButton rbContact;
    @FXML
    private RadioButton rb24V;
    
    final ToggleGroup rbgroup1 = new ToggleGroup();
    final ToggleGroup rbgroup2 = new ToggleGroup();

    
    @FXML
    private ToggleButton tgglegate1;
    @FXML
    private ToggleButton tgglegate2;
    @FXML
    private ToggleButton tgglegate3;
    @FXML
    private ToggleButton tgglegate4;
    @FXML
    private ToggleButton tgglegate5;
    @FXML
    private ToggleButton tgglegate6;
    @FXML
    private ToggleButton tgglegate7;
    @FXML
    private ToggleButton tgglegate8;
    @FXML
    private ToggleButton tgglegate9;
    @FXML
    private ToggleButton tgglegate10;
    @FXML
    private ToggleButton tgglegate11;
    @FXML
    private ToggleButton tgglegate12;
    @FXML
    private ToggleButton tgglegate13;
    @FXML
    private ToggleButton tgglegate14;
    @FXML
    private ToggleButton tgglegate15;
    @FXML
    private ToggleButton tgglegate16;
    @FXML
    private ToggleButton tgglegate17;
    @FXML
    private ToggleButton tgglegate18;
    @FXML
    private ToggleButton tgglegate19;
    @FXML
    private ToggleButton tgglegate20;
    @FXML
    private ToggleButton tgglegate21;
    @FXML
    private ToggleButton tgglegate22;
    @FXML
    private ToggleButton tgglegate23;
    @FXML
    private ToggleButton tgglegate24;
    
    @FXML
    private TextField txtgate1T1;
    @FXML
    private TextField txtgate1T2;
    @FXML
    private TextField txtgate1T3;
    @FXML
    private TextField txtgate1T4;
    @FXML
    private TextField txtgate2T1;
    @FXML
    private TextField txtgate2T2;
    @FXML
    private TextField txtgate2T3;
    @FXML
    private TextField txtgate2T4;
    @FXML
    private TextField txtgate3T1;
    @FXML
    private TextField txtgate3T2;
    @FXML
    private TextField txtgate3T3;
    @FXML
    private TextField txtgate3T4;
    @FXML
    private TextField txtgate4T1;
    @FXML
    private TextField txtgate4T2;
    @FXML
    private TextField txtgate4T3;
    @FXML
    private TextField txtgate4T4;
    @FXML
    private TextField txtgate5T1;
    @FXML
    private TextField txtgate5T2;
    @FXML
    private TextField txtgate5T3;
    @FXML
    private TextField txtgate5T4;
    @FXML
    private TextField txtgate6T1;
    @FXML
    private TextField txtgate6T2;
    @FXML
    private TextField txtgate6T3;
    @FXML
    private TextField txtgate6T4;
    @FXML
    private TextField txtgate7T1;
    @FXML
    private TextField txtgate7T2;
    @FXML
    private TextField txtgate7T3;
    @FXML
    private TextField txtgate7T4;
    @FXML
    private TextField txtgate8T1;
    @FXML
    private TextField txtgate8T2;
    @FXML
    private TextField txtgate8T3;
    @FXML
    private TextField txtgate8T4;
    @FXML
    private TextField txtgate9T1;
    @FXML
    private TextField txtgate9T2;
    @FXML
    private TextField txtgate9T3;
    @FXML
    private TextField txtgate9T4;
    @FXML
    private TextField txtgate10T1;
    @FXML
    private TextField txtgate10T2;
    @FXML
    private TextField txtgate10T3;
    @FXML
    private TextField txtgate10T4;
    @FXML
    private TextField txtgate11T1;
    @FXML
    private TextField txtgate11T2;
    @FXML
    private TextField txtgate11T3;
    @FXML
    private TextField txtgate11T4;
    @FXML
    private TextField txtgate12T1;
    @FXML
    private TextField txtgate12T2;
    @FXML
    private TextField txtgate12T3;
    @FXML
    private TextField txtgate12T4;
    @FXML
    private TextField txtgate13T1;
    @FXML
    private TextField txtgate13T2;
    @FXML
    private TextField txtgate13T3;
    @FXML
    private TextField txtgate13T4;
    @FXML
    private TextField txtgate14T1;
    @FXML
    private TextField txtgate14T2;
    @FXML
    private TextField txtgate14T3;
    @FXML
    private TextField txtgate14T4;
    @FXML
    private TextField txtgate15T1;
    @FXML
    private TextField txtgate15T2;
    @FXML
    private TextField txtgate15T3;
    @FXML
    private TextField txtgate15T4;
    @FXML
    private TextField txtgate16T1;
    @FXML
    private TextField txtgate16T2;
    @FXML
    private TextField txtgate16T3;
    @FXML
    private TextField txtgate16T4;
    @FXML
    private TextField txtgate17T1;
    @FXML
    private TextField txtgate17T2;
    @FXML
    private TextField txtgate17T3;
    @FXML
    private TextField txtgate17T4;
    @FXML
    private TextField txtgate18T1;
    @FXML
    private TextField txtgate18T2;
    @FXML
    private TextField txtgate18T3;
    @FXML
    private TextField txtgate18T4;
    @FXML
    private TextField txtgate19T1;
    @FXML
    private TextField txtgate19T2;
    @FXML
    private TextField txtgate19T3;
    @FXML
    private TextField txtgate19T4;
    @FXML
    private TextField txtgate20T1;
    @FXML
    private TextField txtgate20T2;
    @FXML
    private TextField txtgate20T3;
    @FXML
    private TextField txtgate20T4;
    @FXML
    private TextField txtgate21T1;
    @FXML
    private TextField txtgate21T2;
    @FXML
    private TextField txtgate21T3;
    @FXML
    private TextField txtgate21T4;
    @FXML
    private TextField txtgate22T1;
    @FXML
    private TextField txtgate22T2;
    @FXML
    private TextField txtgate22T3;
    @FXML
    private TextField txtgate22T4;
    @FXML
    private TextField txtgate23T1;
    @FXML
    private TextField txtgate23T2;
    @FXML
    private TextField txtgate23T3;
    @FXML
    private TextField txtgate23T4;
    @FXML
    private TextField txtgate24T1;
    @FXML
    private TextField txtgate24T2;
    @FXML
    private TextField txtgate24T3;
    @FXML
    private TextField txtgate24T4;
    
    private TextField[][] textfield;
    
    @FXML
    private Label lbltime;
    @FXML
    private Label lblcycletype;
    @FXML
    private Label lblgpiostatus;
    @FXML
    private Label lblcount;
    @FXML
    private Label lblActiveGate;
    @FXML
    private Label lblSignalType;
    @FXML
    private TextField txtSession;
    
    @FXML
    private ListView<String> SessionList;
    public static final ObservableList dataList = FXCollections.observableArrayList("Default");
        
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnPowerOff;
    @FXML 
    private Button btnRestart;
    @FXML
    private Button btnTest;

    @FXML
    private GridPane btnGridpane;
    @FXML
    private GridPane ftGridpane;
    @FXML
    private GridPane ftGridpane2;
    @FXML
    private GridPane ftGridpane3;
    
    @FXML
    private ToggleButton toggleGPIO0;
    @FXML
    private ToggleButton toggleGPIO1;
    @FXML
    private ToggleButton toggleGPIO2;
    @FXML
    private ToggleButton toggleGPIO3;
    @FXML
    private ToggleButton toggleGPIO4;
    @FXML
    private ToggleButton toggleGPIO5;
    @FXML
    private ToggleButton toggleGPIO6;
    @FXML
    private ToggleButton toggleGPIO7;
    
            
    private ToggleButton[] togglebtn;
    
    public double[][] delayT={{0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    
    public static final double[][] default_data={{6,4,3,3},
        {6,4,3,3},
        {6,4,3,3},
        {6,4,3,3},
        {6,4,3,3},
        {6,4,3,3},
        {6,4,3,3},
        {6,4,3,3}};

    @FXML
    private Button btnSetAllOn;
    @FXML
    private Button btnSetAllOff;
    
    private final ToggleGroup group1 =new ToggleGroup();
    private final ToggleGroup group2 =new ToggleGroup();
    private final ToggleGroup group3 =new ToggleGroup();
    private final ToggleGroup group4 =new ToggleGroup();
    private final ToggleGroup group5 =new ToggleGroup();
    private final ToggleGroup group6 =new ToggleGroup();
    private final ToggleGroup group7 =new ToggleGroup();
    private final ToggleGroup group8 =new ToggleGroup();
    
    private ToggleGroup[] group;
    private GpioAdapterFX gpioadapterFX;
    
    private int year, month, day;
    private int hour, minute, second;
    
    private int NumberOfGate=16;
    private int NumberOfClosing=0;
        
    private Led indicatorGPIO0;
    private Led indicatorGPIO1;
    private Led indicatorGPIO2;
    private Led indicatorGPIO3;
    private Led indicatorGPIO4;
    private Led indicatorGPIO5;
    private Led indicatorGPIO6;
    private Led indicatorGPIO7;
    
    private Led ftindicatorGPIO0;
    private Led ftindicatorGPIO1;
    private Led ftindicatorGPIO2;
    private Led ftindicatorGPIO3;
    private Led ftindicatorGPIO4;
    private Led ftindicatorGPIO5;
    private Led ftindicatorGPIO6;
    private Led ftindicatorGPIO7;
    private Led ftindicatorGPIO8;
    private Led ftindicatorGPIO9;
    private Led ftindicatorGPIO10;
    private Led ftindicatorGPIO11;
    private Led ftindicatorGPIO12;
    private Led ftindicatorGPIO13;
    private Led ftindicatorGPIO14;
    private Led ftindicatorGPIO15;
    private Led ftindicatorGPIO16;
    private Led ftindicatorGPIO17;
    private Led ftindicatorGPIO18;
    private Led ftindicatorGPIO19;
    private Led ftindicatorGPIO20;
    private Led ftindicatorGPIO21;
    private Led ftindicatorGPIO22;
    private Led ftindicatorGPIO23;
    
    @Override 
    public void initialize(URL url, ResourceBundle rb){
                
        // create 2d array for "textfield"
        textfield = new TextField[][]{{txtgate1T1, txtgate1T2, txtgate1T3, txtgate1T4},
            {txtgate2T1, txtgate2T2, txtgate2T3, txtgate2T4},
            {txtgate3T1, txtgate3T2, txtgate3T3, txtgate3T4},
            {txtgate4T1, txtgate4T2, txtgate4T3, txtgate4T4},
            {txtgate5T1, txtgate5T2, txtgate5T3, txtgate5T4},
            {txtgate6T1, txtgate6T2, txtgate6T3, txtgate6T4},
            {txtgate7T1, txtgate7T2, txtgate7T3, txtgate7T4},
            {txtgate8T1, txtgate8T2, txtgate8T3, txtgate8T4},
            {txtgate9T1, txtgate9T2, txtgate9T3, txtgate9T4},
            {txtgate10T1, txtgate10T2, txtgate10T3, txtgate10T4},
            {txtgate11T1, txtgate11T2, txtgate11T3, txtgate11T4},
            {txtgate12T1, txtgate12T2, txtgate12T3, txtgate12T4},
            {txtgate13T1, txtgate13T2, txtgate13T3, txtgate13T4},
            {txtgate14T1, txtgate14T2, txtgate14T3, txtgate14T4},
            {txtgate15T1, txtgate15T2, txtgate15T3, txtgate15T4},
            {txtgate16T1, txtgate16T2, txtgate16T3, txtgate16T4},
            {txtgate17T1, txtgate17T2, txtgate17T3, txtgate17T4},
            {txtgate18T1, txtgate18T2, txtgate18T3, txtgate18T4},
            {txtgate19T1, txtgate19T2, txtgate19T3, txtgate19T4},
            {txtgate20T1, txtgate20T2, txtgate20T3, txtgate20T4},
            {txtgate21T1, txtgate21T2, txtgate21T3, txtgate21T4},
            {txtgate22T1, txtgate22T2, txtgate22T3, txtgate22T4},
            {txtgate23T1, txtgate23T2, txtgate23T3, txtgate23T4},
            {txtgate24T1, txtgate24T2, txtgate24T3, txtgate24T4}
        };
        // using virtual numeric keypad for textfields
        for(int i=0; i<24; i++){
            for(int j=0; j<4; j++){
                textfield[i][j].getProperties().put("vkType", "numeric");
            }
        }
                
        // Set background color for buttons Power Off and Restart
        btnPowerOff.setStyle("-fx-font: bold 13pt \"Arial\";"
                + "-fx-background-color: #ff0000; "
                + "-fx-background-radius:15; "
                + "-fx-border-radius: 15; "
                + "-fx-padding: 6 2 6 2"); // red-colored button
        btnRestart.setStyle("-fx-font: bold 13pt \"Arial\";"
                + "-fx-background-color: #f0ff00;"
                + "-fx-background-radius:15;"
                + "-fx-border-radius: 15;"
                + "-fx-padding: 6 2 6 2");// yellow-colored button
        btnSetAllOn.setStyle("-fx-font: bold 13pt \"Arial\";"
                + "-fx-text-fill:white;"
                + "-fx-background-color: #0b9619; "
                + "-fx-background-radius: 40;"
                + "-fx-border-radius:40;"
                + "-fx-padding: 6 2 6 2");
        btnSetAllOff.setStyle("-fx-font: bold 13pt \"Arial\";"
                + "-fx-text-fill: white; "
                + "-fx-background-color: #0b9619; "
                + "-fx-background-radius: 40;"
                + "-fx-border-radius: 40;"
                + "-fx-padding: 6 2 6 2");
        btnTest.setStyle("-fx-font: bold 13pt \"Arial\";"
                + "-fx-text-fill: white;"
                + "-fx-background-color: #0b9619; "
                + "-fx-background-radius: 40;"
                + "-fx-border-radius: 40;"
                + "-fx-padding: 6 2 6 2");
        
                
        // initializing array "togglebtn"
        togglebtn = new ToggleButton[]{tgglegate1,tgglegate2,tgglegate3,tgglegate4,
            tgglegate5,tgglegate6,tgglegate7,tgglegate8,
            tgglegate9,tgglegate10,tgglegate11,tgglegate12,
            tgglegate13,tgglegate14,tgglegate15,tgglegate16,
            tgglegate17,tgglegate18,tgglegate19,tgglegate20,
            tgglegate21,tgglegate22,tgglegate23,tgglegate24
        };
        
        // initializing array "group"
        //group = new ToggleGroup[]{group1, group2, group3, group4,
        //group5, group6, group7, group8};
        
        // create object gpioadapterFX
        gpioadapterFX = new GpioAdapterFX();
        
        // initialize radio buttons "Sequence Type", set radio button for group1
        rbT12.setToggleGroup(rbgroup1);
        rbT12.setSelected(false);
        
        rbT14.setToggleGroup(rbgroup1);
        rbT14.setSelected(true);
        menuItemActive();                // status of text fields corresponding to the Sequence Type
        
        // adding actions to the clicked radio button
        rbT12.setOnAction(event->{
            menuItemdeActive();
            lblcycletype.setText("Single Mode");
        });
        rbT14.setOnAction(event->{
            menuItemActive();
            lblcycletype.setText("Full Mode");
        });
        
        
                
        // initialize radio buttons "Inj. Signal", set radio button for group2
        rbContact.setToggleGroup(rbgroup2);
        rbContact.setSelected(true);
        
        rb24V.setToggleGroup(rbgroup2);
        rb24V.setSelected(false);
        
        // adding actions to the selected radio button
        rbContact.setOnAction(event->{
            lblSignalType.setText("Contacting"); // update the value on the Graph tab
        });
        
        rb24V.setOnAction(event->{
            lblSignalType.setText("24V");
        });
        
        
        // initializing toggle button for each gate
        // Set G1 - G16 are TRUE and G17 - G24 are FALSE at initializing
        for(int i=0; i<24; i++){
            if(i<16){
                togglebtn[i].setSelected(true);
            }else{
                togglebtn[i].setSelected(false);
                for(int j=0; j<4; j++){
                    textfield[i][j].opacityProperty().setValue(0.3);
                    textfield[i][j].setText("0");
                }
            }
        }
               
        // Set property for toggle button tgglegate1
        for(int i=0; i<24; i++){
            final int k=i;
            togglebtn[k].setOnAction((ActionEvent event)->{
                if(togglebtn[k].isSelected()){
                    if(rbT12.isSelected()){
                        for(int j=0; j<2; j++){
                           textfield[k][j].opacityProperty().setValue(1);
                        }
                    }else {
                        for(int j=0; j<4; j++){
                            textfield[k][j].opacityProperty().setValue(1);
                        }
                    }
                    NumberOfGate +=1; // increase the number of activated gates
                    lblActiveGate.setText(String.valueOf(NumberOfGate));// update the value on the screen
                }else{
                    for (int j=0; j<4; j++){
                        textfield[k][j].opacityProperty().setValue(0.3); // the corresponding textfields are blurred
                        textfield[k][j].setText("0");                    // set the values of textfields are 0
                    }
                    NumberOfGate -=1; // decrease the number of activated gates
                    lblActiveGate.setText(String.valueOf(NumberOfGate)); // update the value on the screen
                }
            });
        }
        // Set Default item for ListView
        //dataList.
        SessionList.setItems(dataList);
        
        // Display time
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {            
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH)+1;
        day = cal.get(Calendar.DATE);
        second = cal.get(Calendar.SECOND);
        minute = cal.get(Calendar.MINUTE);
        hour = cal.get(Calendar.HOUR);
        //System.out.println(hour + ":" + (minute) + ":" + second);
        lbltime.setText(year+"/"+month+"/"+day+","+hour + ":" + (minute) + ":" + second);
        }),
         new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        
        // Initializing color for shape
        //shape01.setFill(Color.DARKBLUE);           // is coding here
        
        
        // Initializing and displaying the labels
        lblcycletype.setText("Full Mode");
        lblgpiostatus.setText("OFF");
        lblcount.setText(String.valueOf(NumberOfClosing));
        lblActiveGate.setText(String.valueOf(NumberOfGate));
        lblSignalType.setText("Contacting");
        
                
        indicatorGPIO0 = createIndicator();
        indicatorGPIO1 = createIndicator();
        indicatorGPIO2 = createIndicator();
        indicatorGPIO3 = createIndicator();
        indicatorGPIO4 = createIndicator();
        indicatorGPIO5 = createIndicator();
        indicatorGPIO6 = createIndicator();
        indicatorGPIO7 = createIndicator();
        
        ftindicatorGPIO0 = createIndicator();
        ftindicatorGPIO1 = createIndicator();
        ftindicatorGPIO2 = createIndicator();
        ftindicatorGPIO3 = createIndicator();
        ftindicatorGPIO4 = createIndicator();
        ftindicatorGPIO5 = createIndicator();
        ftindicatorGPIO6 = createIndicator();
        ftindicatorGPIO7 = createIndicator();
        ftindicatorGPIO8 = createIndicator();
        ftindicatorGPIO9 = createIndicator();
        ftindicatorGPIO10 = createIndicator();
        ftindicatorGPIO11 = createIndicator();
        ftindicatorGPIO12 = createIndicator();
        ftindicatorGPIO13 = createIndicator();
        ftindicatorGPIO14 = createIndicator();
        ftindicatorGPIO15 = createIndicator();
        ftindicatorGPIO16 = createIndicator();
        ftindicatorGPIO17 = createIndicator();
        ftindicatorGPIO18 = createIndicator();
        ftindicatorGPIO19 = createIndicator();
        ftindicatorGPIO20 = createIndicator();
        ftindicatorGPIO21 = createIndicator();
        ftindicatorGPIO22 = createIndicator();
        ftindicatorGPIO23 = createIndicator();
        
        btnGridpane.add(indicatorGPIO0, 0, 0);
        btnGridpane.add(indicatorGPIO1, 1, 0);
        btnGridpane.add(indicatorGPIO2, 2, 0);
        btnGridpane.add(indicatorGPIO3, 3, 0);
        btnGridpane.add(indicatorGPIO4, 4, 0);
        btnGridpane.add(indicatorGPIO5, 5, 0);
        btnGridpane.add(indicatorGPIO6, 6, 0);
        btnGridpane.add(indicatorGPIO7, 7, 0);
        
        // adding LEDs to Set 1
        ftGridpane.add(ftindicatorGPIO0, 2, 1);
        ftGridpane.add(ftindicatorGPIO1, 4, 1);
        ftGridpane.add(ftindicatorGPIO2, 6, 1);
        ftGridpane.add(ftindicatorGPIO3, 8, 1);
        ftGridpane.add(ftindicatorGPIO4, 2, 3);
        ftGridpane.add(ftindicatorGPIO5, 4, 3);
        ftGridpane.add(ftindicatorGPIO6, 6, 3);
        ftGridpane.add(ftindicatorGPIO7, 8, 3);
        
        // adding LEDs to Set 2
        ftGridpane2.add(ftindicatorGPIO8, 2, 1);
        ftGridpane2.add(ftindicatorGPIO9, 4, 1);
        ftGridpane2.add(ftindicatorGPIO10, 6, 1);
        ftGridpane2.add(ftindicatorGPIO11, 8, 1);
        ftGridpane2.add(ftindicatorGPIO12, 2, 3);
        ftGridpane2.add(ftindicatorGPIO13, 4, 3);
        ftGridpane2.add(ftindicatorGPIO14, 6, 3);
        ftGridpane2.add(ftindicatorGPIO15, 8, 3);
        
        // adding LEDs to Set 3
        ftGridpane3.add(ftindicatorGPIO16, 2, 1);
        ftGridpane3.add(ftindicatorGPIO17, 4, 1);
        ftGridpane3.add(ftindicatorGPIO18, 6, 1);
        ftGridpane3.add(ftindicatorGPIO19, 8, 1);
        ftGridpane3.add(ftindicatorGPIO20, 2, 3);
        ftGridpane3.add(ftindicatorGPIO21, 4, 3);
        ftGridpane3.add(ftindicatorGPIO22, 6, 3);
        ftGridpane3.add(ftindicatorGPIO23, 8, 3);
        
        //indicatorGPIO0.onProperty().bindBidirectional(null);
                
        indicatorGPIO0.onProperty().
            bindBidirectional(gpioadapterFX.gpio0StateProperty());
        ftindicatorGPIO0.onProperty().
                bindBidirectional(gpioadapterFX.gpio0StateProperty());
        
        indicatorGPIO1.onProperty().
            bindBidirectional(gpioadapterFX.gpio1StateProperty());
        ftindicatorGPIO1.onProperty().
                bindBidirectional(gpioadapterFX.gpio1StateProperty());
        
        indicatorGPIO2.onProperty().
            bindBidirectional(gpioadapterFX.gpio2StateProperty());
        ftindicatorGPIO2.onProperty().
                bindBidirectional(gpioadapterFX.gpio2StateProperty());
        
        indicatorGPIO3.onProperty().
            bindBidirectional(gpioadapterFX.gpio3StateProperty());
        ftindicatorGPIO3.onProperty().
                bindBidirectional(gpioadapterFX.gpio3StateProperty());
        
        indicatorGPIO4.onProperty().
            bindBidirectional(gpioadapterFX.gpio4StateProperty());
        ftindicatorGPIO4.onProperty().
                bindBidirectional(gpioadapterFX.gpio4StateProperty());
        
        indicatorGPIO5.onProperty().
            bindBidirectional(gpioadapterFX.gpio5StateProperty());
        ftindicatorGPIO5.onProperty().
                bindBidirectional(gpioadapterFX.gpio5StateProperty());
        
        indicatorGPIO6.onProperty().
            bindBidirectional(gpioadapterFX.gpio6StateProperty());
        ftindicatorGPIO6.onProperty().
                bindBidirectional(gpioadapterFX.gpio6StateProperty());
        
        indicatorGPIO7.onProperty().
            bindBidirectional(gpioadapterFX.gpio7StateProperty());
        ftindicatorGPIO7.onProperty().
                bindBidirectional(gpioadapterFX.gpio7StateProperty());
        
        ftindicatorGPIO8.onProperty().
                bindBidirectional(gpioadapterFX.gpio8StateProperty());
        ftindicatorGPIO9.onProperty().
                bindBidirectional(gpioadapterFX.gpio9StateProperty());
        ftindicatorGPIO10.onProperty().
                bindBidirectional(gpioadapterFX.gpio10StateProperty());
        ftindicatorGPIO11.onProperty().
                bindBidirectional(gpioadapterFX.gpio11StateProperty());
        ftindicatorGPIO12.onProperty().
                bindBidirectional(gpioadapterFX.gpio12StateProperty());
        ftindicatorGPIO13.onProperty().
                bindBidirectional(gpioadapterFX.gpio13StateProperty());
        ftindicatorGPIO14.onProperty().
                bindBidirectional(gpioadapterFX.gpio14StateProperty());
        ftindicatorGPIO15.onProperty().
                bindBidirectional(gpioadapterFX.gpio15StateProperty());
        
        ftindicatorGPIO16.onProperty().
                bindBidirectional(gpioadapterFX.gpio16StateProperty());
        ftindicatorGPIO17.onProperty().
                bindBidirectional(gpioadapterFX.gpio17StateProperty());
        ftindicatorGPIO18.onProperty().
                bindBidirectional(gpioadapterFX.gpio18StateProperty());
        ftindicatorGPIO19.onProperty().
                bindBidirectional(gpioadapterFX.gpio19StateProperty());
        ftindicatorGPIO20.onProperty().
                bindBidirectional(gpioadapterFX.gpio20StateProperty());
        ftindicatorGPIO21.onProperty().
                bindBidirectional(gpioadapterFX.gpio21StateProperty());
        ftindicatorGPIO22.onProperty().
                bindBidirectional(gpioadapterFX.gpio22StateProperty());
        ftindicatorGPIO23.onProperty().
                bindBidirectional(gpioadapterFX.gpio23StateProperty());
        
        toggleGPIO0.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio0StateProperty());
        toggleGPIO1.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio1StateProperty());
        toggleGPIO2.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio2StateProperty());
        toggleGPIO3.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio3StateProperty());
        toggleGPIO4.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio4StateProperty());
        toggleGPIO5.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio5StateProperty());
        toggleGPIO6.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio6StateProperty());
        toggleGPIO7.selectedProperty().
                bindBidirectional(gpioadapterFX.gpio7StateProperty());
        
    }
    
    private Led createIndicator() {
        return LedBuilder.create().
            prefHeight(40.0).
            prefWidth(40.0).
            build();
    }
    
    private void menuItemActive(){
        for(int i=0; i<24; i++){
            for(int j=2; j<4; j++){
                textfield[i][j].editableProperty().setValue(Boolean.TRUE);
                textfield[i][j].opacityProperty().setValue(1.0);
            }
        }        
    }
    
    private void menuItemdeActive(){    
        for(int i=0; i<24; i++){
            for(int j=2; j<4; j++){
                textfield[i][j].editableProperty().setValue(Boolean.FALSE);
                textfield[i][j].opacityProperty().setValue(0.3);
                textfield[i][j].setText("0");
            }
        }        
    }
    
    private void readTextfield(){
        for(int i=0; i<8 ; i++){
            for(int j=0; j<4; j++){
                delayT[i][j] = Double.parseDouble(textfield[i][j].getText());
            }
        }
    }
    
    @FXML
    void SetOnAction(ActionEvent event) {
        gpioadapterFX.setOnAllPins();
    }

    
    @FXML
    void SetOffAction(ActionEvent event) {
        gpioadapterFX.setOffAllPins();
    }
         
    @FXML
    void StartAction(ActionEvent event) {
                        
        gpioadapterFX.connect();
        
        //BooleanProperty pinState = gpioadapterFX.inputState();
        lblgpiostatus.setText("ON");
        
        gpioadapterFX.inputState().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue==true){
                
                readTextfield();
                
            }else{
                
                NumberOfClosing +=1;
                lblcount.setText(String.valueOf(NumberOfClosing));
                
                if(rbT12.isSelected()){
                    gpioadapterFX.gate1Action(delayT[0][0], delayT[0][1], 0, 0);
                    gpioadapterFX.gate2Action(delayT[1][0], delayT[1][1], 0, 0);
                    gpioadapterFX.gate3Action(delayT[2][0], delayT[2][1], 0, 0);
                    gpioadapterFX.gate4Action(delayT[3][0], delayT[3][1], 0, 0);
                    gpioadapterFX.gate5Action(delayT[4][0], delayT[4][1], 0, 0);
                    gpioadapterFX.gate6Action(delayT[5][0], delayT[5][1], 0, 0);
                    gpioadapterFX.gate7Action(delayT[6][0], delayT[6][1], 0, 0);
                    gpioadapterFX.gate8Action(delayT[7][0], delayT[7][1], 0, 0);
                }else{
                    gpioadapterFX.gate1Action(delayT[0][0], delayT[0][1], delayT[0][2], delayT[0][3]);
                    gpioadapterFX.gate2Action(delayT[1][0], delayT[1][1], delayT[1][2], delayT[1][3]);
                    gpioadapterFX.gate3Action(delayT[2][0], delayT[2][1], delayT[2][2], delayT[2][3]);
                    gpioadapterFX.gate4Action(delayT[3][0], delayT[3][1], delayT[3][2], delayT[3][3]);
                    gpioadapterFX.gate5Action(delayT[4][0], delayT[4][1], delayT[4][2], delayT[4][3]);
                    gpioadapterFX.gate6Action(delayT[5][0], delayT[5][1], delayT[5][2], delayT[5][3]);
                    gpioadapterFX.gate7Action(delayT[6][0], delayT[6][1], delayT[6][2], delayT[6][3]);
                    gpioadapterFX.gate8Action(delayT[7][0], delayT[7][1], delayT[7][2], delayT[7][3]);
                }
                
            }
        });
        
    }

    @FXML
    void StopAction(ActionEvent event) {
        gpioadapterFX.disconnect();
        lblgpiostatus.setText("OFF");
        NumberOfClosing = 0;
        lblcount.setText(String.valueOf(NumberOfClosing));
    }
    
    @FXML
    void SetTestAction(ActionEvent event){
        double[] T1={6,6,6,6,6,6,6,6};
        double[] T2={4,4,4,4,4,4,4,4};
        double[] T3={3,3,3,3,3,3,3,3};
        double[] T4={3,3,3,3,3,3,3,3};
        /*
        //readTextfield();
        for (int i=0; i<8; i++){
            T1[i]=delayT[i][0];
            T2[i]=delayT[i][1];
            T3[i]=delayT[i][2];
            T4[i]=delayT[i][3];
        }*/
        gpioadapterFX.CycleTest(T1, T2, T3, T4);
    }
    
    @FXML
    void PowerOffAction(ActionEvent event){
        //final Stage primarystage = (Stage) btnTest.getScene().getWindow();
        //primarystage.close();
        Platform.exit();
    }
    
    @FXML
    void RestartAction(ActionEvent event){
        Stage primarystage = (Stage) btnPowerOff.getScene().getWindow();
        primarystage.close();
        Platform.runLater(()-> {
            try {
                new Valvegate().start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(ValvegateController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    @FXML
    void LoadAction(ActionEvent event) {
        final int selectedIndex = SessionList.getSelectionModel().getSelectedIndex();
        if(selectedIndex==0){
            for(int i=0;i<8;i++){
                for(int j=0;j<4;j++){
                    textfield[i][j].setText(String.valueOf(default_data[i][j]));
                }
            }
        }
        readTextfield();
    }

    @FXML
    void SaveListAction(ActionEvent event) {
        if(txtSession!=null){
            dataList.add(txtSession.getText());
            SessionList.setItems(dataList);
            txtSession.setText("");
        }
    }

    @FXML
    void DeleteAction(ActionEvent event) {
        final int selectedIdx = SessionList.getSelectionModel().getSelectedIndex();
        if (selectedIdx!=-1){
            SessionList.getItems().remove(selectedIdx);
        }
    }
}
