// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final class MotorPorts {
        public static final int LeftMotorPort = 1;
        public static final int RightMotorPort = 2;
        public static final int ForkMotorPort = 3;
        public static final int ArmMotorPort = 4;
    }
  
    public static final class DriveTrainPorts {
        public static final int LeftDriveTalonPort = 1;
        public static final int RightDriveTalonPort = 2;
    } 

    public final class Fork {
        public static final double MovementDampener = 0.2;
    }

    public final class Arm {
        // Button ports
        public static final int StowedButton = 6;
        public static final int TopButton = 5;
        public static final int MiddleButton = 4;
        public static final int BottomButton = 3;

        // Calculated encoder ticks to reach certain positions
        public static final double StowedEncoderTicks = 0;
        public static final double TopEncoderTicks = 0;
        public static final double MiddleEncoderTicks = 0;
        public static final double BottomEncoderTicks = 0;

        // Angle of the arm to reach different positions
        public static final double StowedAngle = 0;
        public static final double TopAngle = 0;
        public static final double MiddleAngle = 0;
        public static final double BottomAngle = 0;

        public static final double RotateDampener = 0.4;
   }

    public final class Chassis {
        //Wheel diameter measured in inches
        public static final double WheelDiameterInches = 6;
        public static final double MetersPerInch = 0.0254;
        public static final double WheelCircumferenceMeters = WheelDiameterInches * Math.PI * 0.0254;
        public static final double EncoderTicksPerRevolution = 4096;
        public static final double EncoderTicksPerMeter = ((1 / MetersPerInch) / (WheelDiameterInches * Math.PI)) * EncoderTicksPerRevolution;
        public static final double MetersPerEncoderTick = WheelCircumferenceMeters / EncoderTicksPerRevolution;
     }

    public final class USBOrder {
        public static final int Zero = 0;
        public static final int One = 1;
        public static final int Two = 2;
    }

    public final class JoystickAxis {
        public static final int XAxis = 0;
        public static final int YAxis = 1;
    }
}
