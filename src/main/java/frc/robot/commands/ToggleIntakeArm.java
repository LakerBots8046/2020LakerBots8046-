package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
// import frc.robot.Robot;
public class ToggleIntakeArm extends CommandBase{
    private Intake intake;

    public ToggleIntakeArm(Intake subsystem){
        intake = subsystem;
    
        addRequirements(intake);
    }

    public void initialize(){
       // intake.extendintakearm(); THEN THIS

       if (intake.armIsUp==true){
           intake.extendintakearm();
       }else{
           intake.retractintakearm();
       }

       intake.extendintakearm();

        System.out.println("TogglingArm");
    }

    public void execute(){
       
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