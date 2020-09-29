package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.*;
// import frc.robot.Robot;
public class TurnOffLED extends CommandBase{
    private LED LED;
    public TurnOffLED(LED subsystem){
        LED = subsystem;
        addRequirements(LED);
    }

    public void initialize(){
    }
    public void execute(){
        LED.offled();
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