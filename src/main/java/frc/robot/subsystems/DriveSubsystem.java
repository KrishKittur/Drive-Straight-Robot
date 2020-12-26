
package frc.robot.subsystems;

import static frc.robot.Constants.Drive.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    // Instantiate the hardware
    private final CANSparkMax leftMotor = new CANSparkMax(DRIVE_LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(DRIVE_RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final AnalogGyro positionGyro = new AnalogGyro(DRIVE_GYRO_CHANNEL);
    private final Encoder distanceEncoder = new Encoder(DRIVE_ENCODER_CHANNEL_A, DRIVE_ENCODER_CHANNEL_B);

    public DriveSubsystem() {
        // Set the distance per pulse of the encoder
        distanceEncoder.setDistancePerPulse((2 * Math.PI * DRIVE_WHEEL_RADIUS)/DRIVE_ENCODER_RESOLUTION);
    }

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

    // Method to read the position gyros angle
    public double getDriveAngle() {
        return positionGyro.getAngle();
    }

    // Method to read the distance encoders distance
    public double getDriveDistance() {
        return distanceEncoder.getDistance();
    }
  
}