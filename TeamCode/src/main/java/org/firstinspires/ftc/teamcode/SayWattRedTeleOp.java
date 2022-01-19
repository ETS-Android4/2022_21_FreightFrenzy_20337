package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SayWattRedTeleOp3 (Blocks to Java)")
public class SayWattRedTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private CRServo grabber;
    private DcMotor arm;
    private DcMotor duckWheelBackright;
    private DcMotor LeftDuckWheel;
    private DcMotor armExtension;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        grabber = hardwareMap.get(CRServo.class, "grabber");
        arm = hardwareMap.get(DcMotor.class, "arm");
        duckWheelBackright = hardwareMap.get(DcMotor.class, "duckWheelBackright");
        LeftDuckWheel = hardwareMap.get(DcMotor.class, "LeftDuckWheel");
        armExtension = hardwareMap.get(DcMotor.class, "armExtension");

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
            if (gamepad1.left_bumper) {
                telemetry.addLine("Slowed Speed");
                telemetry.update();
                SpeedOfRobotLeftRight = 0.1;
                SpeedOfRobotUpDown = 0.2;
            } else if (gamepad1.right_bumper) {
                telemetry.addLine("Default Speed");
                telemetry.update();
                SpeedOfRobotLeftRight = 0.5;
                SpeedOfRobotUpDown = 0.8;
            } else {
                telemetry.addLine("Default Speed");
                telemetry.update();
                SpeedOfRobotLeftRight = 0.5;
                SpeedOfRobotUpDown = 0.8;
            }

            if (gamepad2.x) {
                grabber.setPower(1);
            } else {
                if (gamepad2.b) {
                    grabber.setPower(-1);
                } else {
                    grabber.setPower(0);
                }
            }
            if (gamepad2.y) {
                arm.setPower(1);
            } else {
                if (gamepad2.a) {
                    arm.setPower(-1);
                } else {
                    arm.setPower(0);
                }
            }
            if (gamepad1.a && gamepad1.x) {
                duckWheelBackright.setPower(0.9);
                LeftDuckWheel.setPower(0.9);
            } else if (gamepad1.a) {
                duckWheelBackright.setPower(-0.9);
                LeftDuckWheel.setPower(-0.9);
            } else {
                duckWheelBackright.setPower(0);
                LeftDuckWheel.setPower(0);
            }
            if (gamepad1.x && gamepad1.dpad_up) {
                frontLeft.setPower(0.6);
                frontRight.setPower(0.6);
                backLeft.setPower(0.6);
                backRight.setPower(0.6);
            } else {
                if (gamepad1.dpad_up) {
                    frontLeft.setPower(SpeedOfRobotUpDown);
                    frontRight.setPower(SpeedOfRobotUpDown);
                    backLeft.setPower(SpeedOfRobotUpDown);
                    backRight.setPower(SpeedOfRobotUpDown);
                } else if (gamepad1.x && gamepad1.dpad_down) {
                    frontLeft.setPower(-0.6);
                    frontRight.setPower(-0.6);
                    backLeft.setPower(-0.6);
                    backRight.setPower(-0.6);
                } else {
                    if (gamepad1.dpad_down) {
                        frontLeft.setPower(-SpeedOfRobotUpDown);
                        frontRight.setPower(-SpeedOfRobotUpDown);
                        backLeft.setPower(-SpeedOfRobotUpDown);
                        backRight.setPower(-SpeedOfRobotUpDown);
                    } else {
                        if (gamepad1.x && gamepad1.dpad_left) {
                            frontRight.setPower(0.8);
                            frontLeft.setPower(-0.8);
                            backRight.setPower(-0.8);
                            backLeft.setPower(0.8);
                        } else if (gamepad1.x && gamepad1.dpad_right) {
                            frontRight.setPower(-0.8);
                            frontLeft.setPower(0.8);
                            backRight.setPower(0.8);
                            backLeft.setPower(-0.8);
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
                            if (gamepad2.dpad_up) {
                                armExtension.setPower(200);
                                armExtension.setPower(0);
                            }
                            if (gamepad2.dpad_down) {
                                armExtension.setPower(-200);
                                armExtension.setPower(0);
                            }
                        }
                    }
                }
            }
            telemetry.update();
        }
    }
}