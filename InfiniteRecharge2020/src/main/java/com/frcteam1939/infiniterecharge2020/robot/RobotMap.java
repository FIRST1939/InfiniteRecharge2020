
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot;

public class RobotMap {
  
  // Talons/Victors
    public static final int intakeTalon = 19;
    public static final int indexerVerticalTalon = 17;
    public static final int indexerHorizontalTalon = 20;
    public static final int leftBackFalcon = 41;
    public static final int leftFrontFalcon = 44;
    public static final int rightBackFalcon = 42;
    public static final int rightFrontFalcon = 43;
    public static final int turretTalon = 39;
    public static final int shooterFalcon1 = 37;
    public static final int shooterFalcon2 = 36;
    public static final int controlPanelTalon = 38;
    public static final int climberFalcon = 40;
    public static final int gondolaTalon = 28;

  // Solenoids
    public static final int PCM = 0;
    public static final int intakeSolenoid = 6;
    public static final int climberBrakeSolenoidForward = 4;
    public static final int climberBrakeSolenoidReverse = 5;
    public static final int shooterHoodBigSolenoid = 0;
    public static final int shooterHoodSmallSolenoid = 1;

  // Distance Sensors
    public static final int indexerBottomDistanceSensor = 0;
    public static final int indexerTopDistanceSensor = 1;

  // Digital Input
    public static final int turretClimberHallEffect = 5;
    public static final int turretClockwiseStopHallEffect = 8;
    public static final int turretCounterclockwiseStopHallEffect = 9;
    public static final int turretThroughBoreEncoder = 6;
    public static final int indexerVerticalThroughBoreEncoder = 7;
}