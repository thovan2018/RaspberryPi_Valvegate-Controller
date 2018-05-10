
package valvegate;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.util.Duration;


public class GpioAdapterFX {
    
    private GpioController GPIO;
    
    private ObservableMap<BooleanProperty, ChangeListener<Boolean>> pins;
    
    private BooleanProperty pin0StateProperty;
    private BooleanProperty pin1StateProperty;
    private BooleanProperty pin2StateProperty;
    private BooleanProperty pin3StateProperty;
    private BooleanProperty pin4StateProperty;
    private BooleanProperty pin5StateProperty;
    private BooleanProperty pin6StateProperty;
    private BooleanProperty pin7StateProperty;
    
    private BooleanProperty pin8StateProperty;      //modified
    private BooleanProperty pin9StateProperty;
    private BooleanProperty pin10StateProperty;
    private BooleanProperty pin11StateProperty;
    private BooleanProperty pin12StateProperty;
    private BooleanProperty pin13StateProperty;
    private BooleanProperty pin14StateProperty;
    private BooleanProperty pin15StateProperty;
    
    private BooleanProperty pin16StateProperty;
    private BooleanProperty pin17StateProperty;
    private BooleanProperty pin18StateProperty;
    private BooleanProperty pin19StateProperty;
    private BooleanProperty pin20StateProperty;
    private BooleanProperty pin21StateProperty;
    private BooleanProperty pin22StateProperty;
    private BooleanProperty pin23StateProperty;
    
    //modified
    private GpioPinDigitalOutput pin0, pin1, pin2, pin3, pin4, pin5, pin6, pin7, 
            pin8, pin9, pin10, pin11, pin12, pin13, pin14, pin15,
            pin16, pin17, pin18, pin19, pin20, pin21, pin22, pin23;
    
    private GpioPinDigitalOutput[] pinIndex;  //modified
    private BooleanProperty pin27StateProperty;
    
    private Timeline testTimeline, testTimeline1, testTimeline2, testTimeline3, testTimeline4, 
            testTimeline5, testTimeline6, testTimeline7, testTimeline8;
    private Timeline[] timeline;
    //private BooleanProperty connectedProperty;
    private BooleanProperty[] stateProperties;
    //private ObjectProperty<PinMode>[] modeProperties;
    
    //private GpioPinDigitalMultipurpose[] pins;
    
    
    public GpioAdapterFX() {
        init();
    }
    
    private void init() {
        
        //connectedProperty = new SimpleBooleanProperty(Boolean.FALSE);
        
        pin0StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin1StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin2StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin3StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin4StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin5StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin6StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin7StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        
        pin8StateProperty = new SimpleBooleanProperty(Boolean.FALSE);   //modified
        pin9StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin10StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin11StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin12StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin13StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin14StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin15StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        
        pin16StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin17StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin18StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin19StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin20StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin21StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin22StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        pin23StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
        
        pin27StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
                
        stateProperties = new BooleanProperty[]{pin0StateProperty,            //modifed
            pin1StateProperty, pin2StateProperty, pin3StateProperty,
            pin4StateProperty, pin5StateProperty, pin6StateProperty,
            pin7StateProperty, pin8StateProperty, pin9StateProperty,
            pin10StateProperty, pin11StateProperty, pin12StateProperty,
            pin13StateProperty, pin14StateProperty, pin15StateProperty,
            pin16StateProperty, pin17StateProperty, pin18StateProperty,
            pin19StateProperty, pin20StateProperty, pin21StateProperty,
            pin22StateProperty, pin23StateProperty
        };
        
        pinIndex = new GpioPinDigitalOutput[]{pin0, pin1, pin2, pin3, pin4,   //modified
            pin5, pin6, pin7, pin8, pin9,
            pin10, pin11, pin12, pin13, pin14,
            pin15, pin16, pin17, pin18, pin19, 
            pin20, pin21, pin22, pin23
        };
        
        timeline = new Timeline[]{testTimeline1,
        testTimeline2,
        testTimeline3,
        testTimeline4,
        testTimeline5,
        testTimeline6,
        testTimeline7,
        testTimeline8};
         
        pins = FXCollections.observableHashMap();
        
        for (BooleanProperty statePropertie : stateProperties) {
            pins.put(statePropertie, null);
        }
        //pins.put(pin27StateProperty, null);
        
    }
    
    
    private void addGpioInputListener(final GpioPinDigitalInput pin, final BooleanProperty gpioStateProperty) {
        pin.addListener((GpioPinListenerDigital) (final GpioPinDigitalStateChangeEvent event) -> {
            //LOGGER.log(Level.INFO, "pinstateChanged: {0} {1}", new Object[]{pin.getName(), event.getState()});
            Platform.runLater(() -> {
                gpioStateProperty.set(event.getState().isHigh()); // if choose "isLow", it will be actived at down edge
                                                       // if choose "isHigh", the interrupt will be actived at rise edge
            });
        });
    }
    
    private ChangeListener<Boolean> createPinListener(final GpioPinDigitalOutput pin) {
        return (ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) -> {
            if(pin.getMode()!=PinMode.DIGITAL_INPUT){
                if (newValue) {
                    pin.high();
                } else {
                    pin.low();
                }
            }
        };
    }
    /*
    private void addGpioInputListener(final GpioPinDigitalInput pin, final BooleanProperty gpioStateProperty) {
        pin.addListener((GpioPinListenerDigital) (final GpioPinDigitalStateChangeEvent event) -> {
            LOGGER.log(Level.INFO, "pinstateChanged: {0} {1}", new Object[]{pin.getName(), event.getState()});
            Platform.runLater(() -> {
                gpioStateProperty.set(event.getState().
                        isHigh());
            });
        });
    }*/
            
    /*
    * -------------------------- ACTIONS -------------------------- 
    */
    public void connect() {
        //LOGGER.log(Level.INFO, "connect...");
 
        // create GPIO controller
        GPIO = GpioFactory.getInstance();
                
        // provision pin#0 - pin#23 as output pins with their pin states LOW
        pin0 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_00, "PIN0", PinState.LOW);
        pin1 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PIN1", PinState.LOW);
        pin2 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_02, "PIN2", PinState.LOW);
        pin3 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_03, "PIN3", PinState.LOW);
        pin4 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_04, "PIN4", PinState.LOW);
        pin5 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_05, "PIN5", PinState.LOW);
        pin6 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_06, "PIN6", PinState.LOW);
        pin7 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PIN7", PinState.LOW);
        
        pin8 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_08, "PIN8", PinState.LOW);      //modified
        pin9 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_09, "PIN9", PinState.LOW);
        pin10 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_10, "PIN10", PinState.LOW);
        pin11 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_11, "PIN11", PinState.LOW);
        pin12 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_12, "PIN12", PinState.LOW);
        pin13 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_13, "PIN13", PinState.LOW);
        pin14 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_14, "PIN14", PinState.LOW);
        pin15 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_15, "PIN15", PinState.LOW);
        
        pin16 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_16, "PIN16", PinState.LOW);
        pin17 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_17, "PIN17", PinState.LOW);
        pin18 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_18, "PIN18", PinState.LOW);
        pin19 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_19, "PIN19", PinState.LOW);
        pin20 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_20, "PIN20", PinState.LOW);
        pin21 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_21, "PIN21", PinState.LOW);
        pin22 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_22, "PIN22", PinState.LOW);
        pin23 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_23, "PIN23", PinState.LOW);
        
        // provision "pin#27" as an input pin with its internal PULLDOWN resistor enabled
        final GpioPinDigitalInput myContact = GPIO.provisionDigitalInputPin(RaspiPin.GPIO_27, "myContact", PinPullResistance.PULL_UP);
        
        // set shutdown state for this input pin
        myContact.setShutdownOptions(Boolean.TRUE);
        
        //addGpioInputListener(myContact, pin27StateProperty);
        /*
        myContact.addListener(new GpioPinListener(){
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
                if(event.getState()==PinState.HIGH){
                    pin27StateProperty.setValue(Boolean.TRUE);
                }else{
                    pin27StateProperty.setValue(Boolean.FALSE);
                }
            }
        });*/
        
        addGpioInputListener(myContact, pin27StateProperty);
 
        // create Listener for DigitalOuputPin
        for(int i=0; i<24; i++){                                                //modified                                                     
            pins.put(stateProperties[i], createPinListener(pinIndex[i]));
        }
        
               
        
        for (BooleanProperty statePropertie : stateProperties) {
            statePropertie.addListener(pins.get(statePropertie));
        }
        
        /*
        pin0StateProperty.addListener(pins.get(pin0StateProperty));
        pin1StateProperty.addListener(pins.get(pin1StateProperty));
        pin2StateProperty.addListener(pins.get(pin2StateProperty));
        pin3StateProperty.addListener(pins.get(pin3StateProperty));
        pin4StateProperty.addListener(pins.get(pin4StateProperty));
        pin5StateProperty.addListener(pins.get(pin5StateProperty));
        pin6StateProperty.addListener(pins.get(pin6StateProperty));
        pin7StateProperty.addListener(pins.get(pin7StateProperty));*/
 
        reset();
        //LOGGER.log(Level.INFO, "connected.");

    }
    
    public void disconnect() {
        //LOGGER.log(Level.INFO, "disconnect()");
        if (GPIO != null) {
            GPIO.shutdown();
        }
        /*
        pins.keySet().stream().forEach((booleanProperty) -> {
            ChangeListener<Boolean> listener = pins.get(booleanProperty);
            if (listener != null) {
                booleanProperty.removeListener(listener);
            }
        });*/
    }
    
    public BooleanProperty inputState(){
        return pin27StateProperty;
    }
    
    
    public void setOnAllPins() {
        for (int i = 0; i < 24; i++) {
            stateProperties[i].setValue(Boolean.TRUE);
        }
    }
    
    public void setOffAllPins(){
        for (int i = 0; i < 24; i++) {
            stateProperties[i].setValue(Boolean.FALSE);
        }
    }
    
    public void reset() {
        if (testTimeline != null) {
            testTimeline.stop();
        }
        setOffAllPins();
    }
    
    public void connectTest() {
        if (testTimeline != null) {
            testTimeline.stop();
        }
        reset();

        testTimeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            setOnAllPins();
        }), new KeyFrame(Duration.seconds(2), (ActionEvent event) -> {
            setOffAllPins();
        }));

        testTimeline.play();
    }
    
    public void test(double millis) {
        
        reset();
        testTimeline = new Timeline(new KeyFrame(Duration.millis(millis), (ActionEvent event) -> {
            pin0StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 2), (ActionEvent event) -> {
            pin1StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 3), (ActionEvent event) -> {
            pin2StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 4), (ActionEvent event) -> {
            pin3StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 5), (ActionEvent event) -> {
            pin4StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 6), (ActionEvent event) -> {
            pin5StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 7), (ActionEvent event) -> {
            pin6StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.millis(millis * 8), (ActionEvent event) -> {
            pin7StateProperty.setValue(Boolean.TRUE);
        }));
        testTimeline.play();
    }
    
    public void CycleTest(double[] T1, double[] T2, double[] T3, double[] T4){
        reset();
        for (int i=0; i<8; i++){
            final int k=i;
            stateProperties[i].setValue(Boolean.FALSE);
            timeline[i] = new Timeline(new KeyFrame(Duration.seconds(T2[i]), (ActionEvent event)->{
                stateProperties[k].setValue(Boolean.TRUE);
            }), new KeyFrame(Duration.seconds(T1[i]+T2[i]), (ActionEvent event)->{
                stateProperties[k].setValue(Boolean.FALSE);
            }), new KeyFrame(Duration.seconds(T1[i]+T2[i]+T4[i]), (ActionEvent event)->{
                stateProperties[k].setValue(Boolean.TRUE);
            }), new KeyFrame(Duration.seconds(T1[i]+T2[i]+T3[i]+T4[i]), (ActionEvent event)->{
                stateProperties[k].setValue(Boolean.FALSE);
            }));
            
            timeline[i].setCycleCount(5);
            timeline[i].play();
        }
        
    }
    
    public void gate1Action(double T11, double T12, double T13, double T14){
        reset();
        pin0StateProperty.setValue(Boolean.FALSE);
        testTimeline1 = new Timeline(new KeyFrame(Duration.seconds(T12), (ActionEvent event)->{
            pin0StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T11+T12), (ActionEvent event)->{
            pin0StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T11+T12+T14), (ActionEvent event)->{
            pin0StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T11+T12+T13+T14), (ActionEvent event)->{
            pin0StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline1.play();
        pin0StateProperty.setValue(Boolean.FALSE);
    }
    
    public void gate2Action(double T21, double T22, double T23, double T24){
        reset();
        pin1StateProperty.setValue(Boolean.FALSE);
        testTimeline2 = new Timeline(new KeyFrame(Duration.seconds(T22), (ActionEvent event)->{
            pin1StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T21+T22), (ActionEvent event)->{
            pin1StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T21+T22+T24), (ActionEvent event)->{
            pin1StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T21+T22+T23+T24), (ActionEvent event)->{
            pin1StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline2.play();
        pin1StateProperty.setValue(Boolean.FALSE);
    }
    
    public void gate3Action(double T1, double T2, double T3, double T4){
        reset();
        pin2StateProperty.setValue(Boolean.FALSE);
        testTimeline3 = new Timeline(new KeyFrame(Duration.seconds(T2), (ActionEvent event)->{
            pin2StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2), (ActionEvent event)->{
            pin2StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T1+T2+T4), (ActionEvent event)->{
            pin2StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2+T3+T4), (ActionEvent event)->{
            pin2StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline3.play();
    }
    
    public void gate4Action(double T1, double T2, double T3, double T4){
        reset();
        pin3StateProperty.setValue(Boolean.FALSE);
        testTimeline4 = new Timeline(new KeyFrame(Duration.seconds(T2), (ActionEvent event)->{
            pin3StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2), (ActionEvent event)->{
            pin3StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T1+T2+T4), (ActionEvent event)->{
            pin3StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2+T3+T4), (ActionEvent event)->{
            pin3StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline4.play();
    }
    
    public void gate5Action(double T1, double T2, double T3, double T4){
        reset();
        pin4StateProperty.setValue(Boolean.FALSE);
        testTimeline5 = new Timeline(new KeyFrame(Duration.seconds(T2), (ActionEvent event)->{
            pin4StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2), (ActionEvent event)->{
            pin4StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T1+T2+T4), (ActionEvent event)->{
            pin4StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2+T3+T4), (ActionEvent event)->{
            pin4StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline5.play();
    }
    
    public void gate6Action(double T1, double T2, double T3, double T4){
        reset();
        pin5StateProperty.setValue(Boolean.FALSE);
        testTimeline6 = new Timeline(new KeyFrame(Duration.seconds(T2), (ActionEvent event)->{
            pin5StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2), (ActionEvent event)->{
            pin5StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T1+T2+T4), (ActionEvent event)->{
            pin5StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2+T3+T4), (ActionEvent event)->{
            pin5StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline6.play();
    }
    
    public void gate7Action(double T1, double T2, double T3, double T4){
        reset();
        pin6StateProperty.setValue(Boolean.FALSE);
        testTimeline7 = new Timeline(new KeyFrame(Duration.seconds(T2), (ActionEvent event)->{
            pin6StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2), (ActionEvent event)->{
            pin6StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T1+T2+T4), (ActionEvent event)->{
            pin6StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2+T3+T4), (ActionEvent event)->{
            pin6StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline7.play();
    }
    
    public void gate8Action(double T1, double T2, double T3, double T4){
        reset();
        pin7StateProperty.setValue(Boolean.FALSE);
        testTimeline8 = new Timeline(new KeyFrame(Duration.seconds(T2), (ActionEvent event)->{
            pin7StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2), (ActionEvent event)->{
            pin7StateProperty.setValue(Boolean.FALSE);
        }), new KeyFrame(Duration.seconds(T1+T2+T4), (ActionEvent event)->{
            pin7StateProperty.setValue(Boolean.TRUE);
        }), new KeyFrame(Duration.seconds(T1+T2+T3+T4), (ActionEvent event)->{
            pin7StateProperty.setValue(Boolean.FALSE);
        }));
        testTimeline8.play();
    }
    /*
    * -------------------------- PROPERTY METHODS -------------------------- 
    */
    
    public void setGpioStateValue(int pinNumber, Boolean state) {
        stateProperties[pinNumber].setValue(state);
    }
    
    public BooleanProperty gpio0StateProperty() {
        return pin0StateProperty;
    }

    public BooleanProperty gpio1StateProperty() {
        return pin1StateProperty;
    }

    public BooleanProperty gpio2StateProperty() {
        return pin2StateProperty;
    }

    public BooleanProperty gpio3StateProperty() {
        return pin3StateProperty;
    }

    public BooleanProperty gpio4StateProperty() {
        return pin4StateProperty;
    }

    public BooleanProperty gpio5StateProperty() {
        return pin5StateProperty;
    }

    public BooleanProperty gpio6StateProperty() {
        return pin6StateProperty;
    }

    public BooleanProperty gpio7StateProperty() {
        return pin7StateProperty;
    }
    
    public BooleanProperty gpio8StateProperty() {       //modified
        return pin0StateProperty;
    }

    public BooleanProperty gpio9StateProperty() {
        return pin1StateProperty;
    }

    public BooleanProperty gpio10StateProperty() {
        return pin2StateProperty;
    }

    public BooleanProperty gpio11StateProperty() {
        return pin3StateProperty;
    }

    public BooleanProperty gpio12StateProperty() {
        return pin4StateProperty;
    }

    public BooleanProperty gpio13StateProperty() {
        return pin5StateProperty;
    }

    public BooleanProperty gpio14StateProperty() {
        return pin6StateProperty;
    }

    public BooleanProperty gpio15StateProperty() {
        return pin7StateProperty;
    }
    
    public BooleanProperty gpio16StateProperty() {
        return pin0StateProperty;
    }

    public BooleanProperty gpio17StateProperty() {
        return pin1StateProperty;
    }

    public BooleanProperty gpio18StateProperty() {
        return pin2StateProperty;
    }

    public BooleanProperty gpio19StateProperty() {
        return pin3StateProperty;
    }

    public BooleanProperty gpio20StateProperty() {
        return pin4StateProperty;
    }

    public BooleanProperty gpio21StateProperty() {
        return pin5StateProperty;
    }

    public BooleanProperty gpio22StateProperty() {
        return pin6StateProperty;
    }

    public BooleanProperty gpio23StateProperty() {
        return pin7StateProperty;
    }
}
