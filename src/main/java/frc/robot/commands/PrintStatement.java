// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PrintStatement extends CommandBase {
  /** Creates a new PrintStatement. */
  String _statement;
  public PrintStatement(String statement) {
    // Use addRequirements() here to declare subsystem dependencies.
    _statement = statement;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    String _gameData = DriverStation.getInstance().getGameSpecificMessage();
    SmartDashboard.putString("Printed", _gameData + " " + _statement);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
