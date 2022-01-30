package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.motors.GoBILDA5201Series;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SayWattGreenTeleOp)")
public class SayWattGreenTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        // Put initialization blocks here.
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            double SpeedOfRobotUpDown = 0.8;
            double SpeedOfRobotLeftRight = 0.5;
            if (gamepad2.right_bumper) {
                telemetry.addLine("Drive: Slowed Speed");
                SpeedOfRobotLeftRight = 0.1;
                SpeedOfRobotUpDown = 0.2;
            } else {
                telemetry.addLine("Drive: Default Speed");
                SpeedOfRobotLeftRight = 0.1;
                SpeedOfRobotUpDown = 0.1;
            }



            {

            if (gamepad1.x && gamepad1.dpad_up) {
                frontLeft.setPower(0.6);
                frontRight.setPower(-0.6);
                backLeft.setPower(0.6);
                backRight.setPower(0.6);
            } else {
                if (gamepad1.dpad_up) {
                    frontLeft.setPower(SpeedOfRobotUpDown);
                    frontRight.setPower(SpeedOfRobotUpDown);
                    backLeft.setPower(SpeedOfRobotUpDown);
                    backRight.setPower(SpeedOfRobotUpDown);
                } else if (gamepad1.x && gamepad1.dpad_down) {
                    frontLeft.setPower(0.3);
                    frontRight.setPower(-0.3);
                    backLeft.setPower(-0.3);
                    backRight.setPower(0.3);
                } else {
                    if (gamepad1.dpad_down) {
                        frontLeft.setPower(-SpeedOfRobotUpDown);
                        frontRight.setPower(-SpeedOfRobotUpDown);
                        backLeft.setPower(-SpeedOfRobotUpDown);
                        backRight.setPower(-SpeedOfRobotUpDown);
                    } else {
                        if (gamepad1.right_bumper) {
                            frontRight.setPower(0.1);
                            frontLeft.setPower(-0.1);
                            backRight.setPower(-0.1);
                            backLeft.setPower(0.1);
                        } else if (gamepad1.left_bumper) {
                            frontRight.setPower(-0.1);
                            frontLeft.setPower(0.1);
                            backRight.setPower(0.1);
                            backLeft.setPower(-0.1);
                        } else {
                            if (gamepad1.dpad_right) {
                                frontRight.setPower(-SpeedOfRobotLeftRight);
                                frontLeft.setPower(SpeedOfRobotLeftRight);
                                backRight.setPower(-SpeedOfRobotLeftRight);
                                backLeft.setPower(SpeedOfRobotLeftRight);
                            } else if (gamepad1.dpad_left) {
                                frontRight.setPower(SpeedOfRobotLeftRight);
                                frontLeft.setPower(-SpeedOfRobotLeftRight);
                                backRight.setPower(SpeedOfRobotLeftRight);
                                backLeft.setPower(-SpeedOfRobotLeftRight);
                            } else {
                                frontLeft.setPower(0);
                                frontRight.setPower(0);
                                backLeft.setPower(0);
                                backRight.setPower(0);
                            }

                        }
                    }
                }
            }
            telemetry.update();
        }
    }
}}