package frc.robot.commands.drive;

import static frc.robot.Constants.Drive.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistanceCommand extends CommandBase {

    // Declare the accessible variables
    DriveSubsystem req_subsystem;
    PIDController straightPIDController = new PIDController(DRIVE_STRAIGHT_KP, DRIVE_STRAIGHT_KI, DRIVE_STRAIGHT_KD);
    PIDController distancePIDController = new PIDController(DRIVE_DISTANCE_KP, DRIVE_DISTANCE_KI, DRIVE_DISTANCE_KD);
    double distanceSetpoint;
    double straightSetpoint;

    public DriveDistanceCommand(DriveSubsystem subsystem, double distance) {
        // Add the subsystem to required subsystems
        req_subsystem = subsystem;
        addRequirements(subsystem);
        
        // Set the tolerance of the PID controllers
        straightPIDController.setTolerance(2, 1);
        distancePIDController.setTolerance(1, 1);

        // Set the setpoints
        distanceSetpoint = req_subsystem.getDriveDistance() + distance;
        straightSetpoint = req_subsystem.getDriveAngle();
    }

    // In the initialize method set the drive motors based on the PID controllers outputs
    @Override
    public void execute() {
        double straightPIDOutput = MathUtil.clamp(
            straightPIDController.calculate(req_subsystem.getDriveAngle(), straightSetpoint), 
            -12, 
            12
        );
        double distancePIDOutput = MathUtil.clamp(
            distancePIDController.calculate(req_subsystem.getDriveDistance(), distanceSetpoint), 
            -12, 
            12
        );
        if (straightPIDOutput < 0.0) {
            req_subsystem.setDriveBV(distancePIDOutput, distancePIDOutput - Math.abs(straightPIDOutput));
        } else {
            req_subsystem.setDriveBV(distancePIDOutput - Math.abs(straightPIDOutput), distancePIDOutput);
        }
    
    }
    
    // In the end method set the drive motors to 0
    @Override
    public void end(boolean interrupted) {
        req_subsystem.setDriveBV(0, 0);
    }

    // If the distance PID controller is at its setpoint then the command is finished 
    @Override
    public boolean isFinished() {
        return distancePIDController.atSetpoint();
    }

    

    


}