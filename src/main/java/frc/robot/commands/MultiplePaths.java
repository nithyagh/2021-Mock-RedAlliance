// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class MultiplePaths extends CommandBase {
  /** Creates a new MultiplePaths. */
  DriveTrain _driveTrain;

  Red _redPath;
  Blue _bluePath;
  Yellow _yellowPath;

  String _gameData;

  public MultiplePaths(DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    _driveTrain = driveTrain;
    addRequirements(_driveTrain);

    _redPath = new Red(_driveTrain);
    _bluePath = new Blue(_driveTrain);
    _yellowPath = new Yellow(_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _gameData = DriverStation.getInstance().getGameSpecificMessage();

    if(_gameData.equals("Red")) {
      _redPath.schedule();
    }
    else if(_gameData.equals("Blue")) {
      _bluePath.schedule();
    }
    else if(_gameData.equals("Yellow")) {
      _yellowPath.schedule();
    }

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
