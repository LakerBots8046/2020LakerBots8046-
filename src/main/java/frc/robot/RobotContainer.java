/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import static edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.*;


import frc.robot.commands.Launcher.*;
import frc.robot.commands.Elevator.*;
import frc.robot.commands.*;
import frc.robot.commands.CommandGroups.*;
import frc.robot.commands.RetractIntakeArm;
import frc.robot.commands.ExtendIntakeArm;
//import all robot commands here
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.*;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Climber;
//import edu.wpi.*;
//import all robot subsystems here

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Elevator elevator = new Elevator();
  private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Launcher launcher = new Launcher(); 
  private final LED LED = new LED();
  //private final Shooter shooter = new Shooter();
  private final CommandBase AutoScoreandCollect = new AutoScoreandCollect(launcher, elevator, intake, drivetrain);
  private final CommandBase AutonomousDriveAndShoot = new AutonomousDriveAndShoot(launcher, elevator, intake, drivetrain);
  private final CommandBase Slalom = new Slalom(launcher, elevator, intake, drivetrain);
  private final CommandBase BarrelRacing = new BarrelRacing(launcher, elevator, intake, drivetrain);
  private final CommandBase Bounce = new Bounce(launcher, elevator, intake, drivetrain);
  //private final CommandBase autoCommand = new ElevatorStop(intake, elevator, launcher);

  private final XboxController Drivercontroller = new XboxController(0);
  private final XboxController Operatorcontroller = new XboxController(1);
  
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

     // Add commands to the autonomous command chooser
     m_chooser.setDefaultOption("A New Hope", Bounce);
     m_chooser.addOption("Return of the Jedi", AutonomousDriveAndShoot);
     //add barrell race
     //add bounce
 
     // Put the chooser on the dashboard
     Shuffleboard.getTab("Autonomous").add(m_chooser);

// A chooser for autonomous commands
  
  intake.retractintakearm();
  launcher.resetHoodEncoder();

}
 
  private void configureButtonBindings() {


  JoystickButton driver_LStickButton = new JoystickButton(Drivercontroller, XboxController.Button.kStickLeft.value);


 // drivetrain.setDefaultCommand(new JoystickDrive(drivetrain,()-> Drivercontroller.getRawAxis(1),()-> Drivercontroller.getRawAxis(4)));
  drivetrain.setDefaultCommand(new JoystickDrive(drivetrain,()-> Drivercontroller.getRawAxis(1),()-> Drivercontroller.getRawAxis(4),()-> driver_LStickButton.get()));
  //launcher.setDefaultCommand(new tuneLauncher(launcher));
  //launcher.setDefaultCommand(new tuneHood(launcher));// enable this if tuning the hood
  //elevator.setDefaultCommand(new tuneElevator(elevator));

  //------------------------Basic Functionallity Testing ------------------------//

  //new JoystickButton(Drivercontroller,Button.kA.value).whenPressed(new SpinIntake(intake, 0.-.5));
  //new JoystickButton(Drivercontroller,Button.kY.value).whenPressed(new SpinLauncher(launcher,0.3));
  //new JoystickButton(Drivercontroller,Button.kX.value).whenPressed(new SpinLauncher(launcher,0.0));
  //new JoystickButton(Drivercontroller,Button.kBumperLeft.value).whenPressed(new SpinElevator(elevator,-0.3));
  //new JoystickButton(Drivercontroller,Button.kBumperRight.value).whenPressed(new SpinElevator(elevator,0.0));
  //new JoystickButton(Drivercontroller,Button.kStart.value).whenPressed(new TurnOnLED(launcher));
  //new JoystickButton(Drivercontroller,Button.kBack.value).whenPressed(new TurnOffLED(launcher));
  //new JoystickButton(Drivercontroller,Button.kA.value).whenPressed(new SetLauncherSpeed(launcher, 15000));
  //new JoystickButton(Drivercontroller,Button.kBumperRight.value).whenPressed(new SetLauncherSpeed(launcher,0));

    //-----------------------Future Capabilities -------------------------------------------//
    //new JoystickButton(Operatorcontroller, Button.kBumperRight.value).whenPressed(new ExtendIntakeArm(intake));
    //new JoystickButton(Operatorcontroller, Button.kBumperLeft.value).whenPressed(new RetractIntakeArm(intake));

    new JoystickButton(Drivercontroller,Button.kB.value).whenPressed(new SpinIntake(intake,0.0));
    new JoystickButton(Drivercontroller,Button.kBumperRight.value).whenPressed(new StopLaunch(elevator, launcher));// in vbus mode so it coasts to a stop
    new JoystickButton(Drivercontroller,Button.kA.value).whenPressed(new SmartCollectWithLED(intake, elevator,launcher,LED));
    new JoystickButton(Drivercontroller,Button.kBumperLeft.value).whenPressed(new SmartLaunchWithLED(intake, elevator, launcher,LED));
    //new JoystickButton(Drivercontroller, Button.kX.value).whenPressed(new SpinIntake(intake,-0.3));
    //new JoystickButton(Drivercontroller, Button.kY.value).whenPressed(new SmartCollectLastBall(intake, elevator, launcher));
    //sample comment
  
    
   new JoystickButton(Operatorcontroller, Button.kY.value).whenPressed(new ExtendClimber(climber));
    new JoystickButton(Operatorcontroller, Button.kA.value).whenPressed(new RetractClimber(climber));
    //new JoystickButton(Operatorcontroller, Button.kBumperLeft.value).whenPressed(new SpinLaunc her(launcher, 1));
    new JoystickButton(Operatorcontroller, Button.kBumperRight.value).whenPressed(new ToggleIntakeArm(intake));
   // new JoystickButton(Operatorcontroller, Button.kBumperLeft.value).whenPressed(new RetractIntakeArm(intake));
   // new JoystickButton(Operatorcontroller, Button.kB.value).whenPressed(new SetHoodPosition(launcher, -300));//long distance shot
   // new JoystickButton(Operatorcontroller, Button.kX.value).whenPressed(new SetHoodPosition(launcher, 0));//close shot
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   public Command getAutonomousCommand() {

    //return m_autoCommand;

    return m_chooser.getSelected();
   }
   public Climber getClimber(){
     return this.climber;
   }
   public Launcher getLauncher(){
     return this.launcher;
   }
}
