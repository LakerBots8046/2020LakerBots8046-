package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.Elevator.*;
import frc.robot.commands.Launcher.*;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.*;


public class SmartLaunchBlue extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param launcher The hatch subsystem this command will run on
   * @param elevator
   */
  public SmartLaunchBlue(Launcher launcher, Elevator elevator, double elevatorSpeed) {
    addCommands(
        new SetHoodPosition(launcher, -340), //Raise hood sparta!!! 311
        new SetLauncherSpeed(launcher, 30046), //spins up the launcher in velocity mode ends when on target
        new WaitCommand(.5),// waits a small amount of time
        new emptyElevator(elevator,elevatorSpeed), //25000 drives the elevator in velocity mode
        new WaitCommand(4),// 3 waits long enough to empty the elevator
        new SetHoodPosition(launcher,0), //Brings the hood down
        new SpinElevator(elevator, 0),// stops the elevator in vBus Mode
        new SpinLauncher(launcher,0));//stops the launcher in Vbus mode
        

    
  }

}
