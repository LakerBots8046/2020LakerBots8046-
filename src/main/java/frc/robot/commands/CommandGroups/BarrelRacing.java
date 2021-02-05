
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


public class BarrelRacing extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drivetrain The drive subsystem this command will run on
   * @param launcher The launcher subsystem this command will run on
   * @param elevator
   */
  public BarrelRacing(Launcher launcher, Elevator elevator, Intake intake, Drivetrain drivetrain) {
    addCommands(
      new AutoDrive(drivetrain, -0.5, 0.0, 55.0),//(power, turn, and distance to stop) drives forward a distance found in command
      new AutoDrive(drivetrain, -0.5, 0.37, 207.0), 
      new AutoDrive(drivetrain, -0.5, 0.0, 260.0),
      new AutoDrive(drivetrain, -0.5, -0.37, 324.4),
      new AutoDrive(drivetrain, -0.5, 0.0, 347.0),
      new AutoDrive(drivetrain, -0.5, 0.37, 440.0),
      new AutoDrive(drivetrain, -0.5, 0.0, 480.0),
      new AutoDrive(drivetrain, -0.7, -0.26, 590.0)
      );
  }
}
