// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Red extends SequentialCommandGroup {
  DriveTrain _driveTrain;
  /** Creates a new Red. */
  public Red(DriveTrain driveTrain) {
    _driveTrain = driveTrain;
  
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new DriveDistance(_driveTrain, 1, 0.5), new TurnToHeading(_driveTrain, 85, 0.5),
                new DriveDistance(_driveTrain, 1, 0.5), new TurnToHeading(_driveTrain, 85, 0.5),
                new DriveDistance(_driveTrain, 1, 0.5), new TurnToHeading(_driveTrain, 85, 0.5),
                new DriveDistance(_driveTrain, 1, 0.5), new TurnToHeading(_driveTrain, 85, 0.5));
  }
}
