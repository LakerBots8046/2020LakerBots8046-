package frc.robot.commands.Launcher;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class SetLauncherSpeed extends CommandBase{
    private Launcher Launcher;
    private double value;
    public SetLauncherSpeed(Launcher subsystem, double speed){
        Launcher = subsystem;
        value = speed;
        addRequirements(Launcher);
    }

    public void initialize(){
       
    }

    public void execute(){
        Launcher.setLauncherSpeed(value);
    }

    public boolean isFinished(){
        return Launcher.launcherIsAtSpeed();
    }

    public void end() {

    }

    public void interrupted(){
        end();
    }
}
