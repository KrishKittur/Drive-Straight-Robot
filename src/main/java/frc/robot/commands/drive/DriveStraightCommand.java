package frc.robot.commands.drive;

import static frc.robot.Constants.Drive.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.DriveSubsystem;

public class DriveStraightCommand extends CommandBase {

    // Declare the accessible variables
    PIDController driveStraightPID = new PIDController(DRIVE_STRAIGHT_KP, DRIVE_STRAIGHT_KI, DRIVE_STRAIGHT_KD);
    double voltageOuput = 12.0;
    double setPoint;
    DriveSubsystem req_subsystem;

    public DriveStraightCommand(DriveSubsystem subsystem) {
        // Add the subsystem to required subsystems
        req_subsystem = subsystem;
        addRequirements(subsystem);

        // Set the tolerance for the pid controller
        driveStraightPID.setTolerance(2, 1);
    }

    // In the initialize method set the set point
    @Override
    public void initialize() {
        setPoint = req_subsystem.getDriveAngle();
    }

    // In the execute method set the drive depending on the output of the pid controller
    @Override
    public void execute() {
        double outputPID = MathUtil.clamp(driveStraightPID.calculate(req_subsystem.getDriveAngle(), setPoint), -12, 12);
        if (outputPID < 0.0) {
            req_subsystem.setDriveBV(voltageOuput, voltageOuput - Math.abs(outputPID));
        } else {
            req_subsystem.setDriveBV(voltageOuput - Math.abs(outputPID), voltageOuput);
        }
    }

    // In the end method set the drive so that it does not move
    @Override
    public void end(boolean interrupted) {
        req_subsystem.setDriveBV(0, 0);
    }


}