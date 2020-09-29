package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
// import frc.robot.Robot;
public class SpinElevator extends CommandBase{
    private Elevator Elevator;
    private double value;
    public SpinElevator(Elevator subsystem, double speed){
        Elevator = subsystem;
        value = speed;
        addRequirements(Elevator);
    }

    public void initialize(){
       Elevator.spinElevator(value);
       System.out.println("stopping elevator");
    }

    public void execute(){
        System.out.println("stopping elevator");
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