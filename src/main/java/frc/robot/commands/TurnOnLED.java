package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Launcher;
// import frc.robot.Robot;
public class TurnOnLED extends CommandBase{
    private LED LED;
    public TurnOnLED(LED subsystem){
        LED = subsystem;
        addRequirements(LED);
    }

    public void initialize(){
    }
    public void execute(){
        LED.startled();
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