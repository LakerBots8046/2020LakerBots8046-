package frc.robot.commands.CommandGroups;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.CommandGroups.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Intake;


public class AutoCollectWhileDriving extends ParallelDeadlineGroup {
  /**
   * Creates a new ReplaceMeParallelDeadlineGroup.
   */
  public AutoCollectWhileDriving(Intake intake, Elevator elevator, Launcher launcher, Drivetrain drivetrain) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new SmartCollect(intake, elevator, launcher), 
        new AutoDrive(drivetrain, -0.45, 0.2, 25.0)
    );
  }
} 