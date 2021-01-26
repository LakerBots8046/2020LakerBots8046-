package frc.robot.commands.CommandGroups;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.ExtendIntakeArm;
import frc.robot.commands.TurnOnLED;
import frc.robot.commands.CommandGroups.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Intake;


public class SmartCollectWithLED extends ParallelDeadlineGroup {
  /**
   * Creates a new ReplaceMeParallelDeadlineGroup.
   */
  public SmartCollectWithLED(Intake intake, Elevator elevator, Launcher launcher, LED LED) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
      new SmartCollect(intake, elevator, launcher),
      new TurnOnLED(LED)
    );
  }
} 
