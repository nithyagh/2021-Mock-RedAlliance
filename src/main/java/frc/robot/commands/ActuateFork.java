// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Fork;

public class ActuateFork extends CommandBase {
  /** Creates a new ActuateFork. */
  Fork _fork;

  Joystick _joystick;

  double _moveSpeed = 0.2;

  public ActuateFork(Fork fork, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    _fork = fork;
    addRequirements(_fork);

    _joystick = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _fork.actuateMotor(-1 * Constants.Fork.MovementDampener * _joystick.getRawAxis(Constants.JoystickAxis.YAxis));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
