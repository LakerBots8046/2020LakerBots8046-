/*package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class Launch extends CommandBase{
    private Launcher Launcher;
    private double value;
    public Launch(Launcher subsystem, double speed){
        Launcher = subsystem;
        value = speed;
        addRequirements(Launcher);
    }

    public void initialize(){
        Launcher.spinLauncher(value);
    }

    public void execute(){
        Launcher.spinLauncher(value);
    }

    public boolean isFinished(){
        return true;
    }

    public void end() {

    }

    public void interrupted(){
        end();
    }
}
*/