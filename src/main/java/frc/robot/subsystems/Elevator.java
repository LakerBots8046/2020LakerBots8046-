/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

import javax.lang.model.util.ElementScanner6;

import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.utils.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import jdk.nashorn.internal.objects.annotations.Getter;

public class Elevator extends SubsystemBase {
  private DigitalInput digitalCargoSensor = new DigitalInput(9);
  private TalonSRX elevatorLead;
  private VictorSPX elevatorFollow;
/* Hardware */
  Joystick _joy = new Joystick(1);

  /* String for output */
  StringBuilder _sb = new StringBuilder();

  /*Loop tracker for points*/
  int _loops = 0;

  int _smoothing =0;

  int _pov = -1;

  

    
  /**
   * Creates a new ExampleSubsystem.
   */
  public Elevator() {
    elevatorLead = new TalonSRX(3);
    elevatorFollow = new VictorSPX(4); 
    //DigitalInput input = new DigitalInput(9); 
  
    
    elevatorFollow.follow(elevatorLead); //follows what lead does
   /* Factory Default all hardware to prevent unexpected behaviour */
    elevatorLead.configFactoryDefault();

    /* Config sensor used for Primary PID [Velocity] */
    elevatorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0, 30);
 
                                          
 /**
		 * Phase sensor accordingly. 
         * Positive Sensor Reading should match Green (blinking) Leds on Talon
         */
elevatorLead.setSensorPhase(true);
elevatorLead.setInverted(true);
elevatorFollow.setInverted(true);
elevatorLead.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);

		/* Config the peak and nominal outputs */
		elevatorLead.configNominalOutputForward(0, 30);
		elevatorLead.configNominalOutputReverse(0, 30);
		elevatorLead.configPeakOutputForward(1, 30);
    elevatorLead.configPeakOutputReverse(-1, 30);
    elevatorLead.configForwardSoftLimitEnable(false);
    elevatorLead.configReverseSoftLimitEnable(false);
    
		/* Config the Velocity closed loop gains in slot0 */
		elevatorLead.config_kF(0, 0.035, 30);
		elevatorLead.config_kP(0, .02, 30);
		elevatorLead.config_kI(0, 0, 30);
    elevatorLead.config_kD(0, 0, 30);

    elevatorLead.configMotionCruiseVelocity(20000,10); //18000// need to tune these
    elevatorLead.configMotionAcceleration(10000, 10); //8000 need to tune these

    elevatorLead.setSelectedSensorPosition(0,0,10);// resets the encoder on the elevator to zero at the start
    

	}  

             
  /**
	 * This function is called periodically during operator control
	 */

  public void spinElevator (double speed){
    elevatorLead.set(ControlMode.PercentOutput, speed); //how fast the elevator spins
  }
 public void advanceElevator (double amount){
   elevatorLead.set(ControlMode.MotionMagic, amount); 
 }
public void emptyElevator(double speed){
  elevatorLead.set(ControlMode.Velocity,speed);
}
// make a method for spinning the elevator in velocity mode to use in "empty elevator"


 //--------used to tune elevator------//
  public void tuneElevator() {
    
    /* Get gamepad axis */
      double leftYstick = -1 * _joy.getY();

     /* Get Talon/Victor's current output percentage */
      double motorOutput = elevatorLead.getMotorOutputPercent();

      /* Prepare line to print */
      _sb.append("\tout:");
      /* Cast to int to remove decimal places */
      _sb.append((int) (motorOutput * 100));
      _sb.append("%"); //Percent 
     
      _sb.append("\tspd:");
      _sb.append(elevatorLead.getSelectedSensorVelocity(0));
      _sb.append("u"); // Native units

      /** 
		 * When button 1 is held, start and run Velocity Closed loop.
		 * Velocity Closed Loop is controlled by joystick position x500 RPM, [-500, 500] RPM
		 */
		if (_joy.getRawButton(1)) {
      /* Velocity Closed Loop */

      /**
			 * Convert 500 RPM to units / 100ms.
			 * 4096 Units/Rev * 500 RPM / 600 100ms/min in either direction:
			 * velocity setpoint is in units/100ms
			 */
      double targetPos= leftYstick *4096*10.0;
			/* 500 RPM in either direction */
      elevatorLead.set(ControlMode.MotionMagic, targetPos);
      
     /* Append more signals to print when in speed mode. */
      _sb.append("\terr:");
			_sb.append(elevatorLead.getClosedLoopError(0));
			_sb.append("\ttrg:");
			_sb.append(targetPos);
		} else {

      /* Percent Output */
      elevatorLead.set(ControlMode.PercentOutput, leftYstick);
      
      if (_joy.getRawButton(2)) {
        /* Zero sensor positions */
        elevatorLead.setSelectedSensorPosition(0);
      }
  
      int pov = _joy.getPOV();
      if (_pov == pov) {
        /* no change */
      } else if (_pov == 180) { // D-Pad down
        /* Decrease smoothing */
        _smoothing--;
        if (_smoothing < 0)
          _smoothing = 0;
        elevatorLead.configMotionSCurveStrength(_smoothing);
  
        System.out.println("Smoothing is set to: " + _smoothing);
      } else if (_pov == 0) { // D-Pad up
        /* Increase smoothing */
        _smoothing++;
        if (_smoothing > 8)
          _smoothing = 8;
        elevatorLead.configMotionSCurveStrength(_smoothing);
  
        System.out.println("Smoothing is set to: " + _smoothing);
      }
      _pov = pov; /* save the pov value for next time */
  
      /* Instrumentation */
     
    }
    Instrum.Process(elevatorLead, _sb);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("ElevatorSpeed", +elevatorLead.getSelectedSensorVelocity());
    // This method will be called once per scheduler run
  } 
 
  public boolean getDigitalCargoSensorValue() {
    if (digitalCargoSensor.get() == true) return false;
    else if(digitalCargoSensor.get()== false) return true;
    else return true;
}

 public double getElevatorencodervalue(){
   return elevatorLead.getSelectedSensorPosition();
 }

 
}



