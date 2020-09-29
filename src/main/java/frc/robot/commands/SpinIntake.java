package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
// import frc.robot.Robot;
public class SpinIntake extends CommandBase{
    private Intake intake;
    private double value;
    public SpinIntake(Intake subsystem, double speed){
        intake = subsystem;
        value = speed;
        addRequirements(intake);
    }

    public void initialize(){
        System.out.println("Intake power set");
        intake.spinMotor(value);
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