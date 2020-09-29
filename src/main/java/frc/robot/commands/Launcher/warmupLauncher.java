package frc.robot.commands.Launcher;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class warmupLauncher extends CommandBase{
    private Launcher launcher;
    private double value;
    public warmupLauncher(Launcher subsystem, double speed){
        launcher = subsystem;
        value = speed;
        addRequirements();
    }

    public void initialize(){
        launcher.spinLauncher(value);
    }

    public void execute(){
        launcher.spinLauncher(value);
    }

    public boolean isFinished(){
        return true;// should be false
    }

    public void end() {

    }

    public void interrupted(){
        end();
    }
    
    }
