package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
// import frc.robot.Robot;
public class ExtendClimber extends CommandBase{
    private Climber climber;

    public ExtendClimber(Climber subsystem){
        climber = subsystem;
    
        addRequirements(climber);
    }

    public void initialize(){
        climber.extendElevator();
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