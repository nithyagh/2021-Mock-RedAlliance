// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  WPI_TalonSRX _armTalon;
  public Arm() {
    _armTalon = new WPI_TalonSRX(Constants.MotorPorts.ArmMotorPort);

    _armTalon.configFactoryDefault();

    _armTalon.setInverted(false);

    _armTalon.configNeutralDeadband(0.1);

    _armTalon.setNeutralMode(NeutralMode.Brake);

    _armTalon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
    _armTalon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);

    _armTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void actuateArm(double moveSpeed) {
    _armTalon.set(ControlMode.PercentOutput, -1 * moveSpeed);
  }

  public double getPosition() {
    return _armTalon.getSelectedSensorPosition();
  }

  // public double angleToEncoderTicks(double angle) {
  //   return;
  // }

  // public double encoderTicksToAngle(double encoderTicks) {
  //   return;
  // }
}
