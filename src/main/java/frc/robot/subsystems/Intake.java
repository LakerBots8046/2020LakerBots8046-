/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.FollowerType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import frc.robot.commands.StopIntake;



public class Intake extends SubsystemBase { // talon control our intake
 
  private TalonSRX intakeLead;
  private VictorSPX intakeFollow;
  private DoubleSolenoid intakearmDoubleSolenoid;
  public boolean armIsUp;

  /**
   * 
   * Creates a new ExampleSubsystem.
   */
  public Intake() {
    intakeLead = new TalonSRX(2);
    intakeFollow = new VictorSPX(1); 
    intakeLead.configFactoryDefault();
    intakeFollow.follow(intakeLead);  // the follow follows what the lead does 
    //intakearmDoubleSolenoid = new DoubleSolenoid(1,6,7);///DO THIS FIRST
    intakearmDoubleSolenoid = new DoubleSolenoid(1,6,7);
    armIsUp = true;


  }
//  public void extendintakearm(){
//    intakearmDoubleSolenoid.set(Value.kReverse);
//  }
public void extendintakearm(){
  intakearmDoubleSolenoid.set(Value.kReverse);
  armIsUp = false;
}

//  public void retractintakearm(){//AND THIS
//    intakearmDoubleSolenoid.set(Value.kForward);
//  }
public void retractintakearm(){
      intakearmDoubleSolenoid.set(Value.kForward);
      armIsUp = true;
      

}
  public void spinMotor(double speed){
    intakeLead.set(ControlMode.PercentOutput, speed); // how fast the intake spins
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
