package frc.robot.commands.Launcher;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class tuneHood extends CommandBase{
    private Launcher Launcher;
    private double value;
    public tuneHood(Launcher subsystem){
        Launcher = subsystem;
        //value = speed;
        addRequirements(Launcher);
    }

    public void initialize(){
        Launcher.tunePivotingHood();
    }

    public void execute(){
        Launcher.tunePivotingHood();
    }

    public boolean isFinished(){
        return false;
    }

    public void end() {

    }

    public void interrupted(){
        end();
    }
}