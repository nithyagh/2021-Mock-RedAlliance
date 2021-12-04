// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  WPI_TalonSRX _leftDriveTalon;
  WPI_TalonSRX _rightDriveTalon;

  DifferentialDrive _diffDrive;

  // Make sure to set up ramp up time for the motors

  // distance that needs to be traveled in meters
  double _distance;
  double _encoderTicks;

  double _driveSpeed;

  public DriveTrain() {
    _leftDriveTalon = new WPI_TalonSRX(Constants.MotorPorts.LeftMotorPort);
    _rightDriveTalon = new WPI_TalonSRX(Constants.MotorPorts.RightMotorPort);

    _leftDriveTalon.configFactoryDefault();
    _rightDriveTalon.configFactoryDefault();


    _leftDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    _rightDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    _leftDriveTalon.setSensorPhase(true);

    _diffDrive = new DifferentialDrive(_leftDriveTalon, _rightDriveTalon);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void TankDrive(double leftSpeed, double rightSpeed) {
    _diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void ArcadeDrive(double speed, double turn) {
    _diffDrive.arcadeDrive(speed, turn);
  }

 
  private double getLeftEncoderCount() {
    return _leftDriveTalon.getSelectedSensorPosition();
  }

  private double getRightEncoderCount() {
    return _rightDriveTalon.getSelectedSensorPosition();
  }

  private double getAverageEncoderCount() {
    return (getLeftEncoderCount() + getRightEncoderCount()) / 2;
  }

  public double getAverageDisplacement() {
    return getAverageEncoderCount() * Constants.Robot.MetersPerEncoderTick;
  }

  public void zeroDisplacement() {
    resetEncoders();
  }

  public void resetEncoders() {
    _leftDriveTalon.setSelectedSensorPosition(0);
    _rightDriveTalon.setSelectedSensorPosition(0);
  }
}
