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
import frc.robot.commands.Elevator.autoadvanceElevator;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.*;

/**
 * A complex auto command that collects balls automatically
 */
public class SmartCollectLastBall extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param launcher 
   * @param elevator
   */
  public SmartCollectLastBall(Intake intake, Elevator elevator,Launcher launcher) {
    addCommands(
       
        //new TurnOffLED(launcher), // turns off LED
        new SpinIntake(intake, -0.8), // spins the intake (could be higher?) or increase gear ratio...
        new WaitForPowerCell(elevator), // ends when the proximity sensor detects a power cell 
        new WaitCommand(.2), // waits 1 seonds so the intake keeps spinning to push the ball through the transition
        new SpinIntake(intake, 0) // stops the intake to maintain power cell spacing in elevator
       // new TurnOnLED(launcher)
        ); // to collect again if needed
        //new SpinIntake(intake, 0.5); 

  }

}
