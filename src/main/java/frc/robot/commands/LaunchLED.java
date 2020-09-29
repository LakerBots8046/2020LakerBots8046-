package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class LaunchLED extends CommandBase{
    private LED LED;
    public LaunchLED(LED subsystem){
        LED = subsystem;
        addRequirements(LED);
    }

    public void initialize(){
    }
    public void execute(){
        LED.experimentalLED();
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