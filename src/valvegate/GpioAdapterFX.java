
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
        
        pin27StateProperty = new SimpleBooleanProperty(Boolean.FALSE);
                
        stateProperties = new BooleanProperty[]{pin0StateProperty,
            pin1StateProperty,
            pin2StateProperty,
            pin3StateProperty,
            pin4StateProperty,
            pin5StateProperty,
            pin6StateProperty,
            pin7StateProperty
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
        /*
        pins.put(pin0StateProperty, null);
        pins.put(pin1StateProperty, null);
        pins.put(pin2StateProperty, null);
        pins.put(pin3StateProperty, null);
        pins.put(pin4StateProperty, null);
        pins.put(pin5StateProperty, null);
        pins.put(pin6StateProperty, null);
        pins.put(pin7StateProperty, null);*/
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
                
        // provision pin#0 - pin#7 as output pins with their pin states LOW
        GpioPinDigitalOutput pin0 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_00, "PIN0", PinState.LOW);
        GpioPinDigitalOutput pin1 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PIN1", PinState.LOW);
        GpioPinDigitalOutput pin2 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_02, "PIN2", PinState.LOW);
        GpioPinDigitalOutput pin3 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_03, "PIN3", PinState.LOW);
        GpioPinDigitalOutput pin4 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_04, "PIN4", PinState.LOW);
        GpioPinDigitalOutput pin5 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_05, "PIN5", PinState.LOW);
        GpioPinDigitalOutput pin6 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_06, "PIN6", PinState.LOW);
        GpioPinDigitalOutput pin7 = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PIN7", PinState.LOW);
            
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
 
        pins.put(pin0StateProperty, createPinListener(pin0));
        pins.put(pin1StateProperty, createPinListener(pin1));
        pins.put(pin2StateProperty, createPinListener(pin2));
        pins.put(pin3StateProperty, createPinListener(pin3));
        pins.put(pin4StateProperty, createPinListener(pin4));
        pins.put(pin5StateProperty, createPinListener(pin5));
        pins.put(pin6StateProperty, createPinListener(pin6));
        pins.put(pin7StateProperty, createPinListener(pin7));
        
        
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
        for (int i = 0; i <= 7; i++) {
            stateProperties[i].setValue(Boolean.TRUE);
        }
    }
    
    public void setOffAllPins(){
        for (int i = 0; i <= 7; i++) {
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
}
