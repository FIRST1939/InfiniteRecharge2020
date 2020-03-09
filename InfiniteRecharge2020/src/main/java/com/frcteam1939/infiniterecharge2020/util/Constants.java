/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.util;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * Add your docs here.
 */
public class Constants {

    public static final class DriveConstants {

        public static final double kTrackwidthMeters = 0;
        public static final DifferentialDriveKinematics kDriveKinematics =
            new DifferentialDriveKinematics(kTrackwidthMeters);
    
        public static final int kEncoderCPR = 0;
        public static final double kWheelDiameterMeters = 0;
        public static final double kEncoderDistancePerPulse =
            // Assumes the encoders are directly mounted on the wheel shafts
            (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;
    
        public static final boolean kGyroReversed = true;
    
    
        public static final double ksVolts = 0;
        public static final double kvVoltSecondsPerMeter = 0;
        public static final double kaVoltSecondsSquaredPerMeter = 0;
    
        // Example value only - as above, this must be tuned for your drive!
        public static final double kPDriveVel = 0;
      }

    public static final class PID_Constants{
        public static final double sF = 0;
        public static final double sP = .1;
        public static final double sI = 0;
        public static final double sD = 0;
        public static final double sPeakOutput = 0;
        public static final int sIzone = 0;
        public static final double sSensorUnitsPerRevolutions = 2048;

    }

    public static final int timeoutMs = 30;



}
