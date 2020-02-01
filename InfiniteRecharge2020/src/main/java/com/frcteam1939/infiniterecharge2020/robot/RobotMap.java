
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C;

public class RobotMap {
  
  // Motors
    public static final int intakeTalon = 0;
    public static final int indexTalon1 = 0;
    public static final int indexTalon2 = 0;
    public static final int leftBackTalon = 0;
    public static final int leftFrontTalon = 0;
    public static final int rightBackTalon = 0;
    public static final int rightFrontTalon = 0;
    public static final int turretTalon = 0;
    public static final int shooterTalon1 = 0;
    public static final int shooterTalon2 = 0;
    public static final int controlPanelRedline = 0;
    public static final int climberTalon = 0;
    public static final int gondolaSnowblower = 0;

  //Solenoids
    public static final int PCM = 0;
    public static final int intakeSolenoid1 = 0;
    public static final int intakeSolenoid2= 0;
    public static final int drivetrainSolenoid = 0;
    public static final int shooterSolenoid1 = 0;
    public static final int shooterSolenoid2 = 0;

  // Analog Input
    public static final int intakeDistanceSensor = 0;
    public static final int indexDistanceSensor1 = 0;
    public static final int indexDistanceSensor2 = 0;
    public static final int indexDistanceSensor3 = 0;
    public static final int indexDistanceSensor4 = 0;
    public static final int indexDistanceSensor5 = 0;
    public static final int turretEncoder = 0;
    public static final int climberEncoder = 0;
    public static final int controlPanelManipulatorEncoder = 0;

  // Digital Input
    public static final int turretHallEffect = 0;

  // Digital Output

  // Other
    public static final SPI.Port navX = SPI.Port.kMXP;
    public static final I2C.Port colorSensor = I2C.Port.kOnboard;

}