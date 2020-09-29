/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase { 
  private Compressor compressor;

  private DoubleSolenoid climber;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Climber() {
    compressor = new Compressor(1);
    climber = new DoubleSolenoid(1,0,1);
    compressor.setClosedLoopControl(true);
    retractElevator();    
  }


  public void extendElevator(){
    climber.set(Value.kReverse);
  }
  public void retractElevator(){
    climber.set(Value.kForward);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
