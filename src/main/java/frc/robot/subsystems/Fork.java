// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Fork extends SubsystemBase {
  /** Creates a new Fork. */

  WPI_TalonSRX _forkTalon;

  public Fork() {
    _forkTalon = new WPI_TalonSRX(Constants.MotorPorts.ForkMotorPort);

    _forkTalon.configFactoryDefault();

    _forkTalon.setInverted(false);

    _forkTalon.configNeutralDeadband(0.1);

    _forkTalon.setNeutralMode(NeutralMode.Brake);

    _forkTalon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
    _forkTalon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void actuateMotor(double moveSpeed) {
    // Test to see if VersaPlanetary Gearbox mechanically reverses the direction of rotation
    _forkTalon.set(ControlMode.PercentOutput, -1 * moveSpeed);
  }

  // public boolean isForkExtended() {
  //   // Test to see whether or not forward limit switch corresponds to extended movedrivement
  //   return (_forkTalon.isFwdLimitSwitchClosed() == 0);
  // }

  // public boolean isForkStowed() {
  //   // Test to see whether or not forward limit switch corresponds to stowed movement
  //   return (_forkTalon.isRevLimitSwitchClosed() == 0);
  // }
}
