package frc.robot.commands.Launcher;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class ResetHoodEncoder extends CommandBase{
    private final Launcher Launcher;

    public ResetHoodEncoder(final Launcher subsystem) {
        Launcher = subsystem;
        
        addRequirements(Launcher);
    }

    public void initialize(){
    Launcher.resetHoodEncoder();   
    }

    public void execute(){
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
