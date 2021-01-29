
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


public class Slalom extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drivetrain The drive subsystem this command will run on
   * @param launcher The launcher subsystem this command will run on
   * @param elevator
   */
  public Slalom(Launcher launcher, Elevator elevator, Intake intake, Drivetrain drivetrain) {
    addCommands(

    //Step 1 druve forward and turn left
    //Step 2 drive forward and turn right
    //step 3 drive straight
    //step 4 drive forward and trun right
    //step 5 Big turn left
    //step 6 drive forward and turn right
    //step 7 drive straight
    //step 8 drive forward and turn right 
    //step 9 drive forward and turn left


      new AutoDrive(drivetrain, -0.5, 0.0, 100.0)//(power, turn, and distance to stop) drives forward a distance found in command
      //new AutoDrive(drivetrain, 0.0, 0.0, 23.0), // stops after it has reached that distance
      //new autoSmartLaunch(launcher, elevator),
      //new AutodriveReverse(drivetrain, 0.5, 0.0, 10.0),
      //new AutodriveReverse(drivetrain, 0.6, 0.480, -29.0),
      //new AutodriveReverse(drivetrain, 0.0, 0.0, -29.0),
      //new AutoCollectWhileDriving(intake, elevator, launcher, drivetrain),
      //new AutoDrive(drivetrain, 0.0, 0.0, 10.0)
      );
  }
}
