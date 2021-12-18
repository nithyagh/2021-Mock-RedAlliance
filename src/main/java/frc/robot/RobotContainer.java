// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ActuateArm;
import frc.robot.commands.ActuateFork;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Blue;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.MultiplePaths;
import frc.robot.commands.PrintStatement;
import frc.robot.commands.Red;
import frc.robot.commands.TurnToHeading;
import frc.robot.commands.Yellow;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Fork;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */ 
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  DriveTrain _driveTrain = new DriveTrain();

  Fork _fork = new Fork();

  Arm _arm = new Arm();

  Joystick _joystick = new Joystick(Constants.USBOrder.Zero);

  Joystick _forkJoystick = new Joystick(Constants.USBOrder.One);

  Joystick _armJoystick = new Joystick(Constants.USBOrder.Two);

  ArcadeDrive _arcadeDrive = new ArcadeDrive(_driveTrain, _joystick);

  DriveDistance _driveDistance = new DriveDistance(_driveTrain, 1.88, 1.0);
  DriveDistance _driveDistance2 = new DriveDistance(_driveTrain, -1, 0.8);

  TurnToHeading _turntoHeading = new TurnToHeading(_driveTrain, 90, -0.5);
  TurnToHeading _turntoHeading2 = new TurnToHeading(_driveTrain, -405, 0.5);

  Red _redPath = new Red(_driveTrain);
  Blue _bluePath = new Blue(_driveTrain);
  Yellow _yellowPath = new Yellow(_driveTrain);

  ActuateFork _actuateFork = new ActuateFork(_fork, _forkJoystick);

  ActuateArm _actuateArm = new ActuateArm(_arm, _armJoystick); 

  SendableChooser<Command> _commandChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    _driveTrain.setDefaultCommand(_arcadeDrive);

    _fork.setDefaultCommand(_actuateFork);

    _arm.setDefaultCommand(_actuateArm);
    
    _commandChooser.setDefaultOption("Drive To Line", new DriveDistance(_driveTrain, 1.7, 0.7));
    _commandChooser.addOption("Multiple Paths", new MultiplePaths(_driveTrain));
    _commandChooser.addOption("Print Glass", new PrintStatement("Glass"));

    SmartDashboard.putData(_commandChooser);


    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton buttonA = new JoystickButton(_joystick, 1);
    JoystickButton buttonB = new JoystickButton(_joystick, 2);
    JoystickButton buttonC = new JoystickButton(_joystick, 3);
    JoystickButton buttonD = new JoystickButton(_joystick, 4);

    buttonA.whenPressed(new TurnToHeading(_driveTrain, 90, 0.5));
    buttonB.whenPressed(new TurnToHeading(_driveTrain, -90, 0.5));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return _commandChooser.getSelected();
  }
}
