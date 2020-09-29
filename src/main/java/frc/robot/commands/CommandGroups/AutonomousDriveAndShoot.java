package frc.robot.commands.CommandGroups;


import frc.robot.commands.Launcher.*;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.Elevator.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.*;
//import frc.robot.commands;


public class AutonomousDriveAndShoot extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drivetrain The drive subsystem this command will run on
   * @param launcher The launcher subsystem this command will run on
   * @param elevator
   */
  public AutonomousDriveAndShoot(Launcher launcher, Elevator elevator, Intake intake, Drivetrain drivetrain) {
    addCommands(
      new AutoDrive(drivetrain, -0.3, 0.0, 25.0),// drives forward a distance found in command
      new AutoDrive(drivetrain, 0.0, 0.0, 25.0), // stops after it has reached that distance
      new SmartLaunch(launcher, elevator) // scores all the points
      //new AutoDrive(drivetrain, 0.3, 0.0),
      //new AutoDrive(drivetrain, 0.3, 0.2),
      //new AutoDrive(drivetrain, -0.3, 0.2),
      //new SmartCollect(intake, elevator, launcher)
      );
  }
}
