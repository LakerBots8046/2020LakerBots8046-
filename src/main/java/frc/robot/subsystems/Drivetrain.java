/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.*;
import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  //private final PowerDistributionPanel pdb;

  private final CANSparkMax leftLead; // spark max controls drivetrain
  //leftLead = new CANSparkMax (0);
  private final CANSparkMax leftfollow;
  //leftfollow = new CANSparkMax (0);
  private final CANSparkMax rightLead;
  //rightLead = new CANSparkMax (0);
  private final CANSparkMax rightfollow; 
  //rightfollow = new CANSparkMax (0);
  private final DifferentialDrive m_robotDrive;
  private final DifferentialDrive m_robotDrive2;

  private CANEncoder leftEncoder;

  
  

 

  public Drivetrain() {
leftLead = new CANSparkMax(6,MotorType.kBrushless);
leftfollow = new CANSparkMax(7,MotorType.kBrushless);
rightLead = new CANSparkMax (5,MotorType.kBrushless);
rightfollow = new CANSparkMax (8,MotorType.kBrushless);
//pdb = new PowerDistributionPanel(0);

leftEncoder = leftLead.getEncoder(EncoderType.kHallSensor, 42);
leftEncoder.setPosition(0);


//rightfollow.follow(rightLead);
//leftfollow.follow(leftLead);
leftLead.restoreFactoryDefaults();
rightLead.restoreFactoryDefaults();
leftfollow.restoreFactoryDefaults();
rightfollow.restoreFactoryDefaults();
m_robotDrive = new DifferentialDrive(rightLead,leftLead);
m_robotDrive2 = new DifferentialDrive(rightfollow, leftfollow);
leftLead.setIdleMode(IdleMode.kCoast);
rightLead.setIdleMode(IdleMode.kCoast);
leftLead.setOpenLoopRampRate(1.0);
rightLead.setOpenLoopRampRate(1.0);



  }
public void drive(double move, double rotate) {
 m_robotDrive.arcadeDrive(move, rotate,true);
 m_robotDrive2.arcadeDrive(move, rotate,true);
 //System.out.println("drive method is running NOW" +move);
}
  @Override
  public void periodic() {
    System.out.println("Left Encoder Value" +getDriveDistance() );
    /*
    SmartDashboard.putNumber("leftLeadCurrent", +leftLeadCurrent());
    SmartDashboard.putNumber("leftfollowCurrent", +leftFollowCurrent());
    SmartDashboard.putNumber("rightLeadCurrent", +rightLeadCurrent());
    SmartDashboard.putNumber("rightfollowCurrent", +rightFollowCurrent());
    // This method will be called once per scheduler run
    */
  }
//hi

  public double getDriveDistance(){
  return leftEncoder.getPosition();
  } 
/*
  public double leftLeadCurrent(){
    return pdb.getCurrent(2);//corresponds with pdb slot not can ID
  }
  public double leftFollowCurrent(){
    return pdb.getCurrent(3);
  }
  public double rightLeadCurrent(){
    return pdb.getCurrent(12);
  }
  public double rightFollowCurrent(){
    return pdb.getCurrent(13);
  }
  */

  public boolean isDistanceReached(double value){
    if (leftEncoder.getPosition()>value) return true;
    else return false;}

  public boolean isDistanceReachedReverse(double value){
    if (leftEncoder.getPosition()<value) return true;
    else return false;
  
  }

  public void resetEncoder(){
    leftEncoder.setPosition(0.0);
  }
}
