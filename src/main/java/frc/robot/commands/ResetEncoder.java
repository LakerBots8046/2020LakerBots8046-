package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj2.command.CommandBase;

//import frc.robot.RobotContainer;
//import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Drivetrain;
// import frc.robot.Robot;
public class ResetEncoder extends CommandBase{ 
    private final Drivetrain m_drivetrain;
  

    public ResetEncoder(Drivetrain drivetrain){
        m_drivetrain = drivetrain;
    
        addRequirements(drivetrain);
    }

    public void initialize(){
        m_drivetrain.resetEncoder();
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