// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  /** Creates a new DriveTrain. */
  WPI_TalonSRX _leftDriveTalon;
  WPI_TalonSRX _rightDriveTalon;

  AHRS _gyro;

  DifferentialDrive _diffDrive;

  // Make sure to set up ramp up time for the motors

  // distance that needs to be traveled in meters
  double _distance;
  double _encoderTicks;

  double _driveSpeed;

  public DriveTrain() {
    _leftDriveTalon = new WPI_TalonSRX(Constants.MotorPorts.LeftMotorPort);
    _rightDriveTalon = new WPI_TalonSRX(Constants.MotorPorts.RightMotorPort);

    _gyro = new AHRS(SPI.Port.kMXP);

    _leftDriveTalon.configFactoryDefault();
    _rightDriveTalon.configFactoryDefault();

    _leftDriveTalon.setInverted(false);
    _righttDriveTalon.setInverted(false);
    
    _leftDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    _rightDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);


    _leftDriveTalon.setSensorPhase(true);

    _leftDriveTalon.setNeutralMode(NeutralMode.Brake);
    _rightDriveTalon.setNeutralMode(NeutralMode.Brake);

    _leftDriveTalon.configClosedloopRamp(0.3);
    _rightDriveTalon.configClosedloopRamp(0.3);

    _diffDrive = new DifferentialDrive(_leftDriveTalon, _rightDriveTalon);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    printDrive();
    printGyro();
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    _diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void ArcadeDrive(double speed, double turn) {
    _diffDrive.arcadeDrive(speed, turn);
  }

  private void printDisplacement() {
    double _leftTraveled = Constants.Chassis.MetersPerEncoderTick * getLeftEncoderCount();
    double _rightTraveled = Constants.Chassis.MetersPerEncoderTick * getRightEncoderCount();
    double _averageTraveled = (_leftTraveled + _rightTraveled) / 2;

    SmartDashboard.putNumber("Left Displacement Meters", _leftTraveled);
    SmartDashboard.putNumber("Right Displacement Meters", _rightTraveled);
    SmartDashboard.putNumber("Average Displacement Meters", _averageTraveled);
  }

  private void printEncoderCount() {
    SmartDashboard.putNumber("Left Encoder Count", getLeftEncoderCount());
    SmartDashboard.putNumber("Right Encoder Count", getRightEncoderCount());
    SmartDashboard.putNumber("Average Encoder Count", getAverageEncoderCount());
  }

  private void printGyro() {
    SmartDashboard.putNumber("Angle", getAngle());
  }

  private void printDrive() {
    printEncoderCount();
    printDisplacement();
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
    return getAverageEncoderCount() * Constants.Chassis.MetersPerEncoderTick;
  }

  public double getAngle() {
    return _gyro.getAngle();
  }

  public void zeroDisplacement() {
    resetEncoders();
  }

  public void zeroHeading() {
    _gyro.zeroYaw();
  }

  public void resetEncoders() {
    _leftDriveTalon.setSelectedSensorPosition(0);
    _rightDriveTalon.setSelectedSensorPosition(0);
  }
}
