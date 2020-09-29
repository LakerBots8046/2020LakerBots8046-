package frc.robot.commands.Elevator;

//import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
// import frc.robot.Robot;
public class WaitForPowerCell extends CommandBase{
    private Elevator Elevator;
    private double value;
    public WaitForPowerCell(Elevator subsystem){
        Elevator = subsystem;
        addRequirements(Elevator);
    }

    public void initialize(){
    }

    public void execute(){
        System.out.println("checking for ball");
        System.out.println("Sensor Value"+Elevator.getDigitalCargoSensorValue());
    }

    public boolean isFinished(){
        return Elevator.getDigitalCargoSensorValue();
    }

    public void end() {
        System.out.println("ball detected");
    
    }

    public void interrupted(){
        end();
    }
}