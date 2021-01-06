/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.FollowerType; 
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj.shuffleboard.*;

public class Launcher extends SubsystemBase {
  private TalonSRX launcherLead; 
  private TalonSRX launcherFollow; 
  private TalonSRX launcherPivotingHood; 

  //Hardware
  Joystick _joy = new Joystick(1);

  //String for output
  StringBuilder _sb = new StringBuilder();

  //Loop tracker for prints 
  int _loops = 0;

  public Launcher() {
    launcherLead = new TalonSRX(9); 
    launcherFollow = new TalonSRX(10);
    launcherPivotingHood = new TalonSRX(11);

    launcherFollow.follow(launcherLead); // follows what the lead does

    // Factory Defult all hardware to prevent unexpected behavior
    launcherLead.configFactoryDefault();

    // Config senor used for primary PID [Velocity]
    launcherLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);

    /**
     * Phase sensor accordingly. Positive Sensor Reading should match Green
     * (blinking) Leds on Talon
     */
    launcherLead.configNominalOutputForward(0, 30);
    launcherLead.configNominalOutputReverse(0, 30);
    launcherLead.configPeakOutputForward(1, 30);// 1,30
    launcherLead.configPeakOutputReverse(-1, 30);// 1,30
    launcherLead.setSensorPhase(true);

    // Config the Velocity closed loop gains in slot 0

    launcherLead.config_kF(0, .029, 30);
    launcherLead.config_kP(0, 1.2, 30);// upped from 0.05 during Granite State Event
    launcherLead.config_kI(0, 0, 30);
    launcherLead.config_kD(0, 0, 30);
    launcherLead.configClosedloopRamp(.25);

    launcherPivotingHood.configNominalOutputForward(0, 30);
    launcherPivotingHood.configNominalOutputReverse(0, 30);
    launcherPivotingHood.configPeakOutputForward(1, 30);// 1,30
    launcherPivotingHood.configPeakOutputReverse(-1, 30);// 1,30
    launcherPivotingHood.setSensorPhase(true);

    // Config the Velocity closed loop gains in slot 0

    launcherPivotingHood.config_kF(0, .029, 30);
    launcherPivotingHood.config_kP(0, 1.2, 30);// upped from 0.05 during Granite State Event
    launcherPivotingHood.config_kI(0, 0, 30);
    launcherPivotingHood.config_kD(0, 0, 30);
    launcherPivotingHood.configClosedloopRamp(.25);
    
  }
  
  public void tunePivotingHood() {

    //Get gamepad axis
    double leftYstick = -1 * _joy.getY();
    
    //Get Talon/Victor's currst output percentage
    double motorOutput = launcherPivotingHood.getMotorOutputPercent();

    //Prepare line to print
    _sb.append("/tout:");
    //Cast to int to remove decimal places
    _sb.append((int) (motorOutput * 100));
    _sb.append("%"); // Percent

    _sb.append("/tspd:");
    _sb.append(launcherPivotingHood.getSelectedSensorVelocity(0));
    _sb.append("u"); //Native units
    
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
      double targetVelocity_UnitsPer100ms = leftYstick * 500.0 * 4096*3 / 600;
			/* 500 RPM in either direction */
      launcherPivotingHood.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);
      /* Append more signals to print when in speed mode. */
			_sb.append("\terr:");
			_sb.append(launcherPivotingHood.getClosedLoopError(0));
			_sb.append("\ttrg:");
			_sb.append(targetVelocity_UnitsPer100ms);
		} else {
			/* Percent Output */

			launcherPivotingHood.set(ControlMode.PercentOutput, leftYstick);
		}
  /* Print built string every 10 loops */
  if (++_loops >= 10) {
    _loops = 0;
    System.out.println(_sb.toString());
      }
      /* Reset built string */
  _sb.setLength(0);
  
}

public void tuneLauncher() {

  //Get gamepad axis
  double leftYstick = -1 * _joy.getY();
  
  //Get Talon/Victor's currst output percentage
  double motorOutput = launcherLead.getMotorOutputPercent();

  //Prepare line to print
  _sb.append("/tout:");
  //Cast to int to remove decimal places
  _sb.append((int) (motorOutput * 100));
  _sb.append("%"); // Percent

  _sb.append("/tspd:");
  _sb.append(launcherLead.getSelectedSensorVelocity(0));
  _sb.append("u"); //Native units
  
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
    double targetVelocity_UnitsPer100ms = leftYstick * 500.0 * 4096*3 / 600;
    /* 500 RPM in either direction */
    launcherLead.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);
    /* Append more signals to print when in speed mode. */
    _sb.append("\terr:");
    _sb.append(launcherLead.getClosedLoopError(0));
    _sb.append("\ttrg:");
    _sb.append(targetVelocity_UnitsPer100ms);
  } else {
    /* Percent Output */

    launcherLead.set(ControlMode.PercentOutput, leftYstick);
  }
/* Print built string every 10 loops */
if (++_loops >= 10) {
  _loops = 0;
  System.out.println(_sb.toString());
    }
    /* Reset built string */
_sb.setLength(0);

}

  /**
   * Creates a new ExampleSubsystem.
   */
  
public void spinLauncher(double power){
  launcherLead.set(ControlMode.PercentOutput, power); //what percent power the launcher spins at
}

public void setLauncherSpeed(double speed){
  launcherLead.set(ControlMode.Velocity,speed); // what speed the launcher spins at ** velocity mode
}

public int getPivotingHoodSpeed(){
  return launcherPivotingHood.getSelectedSensorVelocity();
}
public boolean isPivotingHoodSpeed(double target){
  if (launcherPivotingHood.getSelectedSensorVelocity()>target) return true;
  else return false;
}

public void spinPivotingHood(double power){
  launcherPivotingHood.set(ControlMode.PercentOutput, power); //what percent power the launcher spins at
}

public void setPivotingHoodSpeed(double speed){
  launcherPivotingHood.set(ControlMode.Velocity,speed); // what speed the launcher spins at ** velocity mode

}

public void setPivotingHoodPosition(double position){ // Change this to be setPivotingHoodPosition
  launcherPivotingHood.set(ControlMode.MotionMagic, position);
} //add launcher position here 


public int getLauncherSpeed(){
  return launcherLead.getSelectedSensorVelocity();
}
public boolean isLauncherSpeed(double target){
  if (launcherLead.getSelectedSensorVelocity()>target) return true;
  else return false;
}

 


public boolean launcherIsAtSpeed(){
  if (launcherLead.getClosedLoopError()< 1000) return true;
  else return false;

}

 @Override
  public void periodic() {
   

    SmartDashboard.putNumber("shooter speed", +launcherLead.getSelectedSensorVelocity());
    // This method will be called once per scheduler run
  }
}
