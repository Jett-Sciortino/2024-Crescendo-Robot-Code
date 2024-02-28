package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber;

public class RetractClimber extends Command {
    
    Climber climber;

    public RetractClimber(Climber climber) {

        this.climber = climber;

        addRequirements(this.climber);
    }


    @Override
    public void initialize() {

        climber.setSpeed(-1);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

        climber.stop();
    }

}
