package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    
    TalonFX climbingMotor;

    public Climber() {

        climbingMotor = new TalonFX(Constants.Climber.MotorID);

        //Motor configuration
        TalonFXConfiguration climbingMotorConfig = new TalonFXConfiguration();

        climbingMotorConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Climber.EnableCurrentLimit;
        climbingMotorConfig.CurrentLimits.SupplyCurrentLimit = Constants.Climber.CurrentLimit;
        climbingMotorConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Climber.CurrentThreshold;
        climbingMotorConfig.CurrentLimits.SupplyTimeThreshold = Constants.Climber.TimeThreshold;
        
        climbingMotorConfig.MotorOutput.Inverted = Constants.Climber.MotorInvert;
        climbingMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        climbingMotor.getConfigurator().apply(new TalonFXConfiguration());
        climbingMotor.getConfigurator().apply(climbingMotorConfig);
    }


    public void setSpeed(double speed) {
        climbingMotor.set(speed);
    }

    public void stop() {
        climbingMotor.set(0);
    }
}
