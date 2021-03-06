package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
//import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Drivetrain;
// import frc.robot.Robot;
public class JoystickDrive extends CommandBase{ 
    private final Drivetrain m_drivetrain;
    private final DoubleSupplier m_move;
    private final DoubleSupplier m_rotate;
    private final BooleanSupplier m_turbo;

    

    public JoystickDrive(Drivetrain drivetrain, DoubleSupplier move, DoubleSupplier rotate,BooleanSupplier turbo){
        m_drivetrain = drivetrain;
        m_move = move;
        m_rotate = rotate;
        m_turbo = turbo;


        addRequirements(drivetrain);
    }

    public void initialize(){
        
    }

    public void execute(){
        if(m_turbo.getAsBoolean()){
            m_drivetrain.drive(.7*m_move.getAsDouble(),.7*m_rotate.getAsDouble());
        } else {

        m_drivetrain.drive(.55*m_move.getAsDouble() ,.55*m_rotate.getAsDouble());
        //System.out.println("joystick drive is running rotate value is" +m_rotate);
        }
    }

    public boolean isFinished(){
        return false;
    }

    public void end() {

    }

    public void interrupted(){
        end();
    }
}