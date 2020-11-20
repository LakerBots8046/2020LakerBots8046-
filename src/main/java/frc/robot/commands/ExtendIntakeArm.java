package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Intake;
// import frc.robot.Robot;
public class ExtendIntakeArm extends CommandBase{
    private Intake intake;

    public ExtendIntakeArm(Intake subsystem){
        intake = subsystem;
    
        addRequirements(intake);
    }

    public void initialize(){
       // intake.extendintakearm(); THEN THIS
       intake.extendintakearm();

        System.out.println("extending intake arm");
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