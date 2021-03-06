package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.Elevator.*;
import frc.robot.commands.Launcher.*;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.*;


public class autoSmartLaunch extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param launcher The hatch subsystem this command will run on
   * @param elevator
   */
  public autoSmartLaunch(Launcher launcher, Elevator elevator) {
    addCommands(

        new SetLauncherSpeed(launcher, 28046), //spins up the launcher in velocity mode ends when on target
        new WaitCommand(1.5),// waits a small amount of time
        new emptyElevator(elevator,17000), //25000 drives the elevator in velocity mode
        new WaitCommand(3),// 3 waits long enough to empty the elevator
        new SpinElevator(elevator, 0),// stops the elevator in vBus Mode
        new SpinLauncher(launcher,0));//stops the launcher in Vbus mode
        

    
  }

}
