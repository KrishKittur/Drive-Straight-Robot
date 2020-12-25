package frc.robot;

import static frc.robot.Constants.Controller.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.drive.DriveStraightCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

  // Instantiate the global variables to this class
  XboxController main_controller = new XboxController(MAIN_CONTROLLER_CHANNEL);
  DriveSubsystem drive_subsystem = new DriveSubsystem();

  public RobotContainer() {
    // Call function to configure the button bindings
    configureButtonBindings();
  }

  // Function to configure the button bindings
  private void configureButtonBindings() {
    new JoystickButton(main_controller, Button.kA.value).whenHeld(
      new DriveStraightCommand(drive_subsystem)
    );
  }

  // Function to get the autonomus command
  public void getAutonomousCommand() {
    // Add the auto command here
  }
}
