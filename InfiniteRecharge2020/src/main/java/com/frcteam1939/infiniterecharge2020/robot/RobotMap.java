
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
  
  // Talons/Victors
    public static final int intakeTalon = 0;
    public static final int indexTalon1 = 0;
    public static final int indexTalon2 = 0;
    public static final int leftBackFalcon = 0;
    public static final int leftFrontFalcon = 0;
    public static final int rightBackFalcon = 0;
    public static final int rightFrontFalcon = 0;
    public static final int turretTalon = 0;
    public static final int shooterFalcon1 = 0;
    public static final int shooterFalcon2 = 0;
    public static final int controlPanelTalon = 0;
    public static final int climberFalcon = 0;
    public static final int gondolaTalon = 0;

  //Solenoids
    public static final int PCM = 0;
    public static final int intakeSolenoid1 = 0;
    public static final int intakeSolenoid2= 0;
    public static final int drivetrainSolenoid = 0;
    public static final int shooterSolenoid1 = 0;
    public static final int shooterSolenoid2 = 0;

  // Analog Input
    public static final int indexDistanceSensor1 = 0;
    public static final int indexDistanceSensor2 = 0;
    public static final int turretEncoder = 0;
    public static final int climberEncoder = 0;
    public static final int controlPanelEncoder = 0;

  // Digital Input
    public static final int turretHallEffect = 0;

  // Other
    public static final SPI.Port navX = SPI.Port.kMXP;
    public static final I2C.Port colorSensor = I2C.Port.kOnboard;

}