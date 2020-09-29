package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
// import frc.robot.Robot;
public class tuneElevator extends CommandBase{
    private Elevator Elevator;
    private double value;
    public tuneElevator(Elevator subsystem){
        Elevator = subsystem;
        //value = speed;
        addRequirements(Elevator);
    }

    public void initialize(){
       Elevator.tuneElevator();
    }

    public void execute(){
        Elevator.tuneElevator();
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