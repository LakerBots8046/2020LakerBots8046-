
package frc.robot.commands.CommandGroups;


import frc.robot.commands.Launcher.*;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.Elevator.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutodriveReverse;
import frc.robot.commands.ExtendClimber;
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
  public BarrelRacing(Launcher launcher, Elevator elevator, Intake intake, Drivetrain drivetrain, Climber climber) {
    addCommands(
      new SmartCollect(intake, elevator, launcher),
      new AutoDrive(drivetrain, -0.5, 0.0, 55.0),//(power, turn, and distance to stop) drives forward a distance found in command
      new AutoDrive(drivetrain, -0.5, 0.37, 207.0),//turn around first cone
      new AutoDrive(drivetrain, -0.5, 0.0, 260.0),//going straight
      new AutoDrive(drivetrain, -0.5, -0.37, 327.4),//turn left around second cone
      new AutoDrive(drivetrain, -0.5, 0.0, 352.0),//drive straight
      new AutoDrive(drivetrain, -0.5, 0.37, 440.0),//turn right around third cone
      new AutoDrive(drivetrain, -0.5, 0.0, 470.0),//drive straight towards home
      new AutoDrive(drivetrain, -0.7, -0.2, 532.0),//send it
      new AutoDrive(drivetrain, -0.7, 0.0, 560.0),//
      new SmartLaunch(launcher, elevator, 17000),
      new ExtendClimber(climber)
      );
  }
}
