package org.firstinspires.ftc.teamcode.basic;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="basic_bot")
@Config
public class basic_bot extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotorEx armDrive = null;
    private Servo leftServo;
    private Servo rightServo;

    public static int armTarget = 300;
    public static int armAway = -1;
    public static int armVelocity = 200;
    public static int armReset = 0;
    public static int armSpeed = 200;
    public int armPos;
    public static double leftClawOpen = 1;
    public static double leftClawClosed = 0.0;
    public static double rightClawOpen = 1;
    public static double rightClawClosed = 0.0;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        armDrive = hardwareMap.get(DcMotorEx.class, "arm_drive");
        leftServo = hardwareMap.get(Servo.class, "left_servo");
        rightServo = hardwareMap.get(Servo.class, "right_servo");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        leftServo.setDirection(Servo.Direction.FORWARD);
        rightServo.setDirection(Servo.Direction.REVERSE);

        armDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

        runtime.reset();
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());



        while (opModeIsActive()) {


            double leftPower;
            double rightPower;
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            armPos = armDrive.getCurrentPosition();


            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);


            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
//im only human after all im only human after all dont put the blame on me dont put the blame on me
            if (gamepad1.a) {

                armDrive.setTargetPosition(armTarget);

                armDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                armDrive.setVelocity(armVelocity);

            }
            if (gamepad1.x) {

                armDrive.setTargetPosition(armAway);

                armDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                armDrive.setVelocity(armVelocity+200);
            }
            if (gamepad1.y){
                armDrive.setTargetPosition(armPos);

                armDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                armDrive.setVelocity(0);
            }

                if (gamepad1.right_bumper) {
                    leftServo.setPosition(leftClawOpen);
                    rightServo.setPosition(rightClawOpen);

                }
                if (gamepad1.left_bumper) {
                    leftServo.setPosition(leftClawClosed);
                    rightServo.setPosition(rightClawClosed);
                }
                telemetry.addData("velocity", armDrive.getVelocity());
                telemetry.addData("encoderValue", armDrive.getCurrentPosition());

                telemetry.update();

                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
                telemetry.update();
            }
    }
    }