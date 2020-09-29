/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.FollowerType; 
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.shuffleboard.*;

public class LED extends SubsystemBase {
 
   private AddressableLED displayedled;
   private AddressableLEDBuffer ledbuffer;


  public LED() {
  
    displayedled =  new AddressableLED(1);
    ledbuffer = new AddressableLEDBuffer(60);

   
  displayedled.setLength(ledbuffer.getLength());
  displayedled.setData(ledbuffer);
  displayedled.start();

  }
  
  

 public void startled(){
   for (var i = 0; i < ledbuffer.getLength(); i++) {
     ledbuffer.setRGB(i, 0, 0, 255);}

     displayedled.setData(ledbuffer);
 }
 public void offled(){
  for (var i = 0; i < ledbuffer.getLength(); i++) {
    ledbuffer.setRGB(i, 0, 0, 0);}
    
    displayedled.setData(ledbuffer);
 }

public void experimentalLED(){
  for (var i=0; i<ledbuffer.getLength();i++){
 ledbuffer.setRGB(i, 100,0,0);  //Launcher.getSelectedSensorVelocity()/100, 0);
  }
  displayedled.setData(ledbuffer);
}



 @Override
  public void periodic() {
   

  }
}
