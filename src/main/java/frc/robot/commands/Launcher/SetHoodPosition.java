package frc.robot.commands.Launcher;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class SetHoodPosition extends CommandBase{
    private Launcher Launcher;
    private double value;
    public SetHoodPosition(Launcher subsystem, double position){
        Launcher = subsystem;
        value = position;
        addRequirements(Launcher);
    }

    public void initialize(){
       
    }

    public void execute(){
        Launcher.setPivotingHoodPosition(value);//1000 is an arbitrary value
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
