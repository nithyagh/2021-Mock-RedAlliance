// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TurnToHeading extends CommandBase {
  /** Creates a new TurnToHeading. */
  DriveTrain _driveTrain;

  double _turnAngle;
  double _turnSpeed;

  boolean _finished;

  public TurnToHeading(DriveTrain driveTrain, double turnAngle, double turnSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    _driveTrain = driveTrain;
    addRequirements(_driveTrain);

    _turnAngle = turnAngle % 360;
    _turnSpeed = (_turnAngle >= 0 ? 1 : -1) * Math.abs(turnSpeed);

    _finished = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    displayStatus("Starting");
    _driveTrain.zeroHeading();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    displayStatus("In Progress");
    if(Math.abs(_driveTrain.getAngle()) < Math.abs(_turnAngle)) {
      _driveTrain.ArcadeDrive(0, _turnSpeed);
    }
    else {
      _finished = true;
      _driveTrain.ArcadeDrive(0, 0);
      displayStatus("Finished");
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    displayStatus("Ending");
    _driveTrain.ArcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _finished;
  }

  private void displayStatus(String status) {
    SmartDashboard.putString("Status", status);
  }
}
