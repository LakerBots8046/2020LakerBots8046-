package frc.robot.commands.Elevator;

//import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
//import frc.robot.subsystems.Intake;;
// import frc.robot.Robot;
public class emptyElevator extends CommandBase{
    private Elevator elevator;
    private double value;
    public emptyElevator(Elevator subsystem, double speed){
        elevator = subsystem;
        value = speed;
        addRequirements();
    }

    public void initialize(){
        //need to get initial position like in autoadvance and add it to value like in autoadvance
       System.out.println("emptyElevator initialized");
    }

    public void execute() {
        elevator.emptyElevator(value);//uses velocity control mode 
        System.out.println("emptyElevator executing");
    }
    public boolean isFinished(){
        return true;
    }

    public void end() {
        System.out.println("emptyElevator ending");
    }

    public void interrupted(){
        end();
    }

}