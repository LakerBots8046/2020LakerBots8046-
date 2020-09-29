package frc.robot.commands. Elevator;

//import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
// import frc.robot.Robot;
public class autoadvanceElevator extends CommandBase{
    private Elevator Elevator;
    private double value;
    public autoadvanceElevator(Elevator subsystem){
        Elevator = subsystem;
        addRequirements(Elevator);
    }

    public void initialize(){
     
    }

    public void execute(){
        value = Elevator.getElevatorencodervalue();
    Elevator.advanceElevator(value + 67500); // 1000 value needs to be adjusted
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