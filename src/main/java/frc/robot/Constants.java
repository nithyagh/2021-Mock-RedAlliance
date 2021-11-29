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
    }

    public final class Robot {
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
    }

    public final class JoystickAxis {
        public static final int XAxis = 0;
        public static final int YAxis = 1;
    }
}
