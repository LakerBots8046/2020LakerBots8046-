
package frc.robot.commands.CommandGroups;


import frc.robot.commands.Launcher.*;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.Elevator.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutodriveReverse;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.*;
//import frc.robot.commands;


public class Bounce extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drivetrain The drive subsystem this command will run on
   * @param launcher The launcher subsystem this command will run on
   * @param elevator
   */
  public Bounce(Launcher launcher, Elevator elevator, Intake intake, Drivetrain drivetrain) {
    addCommands(
      new AutoDrive(drivetrain, -0.5, -0.32, 29.0), //turn left
      new AutoDrive(drivetrain, 0.0, 0.0, 29.0), // stops after it has reached that distance and hits the cone
      new AutodriveReverse(drivetrain, 0.5, -0.24, -7.0), //in reverse turn
      new AutodriveReverse(drivetrain, 0.5, 0.0, -25.0), //in reverse drive straight
      new AutodriveReverse(drivetrain, 0.5, -0.4, -82.0), // turn around cone
      new AutodriveReverse(drivetrain, 0.5, 0.0, -118.0), // straight to target cone
      new AutodriveReverse(drivetrain, 0.0, 0.0, -118.0),
      new AutoDrive(drivetrain, -0.5, 0.0, -60.0)
      );
  }
}
