package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj2.command.CommandBase;

//import frc.robot.RobotContainer;
//import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Drivetrain;
// import frc.robot.Robot;
public class AutodriveReverse extends CommandBase{ 
    private final Drivetrain m_drivetrain;
    private final Double m_move;
    private final Double m_rotate;
    private final Double m_value; 

    

    public AutodriveReverse(Drivetrain drivetrain, Double move, Double rotate, Double value){
        m_drivetrain = drivetrain;
        m_move = move;
        m_rotate = rotate;
        m_value = value;


        addRequirements(drivetrain);
    }

    public void initialize(){
        
    }

    public void execute(){
        
        m_drivetrain.drive(m_move ,m_rotate);
    System.out.println("drivetrain left encoder" +m_drivetrain.getDriveDistance());
    
    }

    public boolean isFinished(){
        return m_drivetrain.isDistanceReachedReverse(m_value);
    }

  
    

    public void end() {

    }

    public void interrupted(){
        end();
    }
}