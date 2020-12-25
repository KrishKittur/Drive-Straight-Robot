
package frc.robot.subsystems;

import static frc.robot.Constants.Drive.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    // Instantiate the hardware
    private final CANSparkMax leftMotor = new CANSparkMax(DRIVE_LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(DRIVE_RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final AnalogGyro positionGyro = new AnalogGyro(DRIVE_GYRO_CHANNEL);

    // Method to set the drive by percent
    public void setDriveBP(double leftPercent, double rightPercent) {
        leftMotor.set(leftPercent);
        rightMotor.set(rightPercent);
    }

    // Method to set the drive by voltage
    public void setDriveBV(double leftVoltage, double rightVoltage) {
        leftMotor.set(leftVoltage);
        rightMotor.set(rightVoltage);
    }

    // Method to read the gyros angle
    public double getDriveAngle() {
        return positionGyro.getAngle();
    }
  
}