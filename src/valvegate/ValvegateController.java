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
    
    private int NumberOfGate=8;
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
            {txtgate8T1, txtgate8T2, txtgate8T3, txtgate8T4}
        };
        // using virtual numeric keypad for textfields
        txtgate1T1.getProperties().put("vkType", "numeric");
        txtgate1T2.getProperties().put("vkType", "numeric");
        txtgate1T3.getProperties().put("vkType", "numeric");
        txtgate1T4.getProperties().put("vkType", "numeric");
        txtgate2T1.getProperties().put("vkType", "numeric");
        txtgate2T2.getProperties().put("vkType", "numeric");
        txtgate2T3.getProperties().put("vkType", "numeric");
        txtgate2T4.getProperties().put("vkType", "numeric");
        txtgate3T1.getProperties().put("vkType", "numeric");
        txtgate3T2.getProperties().put("vkType", "numeric");
        txtgate3T3.getProperties().put("vkType", "numeric");
        txtgate3T4.getProperties().put("vkType", "numeric");
        txtgate4T1.getProperties().put("vkType", "numeric");
        txtgate4T2.getProperties().put("vkType", "numeric");
        txtgate4T3.getProperties().put("vkType", "numeric");
        txtgate4T4.getProperties().put("vkType", "numeric");
        txtgate5T1.getProperties().put("vkType", "numeric");
        txtgate5T2.getProperties().put("vkType", "numeric");
        txtgate5T3.getProperties().put("vkType", "numeric");
        txtgate5T4.getProperties().put("vkType", "numeric");
        txtgate6T1.getProperties().put("vkType", "numeric");
        txtgate6T2.getProperties().put("vkType", "numeric");
        txtgate6T3.getProperties().put("vkType", "numeric");
        txtgate6T4.getProperties().put("vkType", "numeric");
        txtgate7T1.getProperties().put("vkType", "numeric");
        txtgate7T2.getProperties().put("vkType", "numeric");
        txtgate7T3.getProperties().put("vkType", "numeric");
        txtgate7T4.getProperties().put("vkType", "numeric");
        txtgate8T1.getProperties().put("vkType", "numeric");
        txtgate8T2.getProperties().put("vkType", "numeric");
        txtgate8T3.getProperties().put("vkType", "numeric");
        txtgate8T4.getProperties().put("vkType", "numeric");
        
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
        togglebtn = new ToggleButton[]{tgglegate1,
            tgglegate2,
            tgglegate3,
            tgglegate4,
            tgglegate5,
            tgglegate6,
            tgglegate7,
            tgglegate8
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
        for(int i=0; i<togglebtn.length; i++){
            togglebtn[i].setSelected(true);
        }
        
        for(int i=0; i<8; i++){
            final int k=i;
            togglebtn[i].setOnAction((ActionEvent event)->{
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
        /*
        // Set property for toggle button tgglegate1              
        for(int i=0; i<8; i++){
            final int k=i;
            group[k].selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldValue, Toggle newValue) -> {
                if (newValue == null){//IF the toggle 1 is deactivated
                    for (int j=0; j<4; j++){
                        textfield[k][j].opacityProperty().setValue(0.3); // the corresponding textfields are blurred
                        textfield[k][j].setText("0");                    // set the values of textfields are 0
                    }
                    NumberOfGate -=1; // decrease the number of activated gates
                    lblActiveGate.setText(String.valueOf(NumberOfGate)); // update the value on the screen
                }
                else{// IF the toggle 1 is activated again
                    if ("T1-T2".equals(menubtnSequence.getText())){
                        for(int j=0; j<2; j++){
                            textfield[k][j].opacityProperty().setValue(1);
                        }
                    }
                    else{
                        for(int j=0; j<4; j++){
                            textfield[k][j].opacityProperty().setValue(1);
                        }                        
                    }
                    NumberOfGate +=1; // increase the number of activated gates
                    lblActiveGate.setText(String.valueOf(NumberOfGate));// update the value on the screen
                }
            });
        }*/
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
        
        btnGridpane.add(indicatorGPIO0, 0, 0);
        btnGridpane.add(indicatorGPIO1, 1, 0);
        btnGridpane.add(indicatorGPIO2, 2, 0);
        btnGridpane.add(indicatorGPIO3, 3, 0);
        btnGridpane.add(indicatorGPIO4, 4, 0);
        btnGridpane.add(indicatorGPIO5, 5, 0);
        btnGridpane.add(indicatorGPIO6, 6, 0);
        btnGridpane.add(indicatorGPIO7, 7, 0);
        
        ftGridpane.add(ftindicatorGPIO0, 2, 1);
        ftGridpane.add(ftindicatorGPIO1, 4, 1);
        ftGridpane.add(ftindicatorGPIO2, 6, 1);
        ftGridpane.add(ftindicatorGPIO3, 8, 1);
        ftGridpane.add(ftindicatorGPIO4, 2, 3);
        ftGridpane.add(ftindicatorGPIO5, 4, 3);
        ftGridpane.add(ftindicatorGPIO6, 6, 3);
        ftGridpane.add(ftindicatorGPIO7, 8, 3);
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
        for(int i=0; i<8; i++){
            for(int j=2; j<4; j++){
                textfield[i][j].editableProperty().setValue(Boolean.TRUE);
                textfield[i][j].opacityProperty().setValue(1.0);
            }
        }        
    }
    
    private void menuItemdeActive(){    
        for(int i=0; i<8; i++){
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
