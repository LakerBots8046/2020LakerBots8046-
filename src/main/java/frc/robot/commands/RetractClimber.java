package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
// import frc.robot.Robot;
public class RetractClimber extends CommandBase{
    private Climber climber;

    public RetractClimber(Climber subsystem){
        climber = subsystem;
    
        addRequirements(climber);
    }

    public void initialize(){
        climber.retractElevator();
        System.out.println("retracting elevator");
    }

    public void execute(){
       // intake.spinMotor(value);
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