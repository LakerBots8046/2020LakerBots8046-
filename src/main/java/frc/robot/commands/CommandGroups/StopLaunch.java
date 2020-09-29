package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj.controller.ElevatorFeedforward;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.TurnOffLED;
import frc.robot.commands.Launcher.*;
import frc.robot.commands.TurnOnLED;
import frc.robot.commands.Elevator.*;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.*;

/**
 * A complex auto command that collects balls automatically
 */
public class StopLaunch extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param launcher 
   * @param elevator
   */
  public StopLaunch (Elevator elevator,Launcher launcher) {
    addCommands(
       
        new SpinLauncher(launcher, 0.0), // spins the intake (could be higher?) or increase gear ratio..
        new SpinElevator(elevator, 0.0)); // stops the intake to maintain power cell spacing in elevator
       

  }

}
